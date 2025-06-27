package fr.hb.mlang.business.repositories.interfaces;

import fr.hb.mlang.business.entities.ProductOwner;
import fr.hb.mlang.business.entities.User;

public interface UserRepository extends GenericCrudRepository<User, Long> {

    void addProductOwnerProfile(User user, ProductOwner productOwner);
}
