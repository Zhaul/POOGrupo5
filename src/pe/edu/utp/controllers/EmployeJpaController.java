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
import pe.edu.utp.entity.CargoPersonal;
import pe.edu.utp.entity.Rol;
import pe.edu.utp.entity.Schedule;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import pe.edu.utp.controllers.exceptions.IllegalOrphanException;
import pe.edu.utp.controllers.exceptions.NonexistentEntityException;
import pe.edu.utp.entity.Employe;

/**
 *
 * @author zhaulvaldera
 */
public class EmployeJpaController implements Serializable {

    public EmployeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Employe employe) {
        if (employe.getScheduleList() == null) {
            employe.setScheduleList(new ArrayList<Schedule>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CargoPersonal idCargo = employe.getIdCargo();
            if (idCargo != null) {
                idCargo = em.getReference(idCargo.getClass(), idCargo.getId());
                employe.setIdCargo(idCargo);
            }
            Rol idRol = employe.getIdRol();
            if (idRol != null) {
                idRol = em.getReference(idRol.getClass(), idRol.getId());
                employe.setIdRol(idRol);
            }
            List<Schedule> attachedScheduleList = new ArrayList<Schedule>();
            for (Schedule scheduleListScheduleToAttach : employe.getScheduleList()) {
                scheduleListScheduleToAttach = em.getReference(scheduleListScheduleToAttach.getClass(), scheduleListScheduleToAttach.getId());
                attachedScheduleList.add(scheduleListScheduleToAttach);
            }
            employe.setScheduleList(attachedScheduleList);
            em.persist(employe);
            if (idCargo != null) {
                idCargo.getEmployeList().add(employe);
                idCargo = em.merge(idCargo);
            }
            if (idRol != null) {
                idRol.getEmployeList().add(employe);
                idRol = em.merge(idRol);
            }
            for (Schedule scheduleListSchedule : employe.getScheduleList()) {
                Employe oldIdEmployeOfScheduleListSchedule = scheduleListSchedule.getIdEmploye();
                scheduleListSchedule.setIdEmploye(employe);
                scheduleListSchedule = em.merge(scheduleListSchedule);
                if (oldIdEmployeOfScheduleListSchedule != null) {
                    oldIdEmployeOfScheduleListSchedule.getScheduleList().remove(scheduleListSchedule);
                    oldIdEmployeOfScheduleListSchedule = em.merge(oldIdEmployeOfScheduleListSchedule);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Employe employe) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Employe persistentEmploye = em.find(Employe.class, employe.getId());
            CargoPersonal idCargoOld = persistentEmploye.getIdCargo();
            CargoPersonal idCargoNew = employe.getIdCargo();
            Rol idRolOld = persistentEmploye.getIdRol();
            Rol idRolNew = employe.getIdRol();
            List<Schedule> scheduleListOld = persistentEmploye.getScheduleList();
            List<Schedule> scheduleListNew = employe.getScheduleList();
            List<String> illegalOrphanMessages = null;
            for (Schedule scheduleListOldSchedule : scheduleListOld) {
                if (!scheduleListNew.contains(scheduleListOldSchedule)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Schedule " + scheduleListOldSchedule + " since its idEmploye field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idCargoNew != null) {
                idCargoNew = em.getReference(idCargoNew.getClass(), idCargoNew.getId());
                employe.setIdCargo(idCargoNew);
            }
            if (idRolNew != null) {
                idRolNew = em.getReference(idRolNew.getClass(), idRolNew.getId());
                employe.setIdRol(idRolNew);
            }
            List<Schedule> attachedScheduleListNew = new ArrayList<Schedule>();
            for (Schedule scheduleListNewScheduleToAttach : scheduleListNew) {
                scheduleListNewScheduleToAttach = em.getReference(scheduleListNewScheduleToAttach.getClass(), scheduleListNewScheduleToAttach.getId());
                attachedScheduleListNew.add(scheduleListNewScheduleToAttach);
            }
            scheduleListNew = attachedScheduleListNew;
            employe.setScheduleList(scheduleListNew);
            employe = em.merge(employe);
            if (idCargoOld != null && !idCargoOld.equals(idCargoNew)) {
                idCargoOld.getEmployeList().remove(employe);
                idCargoOld = em.merge(idCargoOld);
            }
            if (idCargoNew != null && !idCargoNew.equals(idCargoOld)) {
                idCargoNew.getEmployeList().add(employe);
                idCargoNew = em.merge(idCargoNew);
            }
            if (idRolOld != null && !idRolOld.equals(idRolNew)) {
                idRolOld.getEmployeList().remove(employe);
                idRolOld = em.merge(idRolOld);
            }
            if (idRolNew != null && !idRolNew.equals(idRolOld)) {
                idRolNew.getEmployeList().add(employe);
                idRolNew = em.merge(idRolNew);
            }
            for (Schedule scheduleListNewSchedule : scheduleListNew) {
                if (!scheduleListOld.contains(scheduleListNewSchedule)) {
                    Employe oldIdEmployeOfScheduleListNewSchedule = scheduleListNewSchedule.getIdEmploye();
                    scheduleListNewSchedule.setIdEmploye(employe);
                    scheduleListNewSchedule = em.merge(scheduleListNewSchedule);
                    if (oldIdEmployeOfScheduleListNewSchedule != null && !oldIdEmployeOfScheduleListNewSchedule.equals(employe)) {
                        oldIdEmployeOfScheduleListNewSchedule.getScheduleList().remove(scheduleListNewSchedule);
                        oldIdEmployeOfScheduleListNewSchedule = em.merge(oldIdEmployeOfScheduleListNewSchedule);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = employe.getId();
                if (findEmploye(id) == null) {
                    throw new NonexistentEntityException("The employe with id " + id + " no longer exists.");
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
            Employe employe;
            try {
                employe = em.getReference(Employe.class, id);
                employe.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The employe with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Schedule> scheduleListOrphanCheck = employe.getScheduleList();
            for (Schedule scheduleListOrphanCheckSchedule : scheduleListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Employe (" + employe + ") cannot be destroyed since the Schedule " + scheduleListOrphanCheckSchedule + " in its scheduleList field has a non-nullable idEmploye field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            CargoPersonal idCargo = employe.getIdCargo();
            if (idCargo != null) {
                idCargo.getEmployeList().remove(employe);
                idCargo = em.merge(idCargo);
            }
            Rol idRol = employe.getIdRol();
            if (idRol != null) {
                idRol.getEmployeList().remove(employe);
                idRol = em.merge(idRol);
            }
            em.remove(employe);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Employe> findEmployeEntities() {
        return findEmployeEntities(true, -1, -1);
    }

    public List<Employe> findEmployeEntities(int maxResults, int firstResult) {
        return findEmployeEntities(false, maxResults, firstResult);
    }

    private List<Employe> findEmployeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Employe.class));
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

    public Employe findEmploye(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Employe.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmployeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Employe> rt = cq.from(Employe.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
