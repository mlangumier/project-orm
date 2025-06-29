package fr.hb.mlang.business.repositories;

import fr.hb.mlang.business.entities.*;
import fr.hb.mlang.business.enums.ApplicationStatus;
import fr.hb.mlang.business.repositories.interfaces.ProductOwnerRepository;
import fr.hb.mlang.business.utils.JpaFactory;
import jakarta.persistence.EntityManager;

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
        EntityManager em = JpaFactory.getEntityManager();
        ProjectRepositoryImpl projectRepository = new ProjectRepositoryImpl();
        List<JobApplication> jobApplicationsForProject = new ArrayList<>();

        try (em) {
            Optional<Project> project = projectRepository.findById(projectId);

            if (project.isPresent()) {
                jobApplicationsForProject = em.createQuery(
                                "FROM JobApplication j WHERE j.project=:project",
                                JobApplication.class
                        )
                        .setParameter("project", project.get())
                        .getResultList();
            }
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
    }

    ;
}
