/*
GPL * Copyright (C) 2016 mrnull <ahmadmoawad3@gmail.com>
GPL *
GPL * This program is free software; you can redistribute it and/or
GPL * modify it under the terms of the GNU General Public License
GPL * as published by the Free Software Foundation; either version 2
GPL * of the License, or (at your option) any later version.
 */

package jpa;

import entity.GenerMaterials;
import entity.GenerMaterialsPK;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.exceptions.NonexistentEntityException;
import jpa.exceptions.PreexistingEntityException;

/**
 * @author mrnull <ahmadmoawad3@gmail.com>
 */
public class GenerMaterialsJpaController implements Serializable {

    public GenerMaterialsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(GenerMaterials generMaterials) throws PreexistingEntityException, Exception {
        if (generMaterials.getGenerMaterialsPK() == null) {
            generMaterials.setGenerMaterialsPK(new GenerMaterialsPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(generMaterials);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findGenerMaterials(generMaterials.getGenerMaterialsPK()) != null) {
                throw new PreexistingEntityException("GenerMaterials " + generMaterials + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(GenerMaterials generMaterials) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            generMaterials = em.merge(generMaterials);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                GenerMaterialsPK id = generMaterials.getGenerMaterialsPK();
                if (findGenerMaterials(id) == null) {
                    throw new NonexistentEntityException("The generMaterials with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(GenerMaterialsPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            GenerMaterials generMaterials;
            try {
                generMaterials = em.getReference(GenerMaterials.class, id);
                generMaterials.getGenerMaterialsPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The generMaterials with id " + id + " no longer exists.", enfe);
            }
            em.remove(generMaterials);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<GenerMaterials> findGenerMaterialsEntities() {
        return findGenerMaterialsEntities(true, -1, -1);
    }

    public List<GenerMaterials> findGenerMaterialsEntities(int maxResults, int firstResult) {
        return findGenerMaterialsEntities(false, maxResults, firstResult);
    }

    private List<GenerMaterials> findGenerMaterialsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(GenerMaterials.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public GenerMaterials findGenerMaterials(GenerMaterialsPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(GenerMaterials.class, id);
        } finally {
            em.close();
        }
    }

    public int getGenerMaterialsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<GenerMaterials> rt = cq.from(GenerMaterials.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
