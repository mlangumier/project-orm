package fr.hb.mlang.business.repositories;

import fr.hb.mlang.business.entities.User;

public class UserRepository extends AbstractGenericCrudRepositoryImpl<User, Long> {

    public UserRepository() {
        super(User.class);
    }
}
