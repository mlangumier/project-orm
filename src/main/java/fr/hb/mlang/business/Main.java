package fr.hb.mlang.business;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        EntityManager em = Persistence.createEntityManagerFactory("PROJECT_ORM_PU").createEntityManager();

        em.close();
    }
}
