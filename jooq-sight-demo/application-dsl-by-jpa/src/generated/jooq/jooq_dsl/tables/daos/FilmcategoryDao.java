/*
 * This file is generated by jOOQ.
 */
package jooq.jooq_dsl.tables.daos;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import jooq.jooq_dsl.AbstractSpringDAOImpl;
import jooq.jooq_dsl.tables.JFilmcategory;
import jooq.jooq_dsl.tables.records.JFilmcategoryRecord;

import org.jooq.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Repository
public class FilmcategoryDao extends AbstractSpringDAOImpl<JFilmcategoryRecord, jooq.jooq_dsl.tables.pojos.JFilmcategory, Long> {

    /**
     * Create a new FilmcategoryDao without any configuration
     */
    public FilmcategoryDao() {
        super(JFilmcategory.FILMCATEGORY, jooq.jooq_dsl.tables.pojos.JFilmcategory.class);
    }

    /**
     * Create a new FilmcategoryDao with an attached configuration
     */
    @Autowired
    public FilmcategoryDao(Configuration configuration) {
        super(JFilmcategory.FILMCATEGORY, jooq.jooq_dsl.tables.pojos.JFilmcategory.class, configuration);
    }

    @Override
    public Long getId(jooq.jooq_dsl.tables.pojos.JFilmcategory object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<jooq.jooq_dsl.tables.pojos.JFilmcategory> fetchRangeOfJId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(JFilmcategory.FILMCATEGORY.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<jooq.jooq_dsl.tables.pojos.JFilmcategory> fetchByJId(Long... values) {
        return fetch(JFilmcategory.FILMCATEGORY.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public jooq.jooq_dsl.tables.pojos.JFilmcategory fetchOneByJId(Long value) {
        return fetchOne(JFilmcategory.FILMCATEGORY.ID, value);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public Optional<jooq.jooq_dsl.tables.pojos.JFilmcategory> fetchOptionalByJId(Long value) {
        return fetchOptional(JFilmcategory.FILMCATEGORY.ID, value);
    }

    /**
     * Fetch records that have <code>lastUpdate BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<jooq.jooq_dsl.tables.pojos.JFilmcategory> fetchRangeOfJLastupdate(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(JFilmcategory.FILMCATEGORY.LASTUPDATE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>lastUpdate IN (values)</code>
     */
    public List<jooq.jooq_dsl.tables.pojos.JFilmcategory> fetchByJLastupdate(LocalDateTime... values) {
        return fetch(JFilmcategory.FILMCATEGORY.LASTUPDATE, values);
    }

    /**
     * Fetch records that have <code>category_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<jooq.jooq_dsl.tables.pojos.JFilmcategory> fetchRangeOfJCategoryId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(JFilmcategory.FILMCATEGORY.CATEGORY_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>category_id IN (values)</code>
     */
    public List<jooq.jooq_dsl.tables.pojos.JFilmcategory> fetchByJCategoryId(Integer... values) {
        return fetch(JFilmcategory.FILMCATEGORY.CATEGORY_ID, values);
    }

    /**
     * Fetch records that have <code>film_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<jooq.jooq_dsl.tables.pojos.JFilmcategory> fetchRangeOfJFilmId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(JFilmcategory.FILMCATEGORY.FILM_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>film_id IN (values)</code>
     */
    public List<jooq.jooq_dsl.tables.pojos.JFilmcategory> fetchByJFilmId(Integer... values) {
        return fetch(JFilmcategory.FILMCATEGORY.FILM_ID, values);
    }
}
