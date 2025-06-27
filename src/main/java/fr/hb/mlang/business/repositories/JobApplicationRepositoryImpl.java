package fr.hb.mlang.business.repositories;

import fr.hb.mlang.business.entities.JobApplication;
import fr.hb.mlang.business.repositories.interfaces.JobApplicationRepository;

public class JobApplicationRepositoryImpl
        extends AbstractGenericCrudRepositoryImpl<JobApplication, Long>
        implements JobApplicationRepository {

    public JobApplicationRepositoryImpl() {
        super(JobApplication.class, "FROM JobApplication");
    }
}
