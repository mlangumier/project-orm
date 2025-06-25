package fr.hb.mlang.business.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * JPA EntityManagerFactory implementation.
 *
 * @implNote Singleton
 */
public class JpaFactory {
    private static final String PERSISTENCE_UNIT_NAME = "PROJECT_ORM_PU";
    private static final EntityManagerFactory factory;

    private JpaFactory() {
    }

    static {
        try {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        } catch (Exception e) {
            throw new ExceptionInInitializerError("\nInitial EntityManagerFactory creation failed: " + e);
        }
    }

    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }

    public static void close() {
        if (factory != null && factory.isOpen()) {
            factory.close();
        }
    }
}
