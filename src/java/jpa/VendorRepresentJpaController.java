/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import entity.VendorRepresent;
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
public class VendorRepresentJpaController implements Serializable {

    public VendorRepresentJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(VendorRepresent vendorRepresent) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(vendorRepresent);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(VendorRepresent vendorRepresent) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            vendorRepresent = em.merge(vendorRepresent);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = vendorRepresent.getVendorRepresentId();
                if (findVendorRepresent(id) == null) {
                    throw new NonexistentEntityException("The vendorRepresent with id " + id + " no longer exists.");
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
            VendorRepresent vendorRepresent;
            try {
                vendorRepresent = em.getReference(VendorRepresent.class, id);
                vendorRepresent.getVendorRepresentId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The vendorRepresent with id " + id + " no longer exists.", enfe);
            }
            em.remove(vendorRepresent);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<VendorRepresent> findVendorRepresentEntities() {
        return findVendorRepresentEntities(true, -1, -1);
    }

    public List<VendorRepresent> findVendorRepresentEntities(int maxResults, int firstResult) {
        return findVendorRepresentEntities(false, maxResults, firstResult);
    }

    private List<VendorRepresent> findVendorRepresentEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(VendorRepresent.class));
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

    public VendorRepresent findVendorRepresent(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(VendorRepresent.class, id);
        } finally {
            em.close();
        }
    }

    public int getVendorRepresentCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<VendorRepresent> rt = cq.from(VendorRepresent.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
