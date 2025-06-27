package fr.hb.mlang.business.repositories.interfaces;

import fr.hb.mlang.business.entities.ProductOwner;
import fr.hb.mlang.business.entities.User;

public interface UserRepository
        extends GenericCrudRepository<User, Long> {

    /**
     * Creates a ProductOwner profile linked to the User
     *
     * @param user         Existing User entity that will appear in `ProductOwner.user_id`
     * @param productOwner Entity we're going to persist & link to the User
     */
    void addProductOwnerProfile(User user, ProductOwner productOwner);

    //    void addDeveloperProfile(User user, Developer developer);
}
