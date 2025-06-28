package fr.hb.mlang.business.repositories;

import fr.hb.mlang.business.entities.User;
import fr.hb.mlang.business.repositories.interfaces.UserRepository;

public class UserRepositoryImpl
        extends AbstractGenericCrudRepositoryImpl<User, Long>
        implements UserRepository {

    public UserRepositoryImpl() {
        super(User.class, "FROM User");
    }
}
