package fr.hb.mlang.business.repositories;

import fr.hb.mlang.business.entities.Developer;
import fr.hb.mlang.business.entities.JobApplication;
import fr.hb.mlang.business.entities.Project;
import fr.hb.mlang.business.repositories.interfaces.DeveloperRepository;

import java.util.List;

public class DeveloperRepositoryImpl
        extends AbstractGenericCrudRepositoryImpl<Developer, Long>
        implements DeveloperRepository {

    public DeveloperRepositoryImpl() {
        super(Developer.class, "FROM Developer d LEFT JOIN FETCH d.skills");
    }

    @Override
    public List<Project> showAllProjects() {
        ProjectRepositoryImpl projectRepository = new ProjectRepositoryImpl();

        return projectRepository.findAll();
    }

    @Override
    public List<Project> showAllProjectsFiltered(String filter) {
        ProjectRepositoryImpl projectRepository = new ProjectRepositoryImpl();

        return projectRepository.findAll(); //TODO: needs a custom query in projectRepository to filter results according to method parameter
    }

    @Override
    public boolean applyToProject(String message, Project project, Developer developer) {
        JobApplicationRepositoryImpl jobApplicationRepository = new JobApplicationRepositoryImpl();

        try {
            JobApplication newJobApplication = new JobApplication(message, project, developer);
            jobApplicationRepository.persist(newJobApplication);

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
