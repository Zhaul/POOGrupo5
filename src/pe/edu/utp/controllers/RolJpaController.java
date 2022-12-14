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
import pe.edu.utp.entity.Permiso;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import pe.edu.utp.controllers.exceptions.IllegalOrphanException;
import pe.edu.utp.controllers.exceptions.NonexistentEntityException;
import pe.edu.utp.entity.Employe;
import pe.edu.utp.entity.Rol;

/**
 *
 * @author zhaul
 */
public class RolJpaController implements Serializable {

    public RolJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public RolJpaController() {
        this.emf = Persistence.createEntityManagerFactory("POOGrupo5PU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Rol rol) {
        if (rol.getPermisoList() == null) {
            rol.setPermisoList(new ArrayList<Permiso>());
        }
        if (rol.getEmployeList() == null) {
            rol.setEmployeList(new ArrayList<Employe>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Permiso> attachedPermisoList = new ArrayList<Permiso>();
            for (Permiso permisoListPermisoToAttach : rol.getPermisoList()) {
                permisoListPermisoToAttach = em.getReference(permisoListPermisoToAttach.getClass(), permisoListPermisoToAttach.getId());
                attachedPermisoList.add(permisoListPermisoToAttach);
            }
            rol.setPermisoList(attachedPermisoList);
            List<Employe> attachedEmployeList = new ArrayList<Employe>();
            for (Employe employeListEmployeToAttach : rol.getEmployeList()) {
                employeListEmployeToAttach = em.getReference(employeListEmployeToAttach.getClass(), employeListEmployeToAttach.getId());
                attachedEmployeList.add(employeListEmployeToAttach);
            }
            rol.setEmployeList(attachedEmployeList);
            em.persist(rol);
            for (Permiso permisoListPermiso : rol.getPermisoList()) {
                permisoListPermiso.getRolList().add(rol);
                permisoListPermiso = em.merge(permisoListPermiso);
            }
            for (Employe employeListEmploye : rol.getEmployeList()) {
                Rol oldIdRolOfEmployeListEmploye = employeListEmploye.getIdRol();
                employeListEmploye.setIdRol(rol);
                employeListEmploye = em.merge(employeListEmploye);
                if (oldIdRolOfEmployeListEmploye != null) {
                    oldIdRolOfEmployeListEmploye.getEmployeList().remove(employeListEmploye);
                    oldIdRolOfEmployeListEmploye = em.merge(oldIdRolOfEmployeListEmploye);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Rol rol) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Rol persistentRol = em.find(Rol.class, rol.getId());
            List<Permiso> permisoListOld = persistentRol.getPermisoList();
            List<Permiso> permisoListNew = rol.getPermisoList();
            List<Employe> employeListOld = persistentRol.getEmployeList();
            List<Employe> employeListNew = rol.getEmployeList();
            List<String> illegalOrphanMessages = null;
            for (Employe employeListOldEmploye : employeListOld) {
                if (!employeListNew.contains(employeListOldEmploye)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Employe " + employeListOldEmploye + " since its idRol field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Permiso> attachedPermisoListNew = new ArrayList<Permiso>();
            for (Permiso permisoListNewPermisoToAttach : permisoListNew) {
                permisoListNewPermisoToAttach = em.getReference(permisoListNewPermisoToAttach.getClass(), permisoListNewPermisoToAttach.getId());
                attachedPermisoListNew.add(permisoListNewPermisoToAttach);
            }
            permisoListNew = attachedPermisoListNew;
            rol.setPermisoList(permisoListNew);
            List<Employe> attachedEmployeListNew = new ArrayList<Employe>();
            for (Employe employeListNewEmployeToAttach : employeListNew) {
                employeListNewEmployeToAttach = em.getReference(employeListNewEmployeToAttach.getClass(), employeListNewEmployeToAttach.getId());
                attachedEmployeListNew.add(employeListNewEmployeToAttach);
            }
            employeListNew = attachedEmployeListNew;
            rol.setEmployeList(employeListNew);
            rol = em.merge(rol);
            for (Permiso permisoListOldPermiso : permisoListOld) {
                if (!permisoListNew.contains(permisoListOldPermiso)) {
                    permisoListOldPermiso.getRolList().remove(rol);
                    permisoListOldPermiso = em.merge(permisoListOldPermiso);
                }
            }
            for (Permiso permisoListNewPermiso : permisoListNew) {
                if (!permisoListOld.contains(permisoListNewPermiso)) {
                    permisoListNewPermiso.getRolList().add(rol);
                    permisoListNewPermiso = em.merge(permisoListNewPermiso);
                }
            }
            for (Employe employeListNewEmploye : employeListNew) {
                if (!employeListOld.contains(employeListNewEmploye)) {
                    Rol oldIdRolOfEmployeListNewEmploye = employeListNewEmploye.getIdRol();
                    employeListNewEmploye.setIdRol(rol);
                    employeListNewEmploye = em.merge(employeListNewEmploye);
                    if (oldIdRolOfEmployeListNewEmploye != null && !oldIdRolOfEmployeListNewEmploye.equals(rol)) {
                        oldIdRolOfEmployeListNewEmploye.getEmployeList().remove(employeListNewEmploye);
                        oldIdRolOfEmployeListNewEmploye = em.merge(oldIdRolOfEmployeListNewEmploye);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = rol.getId();
                if (findRol(id) == null) {
                    throw new NonexistentEntityException("The rol with id " + id + " no longer exists.");
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
            Rol rol;
            try {
                rol = em.getReference(Rol.class, id);
                rol.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The rol with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Employe> employeListOrphanCheck = rol.getEmployeList();
            for (Employe employeListOrphanCheckEmploye : employeListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Rol (" + rol + ") cannot be destroyed since the Employe " + employeListOrphanCheckEmploye + " in its employeList field has a non-nullable idRol field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Permiso> permisoList = rol.getPermisoList();
            for (Permiso permisoListPermiso : permisoList) {
                permisoListPermiso.getRolList().remove(rol);
                permisoListPermiso = em.merge(permisoListPermiso);
            }
            em.remove(rol);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Rol> findRolEntities() {
        return findRolEntities(true, -1, -1);
    }
    
    public List<Rol> findRolByStatus(String status) {
        return findRolEntities(true, -1, -1);
    }

    public List<Rol> findRolEntities(int maxResults, int firstResult) {
        return findRolEntities(false, maxResults, firstResult);
    }

    private List<Rol> findRolEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Rol.class));
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

    public Rol findRol(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Rol.class, id);
        } finally {
            em.close();
        }
    }

    public int getRolCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Rol> rt = cq.from(Rol.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public void edit(Employe employe) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
