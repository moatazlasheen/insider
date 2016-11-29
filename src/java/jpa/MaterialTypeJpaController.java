/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import entity.MaterialCategourt;
import entity.MaterialType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.exceptions.NonexistentEntityException;
import model.cons;

/**
 *
 * @author ramy
 */
public class MaterialTypeJpaController implements Serializable {

    public MaterialTypeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public MaterialTypeJpaController() {
        this.emf = Persistence.createEntityManagerFactory(cons.entityName);
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(MaterialType materialType) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(materialType);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(MaterialType materialType) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            materialType = em.merge(materialType);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = materialType.getMaterialTypeId();
                if (findMaterialType(id) == null) {
                    throw new NonexistentEntityException("The materialType with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            MaterialType materialType;
            try {
                materialType = em.getReference(MaterialType.class, id);
                materialType.getMaterialTypeId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The materialType with id " + id + " no longer exists.", enfe);
            }
            em.remove(materialType);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<MaterialType> findMaterialTypeEntities() {
        return findMaterialTypeEntities(true, -1, -1);
    }

    public List<MaterialType> findMaterialTypeEntities(int maxResults, int firstResult) {
        return findMaterialTypeEntities(false, maxResults, firstResult);
    }

    private List<MaterialType> findMaterialTypeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(MaterialType.class));
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

    public MaterialType findMaterialType(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(MaterialType.class, id);
        } finally {
            em.close();
        }
    }

    public List<MaterialType> getAllMaterials() {

        EntityManager em = getEntityManager();
        try {
            String materialQuery = "FROM MaterialType m";
            Query q = em.createQuery(materialQuery);
            return q.getResultList();
        } finally {
            em.close();
        }

    }

    public int getMaterialTypeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<MaterialType> rt = cq.from(MaterialType.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public boolean materialTypeExists(String description) {
        boolean exists = false;
        if (description != null) {
            EntityManager em = getEntityManager();
            try {
                MaterialType a = (MaterialType) em.createQuery("SELECT m FROM MaterialType m WHERE m.itemTypeDesc = :itemTypeDesc").setParameter("itemTypeDesc", description.trim()).getSingleResult();
                exists = true;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                em.close();
            }
        }

        return exists;
    }

}
