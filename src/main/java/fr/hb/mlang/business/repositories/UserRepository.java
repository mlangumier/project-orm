package fr.hb.mlang.business.repositories;

import fr.hb.mlang.business.entities.User;
import fr.hb.mlang.business.utils.JpaFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {

    /**
     * @return
     */
    public List<User> findAll() {
        EntityManager em = JpaFactory.getEntityManager();
        List<User> entities = new ArrayList<>();

        try (em) {
            entities = em.createQuery("FROM User", User.class).getResultList();
        } catch (Exception e) {
            System.err.println("Couldn't find entries for class USER: " + e.getMessage());
        }

        return entities;
    }

    /**
     * @param id
     * @return
     */
    public Optional<User> findById(long id) {
        EntityManager em = JpaFactory.getEntityManager();

        try (em) {
            User instance = em.find(User.class, id);
            return Optional.of(instance);
        } catch (Exception e) {
            System.err.println("Couldn't find any instance with given ID: " + e.getMessage());
        }

        return Optional.empty();
    }

    /**
     * Method that adds a new User to the database.
     *
     * @param instance Instance of User to add to the database
     * @return
     */
    public boolean persist(User instance) {
        EntityManager em = JpaFactory.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try (em) {
            tx.begin();
            em.persist(instance); // Transitions the User instance from a transient to persistent state.
            tx.commit();

            return true;
        } catch (Exception e) {
            System.err.println("Couldn't persist instance: " + e.getMessage());

            tx.rollback();
        }

        return false;
    }

    /**
     *
     * @param instance
     * @return
     */
    public User update(User instance) {
        EntityManager em = JpaFactory.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try (em) {
            tx.begin();
            User mergedInstance = em.merge(instance); // Updates a persistent instance (old, fetched) with values from a detached instance (new, to send)
            tx.commit();

            return mergedInstance;
        } catch (Exception e) {
            System.err.println("Couldn't update instance: " + e.getMessage());

            tx.rollback();
        }

        return null;
    }

    /**
     * @param instance
     * @return
     */
    public boolean delete(User instance) {
        EntityManager em = JpaFactory.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try (em) {
            tx.begin();
            User managedEntity = em.find(User.class, instance.getId());
            em.remove(managedEntity);
            tx.commit();

            return true;
        } catch (Exception e) {
            System.err.println("Couldn't delete instance: " + e.getMessage());

            tx.rollback();
        }

        return false;
    }
}
