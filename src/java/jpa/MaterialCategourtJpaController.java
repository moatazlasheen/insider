/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import entity.MaterialCategourt;
import entity.MaterialType;
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
 * @author ramy
 */
public class MaterialCategourtJpaController implements Serializable {

    public MaterialCategourtJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(MaterialCategourt materialCategourt) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(materialCategourt);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(MaterialCategourt materialCategourt) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            materialCategourt = em.merge(materialCategourt);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = materialCategourt.getMaterailCategouryId();
                if (findMaterialCategourt(id) == null) {
                    throw new NonexistentEntityException("The materialCategourt with id " + id + " no longer exists.");
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
            MaterialCategourt materialCategourt;
            try {
                materialCategourt = em.getReference(MaterialCategourt.class, id);
                materialCategourt.getMaterailCategouryId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The materialCategourt with id " + id + " no longer exists.", enfe);
            }
            em.remove(materialCategourt);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<MaterialCategourt> findMaterialCategourtEntities() {
        return findMaterialCategourtEntities(true, -1, -1);
    }

    public List<MaterialCategourt> findMaterialCategourtEntities(int maxResults, int firstResult) {
        return findMaterialCategourtEntities(false, maxResults, firstResult);
    }

    private List<MaterialCategourt> findMaterialCategourtEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(MaterialCategourt.class));
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

    public MaterialCategourt findMaterialCategourt(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(MaterialCategourt.class, id);
        } finally {
            em.close();
        }
    }

    public int getMaterialCategourtCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<MaterialCategourt> rt = cq.from(MaterialCategourt.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public List<MaterialType> getAllMaterialsByCat(Integer catID) {
        EntityManager em = getEntityManager();
        try {
            String sql = "FROM MaterialCategourt m";
            em.createQuery(sql);
            Query query = em.createQuery(sql);
            List materialIDs = query.getResultList();
            sql = "FROM MaterialType m WHERE m.materialTypeId in(" + materialIDs
                    + ")";
            query = em.createQuery(sql);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

}
