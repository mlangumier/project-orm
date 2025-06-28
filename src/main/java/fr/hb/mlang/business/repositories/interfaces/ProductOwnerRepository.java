package fr.hb.mlang.business.repositories.interfaces;

import fr.hb.mlang.business.entities.JobApplication;
import fr.hb.mlang.business.entities.ProductOwner;
import fr.hb.mlang.business.entities.Project;

import java.util.List;

public interface ProductOwnerRepository
        extends GenericCrudRepository<ProductOwner, Long> {

    boolean createNewProject(Project project, ProductOwner productOwner);
//    boolean createNewProject(String title, String description, Theme theme, ProductOwner productOwner);

    List<JobApplication> showJobApplicationsForProject(Long projectId);

    boolean answerToJobApplication(JobApplication jobApplication, boolean isAccepted);
}
