/*
 * This file is generated by jOOQ.
 */
package jooq.jooq_dsl.tables.daos;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import jooq.jooq_dsl.AbstractSpringDAOImpl;
import jooq.jooq_dsl.tables.JFlywaySchemaHistory;
import jooq.jooq_dsl.tables.records.JFlywaySchemaHistoryRecord;

import org.jooq.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Repository
public class FlywaySchemaHistoryDao extends AbstractSpringDAOImpl<JFlywaySchemaHistoryRecord, jooq.jooq_dsl.tables.pojos.JFlywaySchemaHistory, Integer> {

    /**
     * Create a new FlywaySchemaHistoryDao without any configuration
     */
    public FlywaySchemaHistoryDao() {
        super(JFlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY, jooq.jooq_dsl.tables.pojos.JFlywaySchemaHistory.class);
    }

    /**
     * Create a new FlywaySchemaHistoryDao with an attached configuration
     */
    @Autowired
    public FlywaySchemaHistoryDao(Configuration configuration) {
        super(JFlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY, jooq.jooq_dsl.tables.pojos.JFlywaySchemaHistory.class, configuration);
    }

    @Override
    public Integer getId(jooq.jooq_dsl.tables.pojos.JFlywaySchemaHistory object) {
        return object.getInstalledRank();
    }

    /**
     * Fetch records that have <code>installed_rank BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<jooq.jooq_dsl.tables.pojos.JFlywaySchemaHistory> fetchRangeOfJInstalledRank(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(JFlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.INSTALLED_RANK, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>installed_rank IN (values)</code>
     */
    public List<jooq.jooq_dsl.tables.pojos.JFlywaySchemaHistory> fetchByJInstalledRank(Integer... values) {
        return fetch(JFlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.INSTALLED_RANK, values);
    }

    /**
     * Fetch a unique record that has <code>installed_rank = value</code>
     */
    public jooq.jooq_dsl.tables.pojos.JFlywaySchemaHistory fetchOneByJInstalledRank(Integer value) {
        return fetchOne(JFlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.INSTALLED_RANK, value);
    }

    /**
     * Fetch a unique record that has <code>installed_rank = value</code>
     */
    public Optional<jooq.jooq_dsl.tables.pojos.JFlywaySchemaHistory> fetchOptionalByJInstalledRank(Integer value) {
        return fetchOptional(JFlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.INSTALLED_RANK, value);
    }

    /**
     * Fetch records that have <code>version BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<jooq.jooq_dsl.tables.pojos.JFlywaySchemaHistory> fetchRangeOfJVersion(String lowerInclusive, String upperInclusive) {
        return fetchRange(JFlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.VERSION, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>version IN (values)</code>
     */
    public List<jooq.jooq_dsl.tables.pojos.JFlywaySchemaHistory> fetchByJVersion(String... values) {
        return fetch(JFlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.VERSION, values);
    }

    /**
     * Fetch records that have <code>description BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<jooq.jooq_dsl.tables.pojos.JFlywaySchemaHistory> fetchRangeOfJDescription(String lowerInclusive, String upperInclusive) {
        return fetchRange(JFlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.DESCRIPTION, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>description IN (values)</code>
     */
    public List<jooq.jooq_dsl.tables.pojos.JFlywaySchemaHistory> fetchByJDescription(String... values) {
        return fetch(JFlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.DESCRIPTION, values);
    }

    /**
     * Fetch records that have <code>type BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<jooq.jooq_dsl.tables.pojos.JFlywaySchemaHistory> fetchRangeOfJType(String lowerInclusive, String upperInclusive) {
        return fetchRange(JFlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.TYPE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>type IN (values)</code>
     */
    public List<jooq.jooq_dsl.tables.pojos.JFlywaySchemaHistory> fetchByJType(String... values) {
        return fetch(JFlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.TYPE, values);
    }

    /**
     * Fetch records that have <code>script BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<jooq.jooq_dsl.tables.pojos.JFlywaySchemaHistory> fetchRangeOfJScript(String lowerInclusive, String upperInclusive) {
        return fetchRange(JFlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.SCRIPT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>script IN (values)</code>
     */
    public List<jooq.jooq_dsl.tables.pojos.JFlywaySchemaHistory> fetchByJScript(String... values) {
        return fetch(JFlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.SCRIPT, values);
    }

    /**
     * Fetch records that have <code>checksum BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<jooq.jooq_dsl.tables.pojos.JFlywaySchemaHistory> fetchRangeOfJChecksum(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(JFlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.CHECKSUM, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>checksum IN (values)</code>
     */
    public List<jooq.jooq_dsl.tables.pojos.JFlywaySchemaHistory> fetchByJChecksum(Integer... values) {
        return fetch(JFlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.CHECKSUM, values);
    }

    /**
     * Fetch records that have <code>installed_by BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<jooq.jooq_dsl.tables.pojos.JFlywaySchemaHistory> fetchRangeOfJInstalledBy(String lowerInclusive, String upperInclusive) {
        return fetchRange(JFlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.INSTALLED_BY, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>installed_by IN (values)</code>
     */
    public List<jooq.jooq_dsl.tables.pojos.JFlywaySchemaHistory> fetchByJInstalledBy(String... values) {
        return fetch(JFlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.INSTALLED_BY, values);
    }

    /**
     * Fetch records that have <code>installed_on BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<jooq.jooq_dsl.tables.pojos.JFlywaySchemaHistory> fetchRangeOfJInstalledOn(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(JFlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.INSTALLED_ON, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>installed_on IN (values)</code>
     */
    public List<jooq.jooq_dsl.tables.pojos.JFlywaySchemaHistory> fetchByJInstalledOn(LocalDateTime... values) {
        return fetch(JFlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.INSTALLED_ON, values);
    }

    /**
     * Fetch records that have <code>execution_time BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<jooq.jooq_dsl.tables.pojos.JFlywaySchemaHistory> fetchRangeOfJExecutionTime(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(JFlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.EXECUTION_TIME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>execution_time IN (values)</code>
     */
    public List<jooq.jooq_dsl.tables.pojos.JFlywaySchemaHistory> fetchByJExecutionTime(Integer... values) {
        return fetch(JFlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.EXECUTION_TIME, values);
    }

    /**
     * Fetch records that have <code>success BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<jooq.jooq_dsl.tables.pojos.JFlywaySchemaHistory> fetchRangeOfJSuccess(Byte lowerInclusive, Byte upperInclusive) {
        return fetchRange(JFlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.SUCCESS, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>success IN (values)</code>
     */
    public List<jooq.jooq_dsl.tables.pojos.JFlywaySchemaHistory> fetchByJSuccess(Byte... values) {
        return fetch(JFlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.SUCCESS, values);
    }
}
