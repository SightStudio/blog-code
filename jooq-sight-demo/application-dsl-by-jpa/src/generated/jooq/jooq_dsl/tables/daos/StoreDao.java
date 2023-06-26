/*
 * This file is generated by jOOQ.
 */
package jooq.jooq_dsl.tables.daos;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import jooq.jooq_dsl.AbstractSpringDAOImpl;
import jooq.jooq_dsl.tables.JStore;
import jooq.jooq_dsl.tables.records.JStoreRecord;

import org.jooq.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Repository
public class StoreDao extends AbstractSpringDAOImpl<JStoreRecord, jooq.jooq_dsl.tables.pojos.JStore, Integer> {

    /**
     * Create a new StoreDao without any configuration
     */
    public StoreDao() {
        super(JStore.STORE, jooq.jooq_dsl.tables.pojos.JStore.class);
    }

    /**
     * Create a new StoreDao with an attached configuration
     */
    @Autowired
    public StoreDao(Configuration configuration) {
        super(JStore.STORE, jooq.jooq_dsl.tables.pojos.JStore.class, configuration);
    }

    @Override
    public Integer getId(jooq.jooq_dsl.tables.pojos.JStore object) {
        return object.getStoreid();
    }

    /**
     * Fetch records that have <code>storeId BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<jooq.jooq_dsl.tables.pojos.JStore> fetchRangeOfJStoreid(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(JStore.STORE.STOREID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>storeId IN (values)</code>
     */
    public List<jooq.jooq_dsl.tables.pojos.JStore> fetchByJStoreid(Integer... values) {
        return fetch(JStore.STORE.STOREID, values);
    }

    /**
     * Fetch a unique record that has <code>storeId = value</code>
     */
    public jooq.jooq_dsl.tables.pojos.JStore fetchOneByJStoreid(Integer value) {
        return fetchOne(JStore.STORE.STOREID, value);
    }

    /**
     * Fetch a unique record that has <code>storeId = value</code>
     */
    public Optional<jooq.jooq_dsl.tables.pojos.JStore> fetchOptionalByJStoreid(Integer value) {
        return fetchOptional(JStore.STORE.STOREID, value);
    }

    /**
     * Fetch records that have <code>lastUpdate BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<jooq.jooq_dsl.tables.pojos.JStore> fetchRangeOfJLastupdate(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(JStore.STORE.LASTUPDATE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>lastUpdate IN (values)</code>
     */
    public List<jooq.jooq_dsl.tables.pojos.JStore> fetchByJLastupdate(LocalDateTime... values) {
        return fetch(JStore.STORE.LASTUPDATE, values);
    }

    /**
     * Fetch records that have <code>address_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<jooq.jooq_dsl.tables.pojos.JStore> fetchRangeOfJAddressId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(JStore.STORE.ADDRESS_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>address_id IN (values)</code>
     */
    public List<jooq.jooq_dsl.tables.pojos.JStore> fetchByJAddressId(Integer... values) {
        return fetch(JStore.STORE.ADDRESS_ID, values);
    }

    /**
     * Fetch records that have <code>manager_staff_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<jooq.jooq_dsl.tables.pojos.JStore> fetchRangeOfJManagerStaffId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(JStore.STORE.MANAGER_STAFF_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>manager_staff_id IN (values)</code>
     */
    public List<jooq.jooq_dsl.tables.pojos.JStore> fetchByJManagerStaffId(Integer... values) {
        return fetch(JStore.STORE.MANAGER_STAFF_ID, values);
    }
}
