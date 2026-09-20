package org.cibertec.controlador;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import org.cibertec.model.Proveedor;
import org.cibertec.util.JPAUtil;

public class ProveedorJpaController implements Serializable {

    private static final long serialVersionUID = 1L;

    private EntityManagerFactory emf;

    // Constructor por defecto usando JPAUtil
    public ProveedorJpaController() {
        this.emf = JPAUtil.getEntityManagerFactory();
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // MÉTODOS JPA
    public List<Proveedor> findAllProveedor() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Proveedor> q = em.createQuery("SELECT p FROM Proveedor p", Proveedor.class);
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Proveedor buscarById(int codigo) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Proveedor.class, codigo);
        } finally {
            em.close();
        }
    }
}