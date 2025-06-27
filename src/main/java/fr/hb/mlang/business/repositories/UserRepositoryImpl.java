package fr.hb.mlang.business.repositories;

import fr.hb.mlang.business.entities.ProductOwner;
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


    //TODO: Find another way to implement this relation (~JOIN FETCH?)
    @Override
    public void addProductOwnerProfile(User user, ProductOwner productOwner) {
        EntityManager em = JpaFactory.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        ProductOwnerRepositoryImpl poRepo = new ProductOwnerRepositoryImpl();

        try (em) {
            tx.begin();

            poRepo.persist(productOwner);
            productOwner.setUser(user);
            poRepo.update(productOwner);

            tx.commit();
        } catch (Exception e) {
            System.err.printf("> Failed to add ProductOwner [%s] to User [%s]: %s%n", productOwner, user, e.getMessage());

            tx.rollback();
        }
    }
}
