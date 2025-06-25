package fr.hb.mlang.business;

import fr.hb.mlang.business.entities.User;
import fr.hb.mlang.business.repositories.UserRepository;
import fr.hb.mlang.business.utils.JpaFactory;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();

        // Persist
        User userMatt = new User("Matt", "matt@test.com", "matt@password");
        userRepository.persist(userMatt);

        User userSam = new User("Sam", "sam@test.com", "sam@password");
        userRepository.persist(userSam);

        User userDan = new User("Dan", "dan@test.com", "dan@password");
        userRepository.persist(userDan);

        // Find All (check before)
        userRepository.findAll().forEach(System.out::println);

        // Update
        userMatt.setUsername("Matthew");
        User updatedMatt = userRepository.update(userMatt);

        // Find by ID
        Optional<User> retrievedMatt = userRepository.findById(updatedMatt.getId());
        retrievedMatt.ifPresent(System.out::println);

        // Delete
        Optional<User> retrievedSam = userRepository.findById(2);
        retrievedSam.ifPresent(userRepository::delete);

        // Find All (check after)
        userRepository.findAll().forEach(System.out::println);

        //TODO:
        // - Test a full CRUD on USER
        // - Refactorize CRUD to a GenericCrudInterface/Impl

//        ProductOwner poMatt = new ProductOwner("Matt & Co", userMatt);
//        Developer devSam = new Developer("Samuel", "William", "Short description of S.William, Fullstack Developer", userSam);

        JpaFactory.close();
    }
}
