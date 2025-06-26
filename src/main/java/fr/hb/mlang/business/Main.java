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
        System.out.println("> Persisted Matt: " + userMatt);

        User userSam = new User("Sam", "sam@test.com", "sam@password");
        userRepository.persist(userSam);

        User userDan = new User("Dan", "dan@test.com", "dan@password");
        userRepository.persist(userDan);

        // Find All (check before)
        userRepository.findAll().forEach(System.out::println);

        // Update
        userMatt.setUsername("Matthew");
        userRepository.update(userMatt);
        System.out.println("> Merged Matt: " + userMatt);

        // Find by ID
        Optional<User> retrievedMatt = userRepository.findById(userMatt.getId());
        retrievedMatt.ifPresent(foundMatt -> System.out.println("> Found Matt: " + foundMatt));

        // Delete
        Optional<User> retrievedSam = userRepository.findById(2L);
        retrievedSam.ifPresent(entity -> userRepository.delete(entity.getId()));

        // Find All (check after)
        userRepository.findAll().forEach(System.out::println);

//        ProductOwner poMatt = new ProductOwner("Matt & Co", userMatt);
//        Developer devSam = new Developer("Samuel", "William", "Short description of S.William, Fullstack Developer", userSam);

        JpaFactory.close();
    }
}
