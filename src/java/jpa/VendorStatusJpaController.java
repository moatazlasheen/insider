/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import entity.VendorStatus;
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
public class VendorStatusJpaController implements Serializable {

    public VendorStatusJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(VendorStatus vendorStatus) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(vendorStatus);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(VendorStatus vendorStatus) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            vendorStatus = em.merge(vendorStatus);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = vendorStatus.getVendorStatusId();
                if (findVendorStatus(id) == null) {
                    throw new NonexistentEntityException("The vendorStatus with id " + id + " no longer exists.");
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
            VendorStatus vendorStatus;
            try {
                vendorStatus = em.getReference(VendorStatus.class, id);
                vendorStatus.getVendorStatusId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The vendorStatus with id " + id + " no longer exists.", enfe);
            }
            em.remove(vendorStatus);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<VendorStatus> findVendorStatusEntities() {
        return findVendorStatusEntities(true, -1, -1);
    }

    public List<VendorStatus> findVendorStatusEntities(int maxResults, int firstResult) {
        return findVendorStatusEntities(false, maxResults, firstResult);
    }

    private List<VendorStatus> findVendorStatusEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(VendorStatus.class));
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

    public VendorStatus findVendorStatus(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(VendorStatus.class, id);
        } finally {
            em.close();
        }
    }

    public int getVendorStatusCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<VendorStatus> rt = cq.from(VendorStatus.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
