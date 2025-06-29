package fr.hb.mlang.business.repositories.interfaces;

import fr.hb.mlang.business.entities.Developer;
import fr.hb.mlang.business.entities.JobApplication;
import fr.hb.mlang.business.entities.Project;
import fr.hb.mlang.business.entities.Theme;
import fr.hb.mlang.business.enums.ProjectStatus;

import java.time.LocalDate;
import java.util.List;

public interface DeveloperRepository
        extends GenericCrudRepository<Developer, Long> {

    /**
     * Method that finds all projects
     *
     * @return A list of projects
     */
    List<Project> showAllProjects();

    /**
     * Method that finds all projects that have a given status
     *
     * @param status Status by which the projects will be filtered
     * @return A list of projects with the corresponding status
     */
    List<Project> showAllProjectsFilteredByStatus(ProjectStatus status);

    /**
     * Method that finds all projects that correspond to a given theme
     *
     * @param theme Theme by which the projects will be filtered
     * @return A list of projects with the corresponding theme
     */
    List<Project> showAllProjectsWithTheme(Theme theme);

    /**
     * Method that finds all projects where the delivery date is after the given date
     *
     * @param deliveryDate Project's delivery date
     * @return A list of projects with the corresponding delivery date
     */
    List<Project> showAllProjectsWithDeliveryAfterDate(LocalDate deliveryDate);

    /**
     * Method that finds all projects where the available budget is at least the given budget
     *
     * @param availableBudget Minimum available budget the user is looking for
     * @return A list of projects with the corresponding budget
     */
    List<Project> showAllProjectsWithBudgetAbove(Integer availableBudget);

    boolean applyToProject(JobApplication jobApplication);
}
