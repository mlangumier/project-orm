package fr.hb.mlang.business;

import fr.hb.mlang.business.entities.Developer;
import fr.hb.mlang.business.entities.ProductOwner;
import fr.hb.mlang.business.entities.User;
import fr.hb.mlang.business.repositories.DeveloperRepositoryImpl;
import fr.hb.mlang.business.repositories.ProductOwnerRepositoryImpl;
import fr.hb.mlang.business.repositories.UserRepositoryImpl;
import fr.hb.mlang.business.utils.JpaFactory;

public class Main {
    static UserRepositoryImpl repoUser = new UserRepositoryImpl();
    static ProductOwnerRepositoryImpl repoProductOwner = new ProductOwnerRepositoryImpl();
    static DeveloperRepositoryImpl repoDeveloper = new DeveloperRepositoryImpl();

    public static void main(String[] args) {

        //--- Instantiate objects

        User matt = new User("Matt", "matt@test.com", "matt@password");
        User sam = new User("Sam", "sam@test.com", "sam@password");

        ProductOwner productOwner1 = new ProductOwner(matt, "Matt & Co");
        ProductOwner productOwner2 = new ProductOwner(sam, "Sam & Co");
        Developer developer = new Developer(matt, "Matthew", "Lang", "Small description of Matt Lang, Web Developer.");

        //--- Persist instances

        repoUser.persist(matt);
        repoUser.persist(sam);
        repoProductOwner.persist(productOwner1);
        repoProductOwner.persist(productOwner2);
        repoDeveloper.persist(developer);

        //--- Checking behaviours

        System.out.println("\n--- Init Check - Find All ---");
        printAll();

//        System.out.println("\n--- Final Check - Find all ---");
//        printAll();

        JpaFactory.close();
    }

    public static void printAll() {
        printAllUsers();
        printAllProductOwners();
        printAllDevelopers();
    }

    public static void printAllUsers() {
        repoUser.findAll().forEach(System.out::println);
    }

    public static void printAllProductOwners() {
        repoProductOwner.findAll().forEach(System.out::println);
    }
    public static void printAllDevelopers() {
        repoDeveloper.findAll().forEach(System.out::println);
    }
}
