package fr.hb.mlang.business.repositories;

import fr.hb.mlang.business.entities.Developer;
import fr.hb.mlang.business.entities.ProductOwner;
import fr.hb.mlang.business.entities.Project;
import fr.hb.mlang.business.entities.User;
import fr.hb.mlang.business.repositories.interfaces.UserRepository;
import fr.hb.mlang.business.utils.JpaFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class UserRepositoryImpl
        extends AbstractGenericCrudRepositoryImpl<User, Long>
        implements UserRepository {

    public UserRepositoryImpl() {
        super(User.class, "FROM User");
    }
}
