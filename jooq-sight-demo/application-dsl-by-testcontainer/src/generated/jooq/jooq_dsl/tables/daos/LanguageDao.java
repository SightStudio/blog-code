/*
 * This file is generated by jOOQ.
 */
package jooq.jooq_dsl.tables.daos;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import jooq.jooq_dsl.AbstractSpringDAOImpl;
import jooq.jooq_dsl.tables.JLanguage;
import jooq.jooq_dsl.tables.records.JLanguageRecord;

import org.jooq.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Repository
public class LanguageDao extends AbstractSpringDAOImpl<JLanguageRecord, jooq.jooq_dsl.tables.pojos.JLanguage, Integer> {

    /**
     * Create a new LanguageDao without any configuration
     */
    public LanguageDao() {
        super(JLanguage.LANGUAGE, jooq.jooq_dsl.tables.pojos.JLanguage.class);
    }

    /**
     * Create a new LanguageDao with an attached configuration
     */
    @Autowired
    public LanguageDao(Configuration configuration) {
        super(JLanguage.LANGUAGE, jooq.jooq_dsl.tables.pojos.JLanguage.class, configuration);
    }

    @Override
    public Integer getId(jooq.jooq_dsl.tables.pojos.JLanguage object) {
        return object.getLanguageId();
    }

    /**
     * Fetch records that have <code>language_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<jooq.jooq_dsl.tables.pojos.JLanguage> fetchRangeOfJLanguageId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(JLanguage.LANGUAGE.LANGUAGE_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>language_id IN (values)</code>
     */
    public List<jooq.jooq_dsl.tables.pojos.JLanguage> fetchByJLanguageId(Integer... values) {
        return fetch(JLanguage.LANGUAGE.LANGUAGE_ID, values);
    }

    /**
     * Fetch a unique record that has <code>language_id = value</code>
     */
    public jooq.jooq_dsl.tables.pojos.JLanguage fetchOneByJLanguageId(Integer value) {
        return fetchOne(JLanguage.LANGUAGE.LANGUAGE_ID, value);
    }

    /**
     * Fetch a unique record that has <code>language_id = value</code>
     */
    public Optional<jooq.jooq_dsl.tables.pojos.JLanguage> fetchOptionalByJLanguageId(Integer value) {
        return fetchOptional(JLanguage.LANGUAGE.LANGUAGE_ID, value);
    }

    /**
     * Fetch records that have <code>name BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<jooq.jooq_dsl.tables.pojos.JLanguage> fetchRangeOfJName(String lowerInclusive, String upperInclusive) {
        return fetchRange(JLanguage.LANGUAGE.NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    public List<jooq.jooq_dsl.tables.pojos.JLanguage> fetchByJName(String... values) {
        return fetch(JLanguage.LANGUAGE.NAME, values);
    }

    /**
     * Fetch records that have <code>last_update BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<jooq.jooq_dsl.tables.pojos.JLanguage> fetchRangeOfJLastUpdate(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(JLanguage.LANGUAGE.LAST_UPDATE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>last_update IN (values)</code>
     */
    public List<jooq.jooq_dsl.tables.pojos.JLanguage> fetchByJLastUpdate(LocalDateTime... values) {
        return fetch(JLanguage.LANGUAGE.LAST_UPDATE, values);
    }
}
