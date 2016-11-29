/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import dto.ItemDescriptionTypeWrapper;
import entity.ItemDescriptionType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
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
public class ItemDescriptionTypeJpaController implements Serializable {

    public ItemDescriptionTypeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ItemDescriptionType itemDescriptionType) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(itemDescriptionType);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ItemDescriptionType itemDescriptionType) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            itemDescriptionType = em.merge(itemDescriptionType);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = itemDescriptionType.getItemTypeId();
                if (findItemDescriptionType(id) == null) {
                    throw new NonexistentEntityException("The itemDescriptionType with id " + id + " no longer exists.");
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
            ItemDescriptionType itemDescriptionType;
            try {
                itemDescriptionType = em.getReference(ItemDescriptionType.class, id);
                itemDescriptionType.getItemTypeId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The itemDescriptionType with id " + id + " no longer exists.", enfe);
            }
            em.remove(itemDescriptionType);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ItemDescriptionType> findItemDescriptionTypeEntities() {
        return findItemDescriptionTypeEntities(true, -1, -1);
    }

    public List<ItemDescriptionType> findItemDescriptionTypeEntities(int maxResults, int firstResult) {
        return findItemDescriptionTypeEntities(false, maxResults, firstResult);
    }

    private List<ItemDescriptionType> findItemDescriptionTypeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ItemDescriptionType.class));
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

    public ItemDescriptionType findItemDescriptionType(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ItemDescriptionType.class, id);
        } finally {
            em.close();
        }
    }

    public int getItemDescriptionTypeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ItemDescriptionType> rt = cq.from(ItemDescriptionType.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public List<ItemDescriptionType> getAllTypes() {

        EntityManager em = getEntityManager();
        try {
            String materialQuery = "FROM ItemDescriptionType i";
            Query q = em.createQuery(materialQuery);
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public boolean saveItems(int[][] elements) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        if (elements.length <= 0) {
            return false;
        }

        for (int i = 0; i < elements.length; i++) {
            System.out.println("trace ids:" + elements[i][0]);
            em.persist(new ItemDescriptionType(elements[i][0], elements[i][1]));
        }

        em.getTransaction().commit();
        return true;
    }

    public List<ItemDescriptionTypeWrapper> getAllData() {
        EntityManager em = getEntityManager();
        String sql = "SELECT i.itemTypeId, m.materialCategouryDesc, mt.itemTypeDesc FROM ItemDescriptionType i, MaterialCategourt  m, MaterialType mt "
                + "WHERE i.materialCategoryId=m.materailCategouryId AND i.materialTypeId=mt.materialTypeId";
        Query query = em.createQuery(sql);
        List result = query.getResultList();
        List<ItemDescriptionTypeWrapper> itemWrappers = new ArrayList<ItemDescriptionTypeWrapper>();
        for (int i = 0; i < result.size(); i++) {
            Object[] obj = (Object[]) result.get(i);
            itemWrappers.add(new ItemDescriptionTypeWrapper(Integer.parseInt(obj[0].toString()), obj[1].toString() + " - " + obj[2].toString()));
        }
        return itemWrappers;
    }

    public void deleteItems(int[][] elements) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        String sql = "DELETE FROM ItemDescriptionType i WHERE i.itemTypeId IN (:list) ";
        Query query = em.createQuery(sql);
        query.setParameter("list", Arrays.asList(elements));
        query.executeUpdate();
        em.getTransaction().commit();

    }

}
