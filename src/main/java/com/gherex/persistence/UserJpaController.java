package com.gherex.persistence;

import com.gherex.logic.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;


public class UserJpaController {

    public void crearUsuario(User user) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(user);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public List<User> obtenerUsuarios() {
        EntityManager em = JPAUtil.getEntityManager();
        List<User> usuarios = em.createQuery("SELECT u FROM User u", User.class).getResultList();
        em.close();
        return usuarios;
    }

    public void actualizarUsuario(User user) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.merge(user); // merge actualiza si existe
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void eliminarUsuario(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            User user = em.find(User.class, id);
            if (user != null) {
                em.remove(user);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public User buscarUsuarioPorId(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        User user = em.find(User.class, id);
        em.close();
        return user;
    }
}
