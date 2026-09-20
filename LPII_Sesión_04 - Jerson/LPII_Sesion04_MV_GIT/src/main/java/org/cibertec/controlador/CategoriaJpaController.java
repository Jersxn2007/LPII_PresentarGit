package org.cibertec.controlador;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import org.cibertec.model.Categoria;
import org.cibertec.util.JPAUtil;

public class CategoriaJpaController implements Serializable {

    private static final long serialVersionUID = 1L;

    private EntityManagerFactory emf;

    // Constructor por defecto (USANDO JPAUtil)
    public CategoriaJpaController() {
        this.emf = JPAUtil.getEntityManagerFactory();
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // MÉTODOS JPA
    public List<Categoria> findAllCategoria() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Categoria> q = em.createQuery("SELECT e FROM Categoria e", Categoria.class);
            return q.getResultList();
        }
        finally {
            em.close();
        }
    }

    public Categoria buscarById(int codigo) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Categoria.class, codigo);
        } finally {
            em.close();
        }
    }
}