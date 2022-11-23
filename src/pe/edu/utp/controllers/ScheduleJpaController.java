/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.controllers;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import pe.edu.utp.entity.Employe;
import pe.edu.utp.entity.Justification;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import pe.edu.utp.controllers.exceptions.IllegalOrphanException;
import pe.edu.utp.controllers.exceptions.NonexistentEntityException;
import pe.edu.utp.entity.Schedule;

/**
 *
 * @author zhaul
 */
public class ScheduleJpaController implements Serializable {

    public ScheduleJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Schedule schedule) {
        if (schedule.getJustificationList() == null) {
            schedule.setJustificationList(new ArrayList<Justification>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Employe idEmploye = schedule.getIdEmploye();
            if (idEmploye != null) {
                idEmploye = em.getReference(idEmploye.getClass(), idEmploye.getId());
                schedule.setIdEmploye(idEmploye);
            }
            List<Justification> attachedJustificationList = new ArrayList<Justification>();
            for (Justification justificationListJustificationToAttach : schedule.getJustificationList()) {
                justificationListJustificationToAttach = em.getReference(justificationListJustificationToAttach.getClass(), justificationListJustificationToAttach.getId());
                attachedJustificationList.add(justificationListJustificationToAttach);
            }
            schedule.setJustificationList(attachedJustificationList);
            em.persist(schedule);
            if (idEmploye != null) {
                idEmploye.getScheduleList().add(schedule);
                idEmploye = em.merge(idEmploye);
            }
            for (Justification justificationListJustification : schedule.getJustificationList()) {
                Schedule oldIdSheduleOfJustificationListJustification = justificationListJustification.getIdShedule();
                justificationListJustification.setIdShedule(schedule);
                justificationListJustification = em.merge(justificationListJustification);
                if (oldIdSheduleOfJustificationListJustification != null) {
                    oldIdSheduleOfJustificationListJustification.getJustificationList().remove(justificationListJustification);
                    oldIdSheduleOfJustificationListJustification = em.merge(oldIdSheduleOfJustificationListJustification);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Schedule schedule) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Schedule persistentSchedule = em.find(Schedule.class, schedule.getId());
            Employe idEmployeOld = persistentSchedule.getIdEmploye();
            Employe idEmployeNew = schedule.getIdEmploye();
            List<Justification> justificationListOld = persistentSchedule.getJustificationList();
            List<Justification> justificationListNew = schedule.getJustificationList();
            List<String> illegalOrphanMessages = null;
            for (Justification justificationListOldJustification : justificationListOld) {
                if (!justificationListNew.contains(justificationListOldJustification)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Justification " + justificationListOldJustification + " since its idShedule field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idEmployeNew != null) {
                idEmployeNew = em.getReference(idEmployeNew.getClass(), idEmployeNew.getId());
                schedule.setIdEmploye(idEmployeNew);
            }
            List<Justification> attachedJustificationListNew = new ArrayList<Justification>();
            for (Justification justificationListNewJustificationToAttach : justificationListNew) {
                justificationListNewJustificationToAttach = em.getReference(justificationListNewJustificationToAttach.getClass(), justificationListNewJustificationToAttach.getId());
                attachedJustificationListNew.add(justificationListNewJustificationToAttach);
            }
            justificationListNew = attachedJustificationListNew;
            schedule.setJustificationList(justificationListNew);
            schedule = em.merge(schedule);
            if (idEmployeOld != null && !idEmployeOld.equals(idEmployeNew)) {
                idEmployeOld.getScheduleList().remove(schedule);
                idEmployeOld = em.merge(idEmployeOld);
            }
            if (idEmployeNew != null && !idEmployeNew.equals(idEmployeOld)) {
                idEmployeNew.getScheduleList().add(schedule);
                idEmployeNew = em.merge(idEmployeNew);
            }
            for (Justification justificationListNewJustification : justificationListNew) {
                if (!justificationListOld.contains(justificationListNewJustification)) {
                    Schedule oldIdSheduleOfJustificationListNewJustification = justificationListNewJustification.getIdShedule();
                    justificationListNewJustification.setIdShedule(schedule);
                    justificationListNewJustification = em.merge(justificationListNewJustification);
                    if (oldIdSheduleOfJustificationListNewJustification != null && !oldIdSheduleOfJustificationListNewJustification.equals(schedule)) {
                        oldIdSheduleOfJustificationListNewJustification.getJustificationList().remove(justificationListNewJustification);
                        oldIdSheduleOfJustificationListNewJustification = em.merge(oldIdSheduleOfJustificationListNewJustification);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = schedule.getId();
                if (findSchedule(id) == null) {
                    throw new NonexistentEntityException("The schedule with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Schedule schedule;
            try {
                schedule = em.getReference(Schedule.class, id);
                schedule.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The schedule with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Justification> justificationListOrphanCheck = schedule.getJustificationList();
            for (Justification justificationListOrphanCheckJustification : justificationListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Schedule (" + schedule + ") cannot be destroyed since the Justification " + justificationListOrphanCheckJustification + " in its justificationList field has a non-nullable idShedule field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Employe idEmploye = schedule.getIdEmploye();
            if (idEmploye != null) {
                idEmploye.getScheduleList().remove(schedule);
                idEmploye = em.merge(idEmploye);
            }
            em.remove(schedule);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Schedule> findScheduleEntities() {
        return findScheduleEntities(true, -1, -1);
    }

    public List<Schedule> findScheduleEntities(int maxResults, int firstResult) {
        return findScheduleEntities(false, maxResults, firstResult);
    }

    private List<Schedule> findScheduleEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Schedule.class));
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

    public Schedule findSchedule(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Schedule.class, id);
        } finally {
            em.close();
        }
    }

    public int getScheduleCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Schedule> rt = cq.from(Schedule.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
