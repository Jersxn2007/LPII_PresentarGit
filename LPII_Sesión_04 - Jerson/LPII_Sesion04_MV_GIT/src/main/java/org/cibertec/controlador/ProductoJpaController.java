package org.cibertec.controlador;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import org.cibertec.model.Producto;
import org.cibertec.util.JPAUtil;

public class ProductoJpaController implements Serializable {

    private static final long serialVersionUID = 1L;

    private EntityManagerFactory emf;

    // Constructor por defecto usando JPAUtil
    public ProductoJpaController() {
        this.emf = JPAUtil.getEntityManagerFactory();
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // MÉTODOS JPA
    public void registrar(Producto data) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(data);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) 
                em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public List<Producto> findAllProducto() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Producto> q = em.createQuery("SELECT p FROM Producto p", Producto.class);
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Producto buscarById(int codigo) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Producto.class, codigo);
        } finally {
            em.close();
        }
    }
}