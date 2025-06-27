package fr.hb.mlang.business.repositories;

import fr.hb.mlang.business.entities.Project;
import fr.hb.mlang.business.repositories.interfaces.ProjectRepository;

public class ProjectRepositoryImpl
        extends AbstractGenericCrudRepositoryImpl<Project, Long>
        implements ProjectRepository {

    public ProjectRepositoryImpl() {
        super(Project.class, "FROM Project");
    }
}
