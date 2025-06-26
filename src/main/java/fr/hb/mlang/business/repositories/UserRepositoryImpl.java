package fr.hb.mlang.business.repositories;

import fr.hb.mlang.business.entities.User;

public class UserRepositoryImpl extends AbstractGenericCrudRepositoryImpl<User, Long> {

    public UserRepositoryImpl() {
        super(User.class, "FROM User");
    }
}
