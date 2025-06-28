package fr.hb.mlang.business;

import fr.hb.mlang.business.entities.*;
import fr.hb.mlang.business.repositories.*;
import fr.hb.mlang.business.utils.JpaFactory;

import java.util.List;

public class Main {
    static UserRepositoryImpl repoUser = new UserRepositoryImpl();
    static ProductOwnerRepositoryImpl repoProductOwner = new ProductOwnerRepositoryImpl();
    static DeveloperRepositoryImpl repoDeveloper = new DeveloperRepositoryImpl();

    static ThemeRepositoryImpl repoTheme = new ThemeRepositoryImpl();
    static SkillRepositoryImpl repoSkill = new SkillRepositoryImpl();

    static ProjectRepositoryImpl repoProject = new ProjectRepositoryImpl();
    static JobApplicationRepositoryImpl repoJobApplication = new JobApplicationRepositoryImpl();

    public static void main(String[] args) {

        //--- INFO: Instantiate objects

        Skill skillJava = new Skill("Java");
        Skill skillAngular = new Skill("Angular");

        Theme themeHealth = new Theme("health");
        Theme themeEcommerce = new Theme("E-Commerce");

        User matt = new User("Matt", "matt@test.com", "matt@password");
        User sam = new User("Sam", "sam@test.com", "sam@password");

        ProductOwner productOwner = new ProductOwner(sam, "Sam & Co");

        Developer developer = new Developer(matt, "Matthew", "Lang", "Small description of Matt Lang, Web Developer.");

        Project project = new Project("DoctoWeb","A web app that makes finding a general practician easier", themeHealth,  productOwner);

        JobApplication jobApplication = new JobApplication("Hi! I need work!", project, developer);


        //--- INFO: Persist stand-alone data (Theme & Skill)
        repoSkill.persist(skillJava);
        repoSkill.persist(skillAngular);
        repoTheme.persist(themeHealth);
        repoTheme.persist(themeEcommerce);

        //--- INFO: Persist independent instances
        repoUser.persist(matt);
        repoUser.persist(sam);

        //--- INFO: Persist user profiles (ProductOwner & Developer)
        repoProductOwner.persist(productOwner);
        repoDeveloper.persist(developer);

        developer.setSkills(List.of(skillJava,skillAngular));
        repoDeveloper.update(developer);

        //--- INFO: Persist entities with many relationships (Project & JobApplications)
        repoProject.persist(project);
        repoJobApplication.persist(jobApplication);

        //--- INFO: Checking behaviours

        System.out.println("\n--- Init Check - Find All ---");
        printAll();

        //TODO: Test "merge" in generic CRUD & check if solves issue with User.developer not being removed (ex from firstOrm)

        //--- INFO: Product Owner actions :

//        boolean projectIsCreated = repoProductOwner.createNewProject(project, productOwner);
//        System.out.println("> Project created: " + projectIsCreated);

//        List<Project> projectsList = repoProject.findAll();
//        List<JobApplication> projectApplications = repoProductOwner.showJobApplicationsForProject(projectsList.getFirst().getId());
//        projectApplications.forEach(entity -> System.out.println("> " + entity));

//        boolean answerWasSent = repoProductOwner.answerToJobApplication(projectApplications.getFirst(), true);
//        System.out.println("> Answer recorded: " +  answerWasSent);

//        System.out.println("\n--- Final Check - Find all ---");
//        printAll();

        JpaFactory.close();
    }

    public static void printAll() {
        printAllSkills();
        printAllThemes();

        printAllProductOwners();
        printAllDevelopers();
        printAllUsers();

        printAllProjects();
        printAllJobApplications();
    }

    public static void printAllUsers() {
        repoUser.findAll().forEach(entity -> System.out.println("> " + entity));
    }
    public static void printAllProductOwners() {
        repoProductOwner.findAll().forEach(entity -> System.out.println("> " + entity));
    }
    public static void printAllDevelopers() {
        repoDeveloper.findAll().forEach(entity -> System.out.println("> " + entity));
    }
    public static void printAllSkills() {
        repoSkill.findAll().forEach(entity -> System.out.println("> " + entity));
    }
    public static void printAllThemes() {
        repoTheme.findAll().forEach(entity -> System.out.println("> " + entity));
    }
    public static void printAllProjects() {
        repoProject.findAll().forEach(entity -> System.out.println("> " + entity));
    }
    public static void printAllJobApplications() {
        repoJobApplication.findAll().forEach(entity -> System.out.println("> " + entity));
    }
}
