package com.genetrysolar.api;

import com.genetrysolar.jpa.EntityBase;

public interface EntityCRUD<E extends EntityBase, ID> {
    /**
     * Gets the ID of an entity.
     *
     * @param entity
     * @return
     */
    ID getId(E entity);

    /**
     * Persist an entity to the database. Update or create.
     *
     * @param entity
     * @return
     */
    E persist(E entity);

    /**
     * Delete an entity by example
     *
     * @param entity
     * @return Record(s) affected
     */
    default long delete(E entity) {
        return delete(getId(entity));
    }

    /**
     * Delete an entity by id
     *
     * @param entityId
     * @return Record(s) affected
     */
    int delete(ID entityId);

    /**
     * Reads an entity by id
     *
     * @param entityId
     * @return
     */
    E getEntityById(ID entityId);

    /**
     * Total entity cound
     *
     * @return number of entities in the database
     */
    long count();

}
