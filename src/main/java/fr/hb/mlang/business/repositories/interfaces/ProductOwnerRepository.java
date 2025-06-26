package fr.hb.mlang.business.repositories.interfaces;

import fr.hb.mlang.business.entities.ProductOwner;

public interface ProductOwnerRepository  extends GenericCrudRepository<ProductOwner, Long> {

    //TODO:
    // createProject
    // getJobApplicationsForProject(projectId)
    // acceptJobApplication
    // rejectJobApplication
}
