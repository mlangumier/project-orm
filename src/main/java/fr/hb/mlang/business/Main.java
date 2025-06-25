package fr.hb.mlang.business;

import fr.hb.mlang.business.utils.JpaFactory;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        //TODO:
        // - Set up EntityManagerFactory (singleton)
        // - Test a full CRUD on USER
        // - Refactorize CRUD to a GenericCrudInterface/Impl

        JpaFactory.close();
    }
}
