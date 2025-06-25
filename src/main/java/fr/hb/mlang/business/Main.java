package fr.hb.mlang.business;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        EntityManager em = Persistence.createEntityManagerFactory("PROJECT_ORM_PU").createEntityManager();

        //TODO:
        // - Set up EntityManagerFactory (singleton)
        // - Test a full CRUD on USER
        // - Refactorize CRUD to a GenericCrudInterface/Impl

        em.close();
    }
}
