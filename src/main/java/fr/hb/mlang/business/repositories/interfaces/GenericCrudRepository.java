package fr.hb.mlang.business.repositories.interfaces;

import java.util.List;
import java.util.Optional;

/**
 * Generic Repository interface that defines the CRUD methods shared by all repositories.
 *
 * @param <T> Instance of the entity
 * @param <K> Primary key of the entity
 */
public interface GenericCrudRepository<T, K> {

    /**
     * Fetches all the existing entries of the entity type
     *
     * @return A list of instances of the entity
     */
    List<T> findAll();

    /**
     * Fetches the entry corresponding to the primary key
     *
     * @param id Primary key used to find the searched entry
     * @return The instance of the entry that was found, or null if no entry was found.
     */
    Optional<T> findById(K id);

    /**
     * Creates a new entry in the database from the instanced entity.
     *
     * @param entity Instance we want to persist in the database
     */
    void persist(T entity);

    /**
     * Updates an existing entry in the database using the modified data from an instanced entry of this entry.
     *
     * @param entity Instance of the entry we want to modify
     */
    void update(T entity);

    /**
     * Deletes an entry from the database.
     *
     * @param id Primary key of the entry we want to delete
     */
    void delete(K id);
}
