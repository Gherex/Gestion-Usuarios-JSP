package com.gherex.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("UserPU");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}