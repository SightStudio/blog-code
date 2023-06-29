/*
 * This file is generated by jOOQ.
 */
package jooq.jooq_dsl.tables.daos;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import jooq.jooq_dsl.AbstractSpringDAOImpl;
import jooq.jooq_dsl.tables.JInventory;
import jooq.jooq_dsl.tables.records.JInventoryRecord;

import org.jooq.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Repository
public class InventoryDao extends AbstractSpringDAOImpl<JInventoryRecord, jooq.jooq_dsl.tables.pojos.JInventory, Integer> {

    /**
     * Create a new InventoryDao without any configuration
     */
    public InventoryDao() {
        super(JInventory.INVENTORY, jooq.jooq_dsl.tables.pojos.JInventory.class);
    }

    /**
     * Create a new InventoryDao with an attached configuration
     */
    @Autowired
    public InventoryDao(Configuration configuration) {
        super(JInventory.INVENTORY, jooq.jooq_dsl.tables.pojos.JInventory.class, configuration);
    }

    @Override
    public Integer getId(jooq.jooq_dsl.tables.pojos.JInventory object) {
        return object.getInventoryid();
    }

    /**
     * Fetch records that have <code>inventoryId BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<jooq.jooq_dsl.tables.pojos.JInventory> fetchRangeOfJInventoryid(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(JInventory.INVENTORY.INVENTORYID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>inventoryId IN (values)</code>
     */
    public List<jooq.jooq_dsl.tables.pojos.JInventory> fetchByJInventoryid(Integer... values) {
        return fetch(JInventory.INVENTORY.INVENTORYID, values);
    }

    /**
     * Fetch a unique record that has <code>inventoryId = value</code>
     */
    public jooq.jooq_dsl.tables.pojos.JInventory fetchOneByJInventoryid(Integer value) {
        return fetchOne(JInventory.INVENTORY.INVENTORYID, value);
    }

    /**
     * Fetch a unique record that has <code>inventoryId = value</code>
     */
    public Optional<jooq.jooq_dsl.tables.pojos.JInventory> fetchOptionalByJInventoryid(Integer value) {
        return fetchOptional(JInventory.INVENTORY.INVENTORYID, value);
    }

    /**
     * Fetch records that have <code>lastUpdate BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<jooq.jooq_dsl.tables.pojos.JInventory> fetchRangeOfJLastupdate(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(JInventory.INVENTORY.LASTUPDATE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>lastUpdate IN (values)</code>
     */
    public List<jooq.jooq_dsl.tables.pojos.JInventory> fetchByJLastupdate(LocalDateTime... values) {
        return fetch(JInventory.INVENTORY.LASTUPDATE, values);
    }

    /**
     * Fetch records that have <code>film_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<jooq.jooq_dsl.tables.pojos.JInventory> fetchRangeOfJFilmId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(JInventory.INVENTORY.FILM_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>film_id IN (values)</code>
     */
    public List<jooq.jooq_dsl.tables.pojos.JInventory> fetchByJFilmId(Integer... values) {
        return fetch(JInventory.INVENTORY.FILM_ID, values);
    }

    /**
     * Fetch records that have <code>store_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<jooq.jooq_dsl.tables.pojos.JInventory> fetchRangeOfJStoreId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(JInventory.INVENTORY.STORE_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>store_id IN (values)</code>
     */
    public List<jooq.jooq_dsl.tables.pojos.JInventory> fetchByJStoreId(Integer... values) {
        return fetch(JInventory.INVENTORY.STORE_ID, values);
    }
}