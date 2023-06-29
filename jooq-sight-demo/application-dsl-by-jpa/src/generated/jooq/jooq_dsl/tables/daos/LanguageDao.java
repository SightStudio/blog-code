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
        return object.getLanguageid();
    }

    /**
     * Fetch records that have <code>languageId BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<jooq.jooq_dsl.tables.pojos.JLanguage> fetchRangeOfJLanguageid(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(JLanguage.LANGUAGE.LANGUAGEID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>languageId IN (values)</code>
     */
    public List<jooq.jooq_dsl.tables.pojos.JLanguage> fetchByJLanguageid(Integer... values) {
        return fetch(JLanguage.LANGUAGE.LANGUAGEID, values);
    }

    /**
     * Fetch a unique record that has <code>languageId = value</code>
     */
    public jooq.jooq_dsl.tables.pojos.JLanguage fetchOneByJLanguageid(Integer value) {
        return fetchOne(JLanguage.LANGUAGE.LANGUAGEID, value);
    }

    /**
     * Fetch a unique record that has <code>languageId = value</code>
     */
    public Optional<jooq.jooq_dsl.tables.pojos.JLanguage> fetchOptionalByJLanguageid(Integer value) {
        return fetchOptional(JLanguage.LANGUAGE.LANGUAGEID, value);
    }

    /**
     * Fetch records that have <code>lastUpdate BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<jooq.jooq_dsl.tables.pojos.JLanguage> fetchRangeOfJLastupdate(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(JLanguage.LANGUAGE.LASTUPDATE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>lastUpdate IN (values)</code>
     */
    public List<jooq.jooq_dsl.tables.pojos.JLanguage> fetchByJLastupdate(LocalDateTime... values) {
        return fetch(JLanguage.LANGUAGE.LASTUPDATE, values);
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
}