package fr.hb.mlang.business;

import fr.hb.mlang.business.entities.*;
import fr.hb.mlang.business.enums.ProjectStatus;
import fr.hb.mlang.business.repositories.*;
import fr.hb.mlang.business.utils.JpaFactory;

import java.time.LocalDate;
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

        //--- Setup

        Skill skillJava = new Skill("Java");
        Skill skillAngular = new Skill("Angular");
        repoSkill.persist(skillJava);
        repoSkill.persist(skillAngular);

        Theme themeHealth = new Theme("health");
        Theme themeEcommerce = new Theme("E-Commerce");
        repoTheme.persist(themeHealth);
        repoTheme.persist(themeEcommerce);

        User matt = new User("Matt", "matt@test.com", "matt@password");
        User sam = new User("Sam", "sam@test.com", "sam@password");
        repoUser.persist(matt);
        repoUser.persist(sam);

        ProductOwner productOwner = new ProductOwner(sam, "Sam & Co");
        repoProductOwner.persist(productOwner);

        Developer developer = new Developer(matt, "Matthew", "Lang", "Small description of Matt Lang, Web Developer.");
        developer.setSkills(List.of(skillJava, skillAngular));
        repoDeveloper.persist(developer);


        //--- User interactions

        // ProductOwner creates two Projects
        Project project1 = new Project("DoctoWeb", "A web app that makes finding a general practician easier", themeHealth, productOwner);
        Project project2 = new Project("WebCommerce", "An E-Commerce platform", themeEcommerce, productOwner);
        project2.setDeliveryDate(LocalDate.now().plusMonths(3));
        project2.setAvailableBudget(10000);
        project2.setStatus(ProjectStatus.OPEN);

        boolean project1IsCreated = repoProductOwner.createNewProject(project1, productOwner);
        System.out.println("> Project-1 created: " + project1IsCreated);
        boolean project2IsCreated = repoProductOwner.createNewProject(project2, productOwner);
        System.out.println("> Project-2 created: " + project2IsCreated);

        // Developer checks all Projects
        List<Project> allProjects = repoDeveloper.showAllProjects();
        System.out.println("> All projects: " + allProjects); // Shows 2

        // Developer checks all projects filtered by attribute
        List<Project> filteredByStatus = repoDeveloper.showAllProjectsFilteredByStatus(ProjectStatus.OPEN); // project2
        System.out.println("> Projects filtered by status: " + filteredByStatus);

        List<Project> filteredByTheme = repoDeveloper.showAllProjectsWithTheme(themeHealth); // project1
        System.out.println("> Projects filtered by theme: " + filteredByTheme);

        List<Project> filteredByDeliveryDate = repoDeveloper.showAllProjectsWithDeliveryAfterDate(LocalDate.now()); // project2
        System.out.println("> Projects filtered by deliveryDate: " + filteredByDeliveryDate);

        List<Project> filteredByAvailableBudget = repoDeveloper.showAllProjectsWithBudgetAbove(11000); // project2 = 10000
        System.out.println("> Projects filtered by filteredByAvailableBudget: " + filteredByAvailableBudget);

        // Developer applies to a Project
        JobApplication jobApplication = new JobApplication("Hi! I need work!", project1, developer);
        boolean isApplicationSent = repoDeveloper.applyToProject(jobApplication); // true
        System.out.println("> Application sent: " + isApplicationSent);

        // ProductOwner checks all applications received for a Project
        Project projectsList = repoProject.findAll().getFirst();
        List<JobApplication> projectApplications = repoProductOwner.showJobApplicationsForProject(projectsList.getId());
        System.out.println("> Project's applications received: "); // Shows 1
        projectApplications.forEach(entity -> System.out.println("> " + entity));

        // ProductOwner accepts or declines an application
        boolean answerWasSent = repoProductOwner.answerToJobApplication(projectApplications.getFirst(), true);
        System.out.println("> Answer recorded: " + answerWasSent); // true

        System.out.println("\n--- Final Check - Find all ---"); // Shows users, projects & applications
        printAll();

        JpaFactory.close();
    }

    public static void printAll() {
//        printAllSkills();
//        printAllThemes();

//        printAllProductOwners();
//        printAllDevelopers();
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
