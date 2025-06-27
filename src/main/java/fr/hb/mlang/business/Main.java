package fr.hb.mlang.business;

import fr.hb.mlang.business.entities.ProductOwner;
import fr.hb.mlang.business.entities.User;
import fr.hb.mlang.business.repositories.ProductOwnerRepositoryImpl;
import fr.hb.mlang.business.repositories.UserRepositoryImpl;
import fr.hb.mlang.business.utils.JpaFactory;

public class Main {
    public static void main(String[] args) {
        UserRepositoryImpl userRepo = new UserRepositoryImpl();
        ProductOwnerRepositoryImpl poRepo = new ProductOwnerRepositoryImpl();

        // User
        User userMatt = new User("Matt", "matt@test.com", "matt@password");
        userRepo.persist(userMatt);

        // User - Product Owner
        ProductOwner poMatt = new ProductOwner("Matt & Co");   // Instantiate new ProductOwner

        //TODO search: Hibernate JPA persist new entity with relation OneToOne
        poRepo.persist(poMatt);                                             // Persist ProductOwner
        System.out.println("> AFTER PERSIST: " + poMatt);

        poMatt.setUser(userMatt);                                           // Modify instance -> becomes detached

        poRepo.update(poMatt);                                              // Update (& refresh) entry with the detached instance's data
        System.out.println("> AFTER UPDATE: " + poMatt);

        JpaFactory.close();
    }
}
