/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import entity.MaterialRequest;
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
public class MaterialRequestJpaController implements Serializable {

    public MaterialRequestJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(MaterialRequest materialRequest) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(materialRequest);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(MaterialRequest materialRequest) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            materialRequest = em.merge(materialRequest);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = materialRequest.getMrId();
                if (findMaterialRequest(id) == null) {
                    throw new NonexistentEntityException("The materialRequest with id " + id + " no longer exists.");
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
            MaterialRequest materialRequest;
            try {
                materialRequest = em.getReference(MaterialRequest.class, id);
                materialRequest.getMrId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The materialRequest with id " + id + " no longer exists.", enfe);
            }
            em.remove(materialRequest);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<MaterialRequest> findMaterialRequestEntities() {
        return findMaterialRequestEntities(true, -1, -1);
    }

    public List<MaterialRequest> findMaterialRequestEntities(int maxResults, int firstResult) {
        return findMaterialRequestEntities(false, maxResults, firstResult);
    }

    private List<MaterialRequest> findMaterialRequestEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(MaterialRequest.class));
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

    public MaterialRequest findMaterialRequest(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(MaterialRequest.class, id);
        } finally {
            em.close();
        }
    }

    public int getMaterialRequestCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<MaterialRequest> rt = cq.from(MaterialRequest.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
