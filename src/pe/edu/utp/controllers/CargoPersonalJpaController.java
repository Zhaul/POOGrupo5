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
import pe.edu.utp.entity.Area;
import pe.edu.utp.entity.Employe;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import pe.edu.utp.controllers.exceptions.IllegalOrphanException;
import pe.edu.utp.controllers.exceptions.NonexistentEntityException;
import pe.edu.utp.entity.CargoPersonal;

/**
 *
 * @author zhaulvaldera
 */
public class CargoPersonalJpaController implements Serializable {

    public CargoPersonalJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CargoPersonal cargoPersonal) {
        if (cargoPersonal.getEmployeList() == null) {
            cargoPersonal.setEmployeList(new ArrayList<Employe>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Area idArea = cargoPersonal.getIdArea();
            if (idArea != null) {
                idArea = em.getReference(idArea.getClass(), idArea.getId());
                cargoPersonal.setIdArea(idArea);
            }
            List<Employe> attachedEmployeList = new ArrayList<Employe>();
            for (Employe employeListEmployeToAttach : cargoPersonal.getEmployeList()) {
                employeListEmployeToAttach = em.getReference(employeListEmployeToAttach.getClass(), employeListEmployeToAttach.getId());
                attachedEmployeList.add(employeListEmployeToAttach);
            }
            cargoPersonal.setEmployeList(attachedEmployeList);
            em.persist(cargoPersonal);
            if (idArea != null) {
                idArea.getCargoPersonalList().add(cargoPersonal);
                idArea = em.merge(idArea);
            }
            for (Employe employeListEmploye : cargoPersonal.getEmployeList()) {
                CargoPersonal oldIdCargoOfEmployeListEmploye = employeListEmploye.getIdCargo();
                employeListEmploye.setIdCargo(cargoPersonal);
                employeListEmploye = em.merge(employeListEmploye);
                if (oldIdCargoOfEmployeListEmploye != null) {
                    oldIdCargoOfEmployeListEmploye.getEmployeList().remove(employeListEmploye);
                    oldIdCargoOfEmployeListEmploye = em.merge(oldIdCargoOfEmployeListEmploye);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CargoPersonal cargoPersonal) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CargoPersonal persistentCargoPersonal = em.find(CargoPersonal.class, cargoPersonal.getId());
            Area idAreaOld = persistentCargoPersonal.getIdArea();
            Area idAreaNew = cargoPersonal.getIdArea();
            List<Employe> employeListOld = persistentCargoPersonal.getEmployeList();
            List<Employe> employeListNew = cargoPersonal.getEmployeList();
            List<String> illegalOrphanMessages = null;
            for (Employe employeListOldEmploye : employeListOld) {
                if (!employeListNew.contains(employeListOldEmploye)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Employe " + employeListOldEmploye + " since its idCargo field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idAreaNew != null) {
                idAreaNew = em.getReference(idAreaNew.getClass(), idAreaNew.getId());
                cargoPersonal.setIdArea(idAreaNew);
            }
            List<Employe> attachedEmployeListNew = new ArrayList<Employe>();
            for (Employe employeListNewEmployeToAttach : employeListNew) {
                employeListNewEmployeToAttach = em.getReference(employeListNewEmployeToAttach.getClass(), employeListNewEmployeToAttach.getId());
                attachedEmployeListNew.add(employeListNewEmployeToAttach);
            }
            employeListNew = attachedEmployeListNew;
            cargoPersonal.setEmployeList(employeListNew);
            cargoPersonal = em.merge(cargoPersonal);
            if (idAreaOld != null && !idAreaOld.equals(idAreaNew)) {
                idAreaOld.getCargoPersonalList().remove(cargoPersonal);
                idAreaOld = em.merge(idAreaOld);
            }
            if (idAreaNew != null && !idAreaNew.equals(idAreaOld)) {
                idAreaNew.getCargoPersonalList().add(cargoPersonal);
                idAreaNew = em.merge(idAreaNew);
            }
            for (Employe employeListNewEmploye : employeListNew) {
                if (!employeListOld.contains(employeListNewEmploye)) {
                    CargoPersonal oldIdCargoOfEmployeListNewEmploye = employeListNewEmploye.getIdCargo();
                    employeListNewEmploye.setIdCargo(cargoPersonal);
                    employeListNewEmploye = em.merge(employeListNewEmploye);
                    if (oldIdCargoOfEmployeListNewEmploye != null && !oldIdCargoOfEmployeListNewEmploye.equals(cargoPersonal)) {
                        oldIdCargoOfEmployeListNewEmploye.getEmployeList().remove(employeListNewEmploye);
                        oldIdCargoOfEmployeListNewEmploye = em.merge(oldIdCargoOfEmployeListNewEmploye);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = cargoPersonal.getId();
                if (findCargoPersonal(id) == null) {
                    throw new NonexistentEntityException("The cargoPersonal with id " + id + " no longer exists.");
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
            CargoPersonal cargoPersonal;
            try {
                cargoPersonal = em.getReference(CargoPersonal.class, id);
                cargoPersonal.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cargoPersonal with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Employe> employeListOrphanCheck = cargoPersonal.getEmployeList();
            for (Employe employeListOrphanCheckEmploye : employeListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This CargoPersonal (" + cargoPersonal + ") cannot be destroyed since the Employe " + employeListOrphanCheckEmploye + " in its employeList field has a non-nullable idCargo field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Area idArea = cargoPersonal.getIdArea();
            if (idArea != null) {
                idArea.getCargoPersonalList().remove(cargoPersonal);
                idArea = em.merge(idArea);
            }
            em.remove(cargoPersonal);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CargoPersonal> findCargoPersonalEntities() {
        return findCargoPersonalEntities(true, -1, -1);
    }

    public List<CargoPersonal> findCargoPersonalEntities(int maxResults, int firstResult) {
        return findCargoPersonalEntities(false, maxResults, firstResult);
    }

    private List<CargoPersonal> findCargoPersonalEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CargoPersonal.class));
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

    public CargoPersonal findCargoPersonal(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CargoPersonal.class, id);
        } finally {
            em.close();
        }
    }

    public int getCargoPersonalCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CargoPersonal> rt = cq.from(CargoPersonal.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
