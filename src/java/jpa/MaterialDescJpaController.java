/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import entity.MaterialDesc;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.exceptions.NonexistentEntityException;

/**
 *
 * @author elsaidel
 */
public class MaterialDescJpaController implements Serializable {

    public MaterialDescJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(MaterialDesc materialDesc) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(materialDesc);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(MaterialDesc materialDesc) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            materialDesc = em.merge(materialDesc);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = materialDesc.getMaterialId();
                if (findMaterialDesc(id) == null) {
                    throw new NonexistentEntityException("The materialDesc with id " + id + " no longer exists.");
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
            MaterialDesc materialDesc;
            try {
                materialDesc = em.getReference(MaterialDesc.class, id);
                materialDesc.getMaterialId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The materialDesc with id " + id + " no longer exists.", enfe);
            }
            em.remove(materialDesc);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<MaterialDesc> findMaterialDescEntities() {
        return findMaterialDescEntities(true, -1, -1);
    }

    public List<MaterialDesc> findMaterialDescEntities(int maxResults, int firstResult) {
        return findMaterialDescEntities(false, maxResults, firstResult);
    }

    private List<MaterialDesc> findMaterialDescEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(MaterialDesc.class));
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

    public MaterialDesc findMaterialDesc(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(MaterialDesc.class, id);
        } finally {
            em.close();
        }
    }

    public int getMaterialDescCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<MaterialDesc> rt = cq.from(MaterialDesc.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
