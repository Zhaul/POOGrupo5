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
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import pe.edu.utp.controllers.exceptions.IllegalOrphanException;
import pe.edu.utp.controllers.exceptions.NonexistentEntityException;
import pe.edu.utp.entity.Area;

/**
 *
 * @author zhaul
 */
public class AreaJpaController implements Serializable {

    public AreaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public AreaJpaController() {
        this.emf = Persistence.createEntityManagerFactory("POOGrupo5PU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Area area) {
        if (area.getCargoPersonalList() == null) {
            area.setCargoPersonalList(new ArrayList<CargoPersonal>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<CargoPersonal> attachedCargoPersonalList = new ArrayList<CargoPersonal>();
            for (CargoPersonal cargoPersonalListCargoPersonalToAttach : area.getCargoPersonalList()) {
                cargoPersonalListCargoPersonalToAttach = em.getReference(cargoPersonalListCargoPersonalToAttach.getClass(), cargoPersonalListCargoPersonalToAttach.getId());
                attachedCargoPersonalList.add(cargoPersonalListCargoPersonalToAttach);
            }
            area.setCargoPersonalList(attachedCargoPersonalList);
            em.persist(area);
            for (CargoPersonal cargoPersonalListCargoPersonal : area.getCargoPersonalList()) {
                Area oldIdAreaOfCargoPersonalListCargoPersonal = cargoPersonalListCargoPersonal.getIdArea();
                cargoPersonalListCargoPersonal.setIdArea(area);
                cargoPersonalListCargoPersonal = em.merge(cargoPersonalListCargoPersonal);
                if (oldIdAreaOfCargoPersonalListCargoPersonal != null) {
                    oldIdAreaOfCargoPersonalListCargoPersonal.getCargoPersonalList().remove(cargoPersonalListCargoPersonal);
                    oldIdAreaOfCargoPersonalListCargoPersonal = em.merge(oldIdAreaOfCargoPersonalListCargoPersonal);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Area area) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Area persistentArea = em.find(Area.class, area.getId());
            List<CargoPersonal> cargoPersonalListOld = persistentArea.getCargoPersonalList();
            List<CargoPersonal> cargoPersonalListNew = area.getCargoPersonalList();
            List<String> illegalOrphanMessages = null;
            for (CargoPersonal cargoPersonalListOldCargoPersonal : cargoPersonalListOld) {
                if (!cargoPersonalListNew.contains(cargoPersonalListOldCargoPersonal)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain CargoPersonal " + cargoPersonalListOldCargoPersonal + " since its idArea field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<CargoPersonal> attachedCargoPersonalListNew = new ArrayList<CargoPersonal>();
            for (CargoPersonal cargoPersonalListNewCargoPersonalToAttach : cargoPersonalListNew) {
                cargoPersonalListNewCargoPersonalToAttach = em.getReference(cargoPersonalListNewCargoPersonalToAttach.getClass(), cargoPersonalListNewCargoPersonalToAttach.getId());
                attachedCargoPersonalListNew.add(cargoPersonalListNewCargoPersonalToAttach);
            }
            cargoPersonalListNew = attachedCargoPersonalListNew;
            area.setCargoPersonalList(cargoPersonalListNew);
            area = em.merge(area);
            for (CargoPersonal cargoPersonalListNewCargoPersonal : cargoPersonalListNew) {
                if (!cargoPersonalListOld.contains(cargoPersonalListNewCargoPersonal)) {
                    Area oldIdAreaOfCargoPersonalListNewCargoPersonal = cargoPersonalListNewCargoPersonal.getIdArea();
                    cargoPersonalListNewCargoPersonal.setIdArea(area);
                    cargoPersonalListNewCargoPersonal = em.merge(cargoPersonalListNewCargoPersonal);
                    if (oldIdAreaOfCargoPersonalListNewCargoPersonal != null && !oldIdAreaOfCargoPersonalListNewCargoPersonal.equals(area)) {
                        oldIdAreaOfCargoPersonalListNewCargoPersonal.getCargoPersonalList().remove(cargoPersonalListNewCargoPersonal);
                        oldIdAreaOfCargoPersonalListNewCargoPersonal = em.merge(oldIdAreaOfCargoPersonalListNewCargoPersonal);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = area.getId();
                if (findArea(id) == null) {
                    throw new NonexistentEntityException("The area with id " + id + " no longer exists.");
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
            Area area;
            try {
                area = em.getReference(Area.class, id);
                area.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The area with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<CargoPersonal> cargoPersonalListOrphanCheck = area.getCargoPersonalList();
            for (CargoPersonal cargoPersonalListOrphanCheckCargoPersonal : cargoPersonalListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Area (" + area + ") cannot be destroyed since the CargoPersonal " + cargoPersonalListOrphanCheckCargoPersonal + " in its cargoPersonalList field has a non-nullable idArea field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(area);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Area> findAreaEntities() {
        return findAreaEntities(true, -1, -1);
    }

    public List<Area> findAreaEntities(int maxResults, int firstResult) {
        return findAreaEntities(false, maxResults, firstResult);
    }

    private List<Area> findAreaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Area.class));
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

    public Area findArea(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Area.class, id);
        } finally {
            em.close();
        }
    }

    public int getAreaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Area> rt = cq.from(Area.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
