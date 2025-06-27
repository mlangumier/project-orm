package fr.hb.mlang.business.repositories;

import fr.hb.mlang.business.entities.Developer;
import fr.hb.mlang.business.repositories.interfaces.DeveloperRepository;

public class DeveloperRepositoryImpl
        extends AbstractGenericCrudRepositoryImpl<Developer, Long>
        implements DeveloperRepository {

    public DeveloperRepositoryImpl() {
        super(Developer.class, "FROM Developer");
    }
}
