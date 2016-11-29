/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dump.jpa;

import entity.ItemDescription;
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
public class ItemDescriptionJpaController implements Serializable {

    public ItemDescriptionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ItemDescription itemDescription) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(itemDescription);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ItemDescription itemDescription) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            itemDescription = em.merge(itemDescription);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = itemDescription.getItemId();
                if (findItemDescription(id) == null) {
                    throw new NonexistentEntityException("The itemDescription with id " + id + " no longer exists.");
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
            ItemDescription itemDescription;
            try {
                itemDescription = em.getReference(ItemDescription.class, id);
                itemDescription.getItemId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The itemDescription with id " + id + " no longer exists.", enfe);
            }
            em.remove(itemDescription);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ItemDescription> findItemDescriptionEntities() {
        return findItemDescriptionEntities(true, -1, -1);
    }

    public List<ItemDescription> findItemDescriptionEntities(int maxResults, int firstResult) {
        return findItemDescriptionEntities(false, maxResults, firstResult);
    }

    private List<ItemDescription> findItemDescriptionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ItemDescription.class));
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

    public ItemDescription findItemDescription(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ItemDescription.class, id);
        } finally {
            em.close();
        }
    }

    public int getItemDescriptionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ItemDescription> rt = cq.from(ItemDescription.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
