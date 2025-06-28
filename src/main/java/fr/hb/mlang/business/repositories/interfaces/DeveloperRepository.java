package fr.hb.mlang.business.repositories.interfaces;

import fr.hb.mlang.business.entities.Developer;
import fr.hb.mlang.business.entities.Project;

import java.util.List;

public interface DeveloperRepository
        extends GenericCrudRepository<Developer, Long> {

    List<Project> showAllProjects();

    // Display projects filtered by attribute -> deliveryDate, theme, availableBudget (enum? get attribute's name?)
    List<Project> showAllProjectsFiltered(String filter);
    //    List<Project> showAllProjects(String filter); //INFO: <<extends>> from showAllProjects() -> method overload?

    boolean applyToProject(String message, Project project, Developer developer);
}
