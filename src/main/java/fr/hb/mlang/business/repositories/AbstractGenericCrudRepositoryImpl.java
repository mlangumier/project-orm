package fr.hb.mlang.business.repositories;

import fr.hb.mlang.business.repositories.interfaces.GenericCrudRepository;
import fr.hb.mlang.business.utils.JpaFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Generic repository implementation, abstract class that contains the CRUD methods shared by all repositories.
 *
 * @param <T> Instance of the entity
 * @param <K> Primary key of the entity
 */
public abstract class AbstractGenericCrudRepositoryImpl<T, K>
        implements GenericCrudRepository<T, K> {

    private final Class<T> entityClass;
    private final String findAllQuery;

    /**
     * Passes the parameters required to set up queries
     *
     * @param entityClass  Class of the entity (ex: MyEntity.class)
     * @param findAllQuery Query used to find all items of a class (can contain JOIN and WHERE operators)
     */
    protected AbstractGenericCrudRepositoryImpl(Class<T> entityClass, String findAllQuery) {
        this.entityClass = entityClass;
        this.findAllQuery = findAllQuery;
    }

    @Override
    public List<T> findAll() {
        EntityManager em = JpaFactory.getEntityManager();
        List<T> entities = new ArrayList<>();

        try (em) {

            entities = em.createQuery(findAllQuery, entityClass).getResultList();
        } catch (Exception e) {
            System.err.printf("> Failed to find entries for class [%s]: %s%n", entityClass, e.getMessage());
        }

        return entities;
    }

    @Override
    public Optional<T> findById(K id) {
        EntityManager em = JpaFactory.getEntityManager();

        try (em) {
            T entity = em.find(entityClass, id);

            return Optional.of(entity);
        } catch (Exception e) {
            System.err.printf("> Failed to find entry for ID [%s]: %s%n", id, e.getMessage());
        }

        return Optional.empty();
    }

    @Override
    public void persist(T entity) {
        EntityManager em = JpaFactory.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try (em) {
            tx.begin();
            em.persist(entity);
            tx.commit();

            em.refresh(entity);
        } catch (Exception e) {
            System.err.printf("> Failed to persist entity [%s]: %s%n", entity, e.getMessage());

            tx.rollback();
        }
    }

    @Override
    public void update(T entity) {
        EntityManager em = JpaFactory.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try (em) {
            tx.begin();
            em.merge(entity);
            tx.commit();
        } catch (Exception e) {
            System.err.printf("> Failed to update entity [%s]: %s%n", entity, e.getMessage());

            tx.rollback();
        }
    }

    @Override
    public void delete(K id) {
        EntityManager em = JpaFactory.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try (em) {
            tx.begin();
            T managedEntity = em.find(entityClass, id);
            em.remove(managedEntity);
            tx.commit();
        } catch (Exception e) {
            System.err.printf("> Failed to delete entity of ID [%s]: %s%n", id, e.getMessage());

            tx.rollback();
        }
    }
}
