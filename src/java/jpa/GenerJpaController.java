/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import entity.Gener;
import java.io.Serializable;
import java.util.ArrayList;
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
 * @author ramy
 */
public class GenerJpaController implements Serializable {

    public GenerJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Gener gener) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(gener);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Gener gener) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            gener = em.merge(gener);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = gener.getGenerId();
                if (findGener(id) == null) {
                    throw new NonexistentEntityException("The gener with id " + id + " no longer exists.");
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
            Gener gener;
            try {
                gener = em.getReference(Gener.class, id);
                gener.getGenerId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The gener with id " + id + " no longer exists.", enfe);
            }
            em.remove(gener);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Gener> findGenerEntities() {
        return findGenerEntities(true, -1, -1);
    }

    public List<Gener> findGenerEntities(int maxResults, int firstResult) {
        return findGenerEntities(false, maxResults, firstResult);
    }

    private List<Gener> findGenerEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Gener.class));
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

    public Gener findGener(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Gener.class, id);
        } finally {
            em.close();
        }
    }

    public List<Gener> getAllGener() {
        EntityManager em = getEntityManager();
        try {
            String materialQuery = "FROM Gener g";
            Query q = em.createQuery(materialQuery);
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public int getGenerCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Gener> rt = cq.from(Gener.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
