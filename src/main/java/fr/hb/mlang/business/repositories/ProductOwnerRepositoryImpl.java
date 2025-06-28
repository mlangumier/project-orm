package fr.hb.mlang.business.repositories;

import fr.hb.mlang.business.entities.*;
import fr.hb.mlang.business.enums.ApplicationStatus;
import fr.hb.mlang.business.repositories.interfaces.ProductOwnerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductOwnerRepositoryImpl
        extends AbstractGenericCrudRepositoryImpl<ProductOwner, Long>
        implements ProductOwnerRepository {

    public ProductOwnerRepositoryImpl() {
        super(ProductOwner.class, "FROM ProductOwner");
    }

    @Override
    public boolean createNewProject(Project project, ProductOwner productOwner) {
        ProjectRepositoryImpl projectRepository = new ProjectRepositoryImpl();

        try {
            //TODO: need to findById(productOwner) ?
            projectRepository.persist(project);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<JobApplication> showJobApplicationsForProject(Long projectId) {
        ProjectRepositoryImpl projectRepository = new ProjectRepositoryImpl();
        List<JobApplication> jobApplicationsForProject = new ArrayList<>();

        Optional<Project> project = projectRepository.findById(projectId);

        if (project.isPresent()) {
            jobApplicationsForProject = project.get().getJobApplications();
        }

        return jobApplicationsForProject;
    }

    @Override
    public boolean answerToJobApplication(JobApplication jobApplication, boolean isAccepted) {
        JobApplicationRepositoryImpl jobApplicationRepository = new JobApplicationRepositoryImpl();

        jobApplication.setStatus(isAccepted ? ApplicationStatus.ACCEPTED : ApplicationStatus.REJECTED);
        //TODO: Check if doing that detaches the entity from the database

        try {
            jobApplicationRepository.update(jobApplication);
            return true;
        } catch (Exception e) {
            return false;
        }
    };
}
