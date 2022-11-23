/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.controllers;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import pe.edu.utp.controllers.exceptions.NonexistentEntityException;
import pe.edu.utp.entity.Justification;
import pe.edu.utp.entity.Schedule;

/**
 *
 * @author zhaul
 */
public class JustificationJpaController implements Serializable {

    public JustificationJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Justification justification) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Schedule idShedule = justification.getIdShedule();
            if (idShedule != null) {
                idShedule = em.getReference(idShedule.getClass(), idShedule.getId());
                justification.setIdShedule(idShedule);
            }
            em.persist(justification);
            if (idShedule != null) {
                idShedule.getJustificationList().add(justification);
                idShedule = em.merge(idShedule);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Justification justification) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Justification persistentJustification = em.find(Justification.class, justification.getId());
            Schedule idSheduleOld = persistentJustification.getIdShedule();
            Schedule idSheduleNew = justification.getIdShedule();
            if (idSheduleNew != null) {
                idSheduleNew = em.getReference(idSheduleNew.getClass(), idSheduleNew.getId());
                justification.setIdShedule(idSheduleNew);
            }
            justification = em.merge(justification);
            if (idSheduleOld != null && !idSheduleOld.equals(idSheduleNew)) {
                idSheduleOld.getJustificationList().remove(justification);
                idSheduleOld = em.merge(idSheduleOld);
            }
            if (idSheduleNew != null && !idSheduleNew.equals(idSheduleOld)) {
                idSheduleNew.getJustificationList().add(justification);
                idSheduleNew = em.merge(idSheduleNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = justification.getId();
                if (findJustification(id) == null) {
                    throw new NonexistentEntityException("The justification with id " + id + " no longer exists.");
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
            Justification justification;
            try {
                justification = em.getReference(Justification.class, id);
                justification.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The justification with id " + id + " no longer exists.", enfe);
            }
            Schedule idShedule = justification.getIdShedule();
            if (idShedule != null) {
                idShedule.getJustificationList().remove(justification);
                idShedule = em.merge(idShedule);
            }
            em.remove(justification);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Justification> findJustificationEntities() {
        return findJustificationEntities(true, -1, -1);
    }

    public List<Justification> findJustificationEntities(int maxResults, int firstResult) {
        return findJustificationEntities(false, maxResults, firstResult);
    }

    private List<Justification> findJustificationEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Justification.class));
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

    public Justification findJustification(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Justification.class, id);
        } finally {
            em.close();
        }
    }

    public int getJustificationCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Justification> rt = cq.from(Justification.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
