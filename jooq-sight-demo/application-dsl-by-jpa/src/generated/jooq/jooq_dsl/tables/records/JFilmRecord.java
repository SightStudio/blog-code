/*
 * This file is generated by jOOQ.
 */
package jooq.jooq_dsl.tables.records;


import java.math.BigDecimal;
import java.time.LocalDateTime;

import jooq.jooq_dsl.tables.JFilm;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record13;
import org.jooq.Row13;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JFilmRecord extends UpdatableRecordImpl<JFilmRecord> implements Record13<Integer, String, LocalDateTime, Integer, String, Integer, Integer, BigDecimal, BigDecimal, String, String, Integer, Integer> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>Film.filmId</code>.
     */
    public JFilmRecord setFilmid(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>Film.filmId</code>.
     */
    public Integer getFilmid() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>Film.description</code>.
     */
    public JFilmRecord setDescription(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>Film.description</code>.
     */
    public String getDescription() {
        return (String) get(1);
    }

    /**
     * Setter for <code>Film.lastUpdate</code>.
     */
    public JFilmRecord setLastupdate(LocalDateTime value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>Film.lastUpdate</code>.
     */
    public LocalDateTime getLastupdate() {
        return (LocalDateTime) get(2);
    }

    /**
     * Setter for <code>Film.length</code>.
     */
    public JFilmRecord setLength(Integer value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>Film.length</code>.
     */
    public Integer getLength() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>Film.rating</code>.
     */
    public JFilmRecord setRating(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>Film.rating</code>.
     */
    public String getRating() {
        return (String) get(4);
    }

    /**
     * Setter for <code>Film.releaseYear</code>.
     */
    public JFilmRecord setReleaseyear(Integer value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>Film.releaseYear</code>.
     */
    public Integer getReleaseyear() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>Film.rentalDuration</code>.
     */
    public JFilmRecord setRentalduration(Integer value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>Film.rentalDuration</code>.
     */
    public Integer getRentalduration() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>Film.rentalRate</code>.
     */
    public JFilmRecord setRentalrate(BigDecimal value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>Film.rentalRate</code>.
     */
    public BigDecimal getRentalrate() {
        return (BigDecimal) get(7);
    }

    /**
     * Setter for <code>Film.replacementCost</code>.
     */
    public JFilmRecord setReplacementcost(BigDecimal value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>Film.replacementCost</code>.
     */
    public BigDecimal getReplacementcost() {
        return (BigDecimal) get(8);
    }

    /**
     * Setter for <code>Film.specialFeatures</code>.
     */
    public JFilmRecord setSpecialfeatures(String value) {
        set(9, value);
        return this;
    }

    /**
     * Getter for <code>Film.specialFeatures</code>.
     */
    public String getSpecialfeatures() {
        return (String) get(9);
    }

    /**
     * Setter for <code>Film.title</code>.
     */
    public JFilmRecord setTitle(String value) {
        set(10, value);
        return this;
    }

    /**
     * Getter for <code>Film.title</code>.
     */
    public String getTitle() {
        return (String) get(10);
    }

    /**
     * Setter for <code>Film.language_id</code>.
     */
    public JFilmRecord setLanguageId(Integer value) {
        set(11, value);
        return this;
    }

    /**
     * Getter for <code>Film.language_id</code>.
     */
    public Integer getLanguageId() {
        return (Integer) get(11);
    }

    /**
     * Setter for <code>Film.original_language_id</code>.
     */
    public JFilmRecord setOriginalLanguageId(Integer value) {
        set(12, value);
        return this;
    }

    /**
     * Getter for <code>Film.original_language_id</code>.
     */
    public Integer getOriginalLanguageId() {
        return (Integer) get(12);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record13 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row13<Integer, String, LocalDateTime, Integer, String, Integer, Integer, BigDecimal, BigDecimal, String, String, Integer, Integer> fieldsRow() {
        return (Row13) super.fieldsRow();
    }

    @Override
    public Row13<Integer, String, LocalDateTime, Integer, String, Integer, Integer, BigDecimal, BigDecimal, String, String, Integer, Integer> valuesRow() {
        return (Row13) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return JFilm.FILM.FILMID;
    }

    @Override
    public Field<String> field2() {
        return JFilm.FILM.DESCRIPTION;
    }

    @Override
    public Field<LocalDateTime> field3() {
        return JFilm.FILM.LASTUPDATE;
    }

    @Override
    public Field<Integer> field4() {
        return JFilm.FILM.LENGTH;
    }

    @Override
    public Field<String> field5() {
        return JFilm.FILM.RATING;
    }

    @Override
    public Field<Integer> field6() {
        return JFilm.FILM.RELEASEYEAR;
    }

    @Override
    public Field<Integer> field7() {
        return JFilm.FILM.RENTALDURATION;
    }

    @Override
    public Field<BigDecimal> field8() {
        return JFilm.FILM.RENTALRATE;
    }

    @Override
    public Field<BigDecimal> field9() {
        return JFilm.FILM.REPLACEMENTCOST;
    }

    @Override
    public Field<String> field10() {
        return JFilm.FILM.SPECIALFEATURES;
    }

    @Override
    public Field<String> field11() {
        return JFilm.FILM.TITLE;
    }

    @Override
    public Field<Integer> field12() {
        return JFilm.FILM.LANGUAGE_ID;
    }

    @Override
    public Field<Integer> field13() {
        return JFilm.FILM.ORIGINAL_LANGUAGE_ID;
    }

    @Override
    public Integer component1() {
        return getFilmid();
    }

    @Override
    public String component2() {
        return getDescription();
    }

    @Override
    public LocalDateTime component3() {
        return getLastupdate();
    }

    @Override
    public Integer component4() {
        return getLength();
    }

    @Override
    public String component5() {
        return getRating();
    }

    @Override
    public Integer component6() {
        return getReleaseyear();
    }

    @Override
    public Integer component7() {
        return getRentalduration();
    }

    @Override
    public BigDecimal component8() {
        return getRentalrate();
    }

    @Override
    public BigDecimal component9() {
        return getReplacementcost();
    }

    @Override
    public String component10() {
        return getSpecialfeatures();
    }

    @Override
    public String component11() {
        return getTitle();
    }

    @Override
    public Integer component12() {
        return getLanguageId();
    }

    @Override
    public Integer component13() {
        return getOriginalLanguageId();
    }

    @Override
    public Integer value1() {
        return getFilmid();
    }

    @Override
    public String value2() {
        return getDescription();
    }

    @Override
    public LocalDateTime value3() {
        return getLastupdate();
    }

    @Override
    public Integer value4() {
        return getLength();
    }

    @Override
    public String value5() {
        return getRating();
    }

    @Override
    public Integer value6() {
        return getReleaseyear();
    }

    @Override
    public Integer value7() {
        return getRentalduration();
    }

    @Override
    public BigDecimal value8() {
        return getRentalrate();
    }

    @Override
    public BigDecimal value9() {
        return getReplacementcost();
    }

    @Override
    public String value10() {
        return getSpecialfeatures();
    }

    @Override
    public String value11() {
        return getTitle();
    }

    @Override
    public Integer value12() {
        return getLanguageId();
    }

    @Override
    public Integer value13() {
        return getOriginalLanguageId();
    }

    @Override
    public JFilmRecord value1(Integer value) {
        setFilmid(value);
        return this;
    }

    @Override
    public JFilmRecord value2(String value) {
        setDescription(value);
        return this;
    }

    @Override
    public JFilmRecord value3(LocalDateTime value) {
        setLastupdate(value);
        return this;
    }

    @Override
    public JFilmRecord value4(Integer value) {
        setLength(value);
        return this;
    }

    @Override
    public JFilmRecord value5(String value) {
        setRating(value);
        return this;
    }

    @Override
    public JFilmRecord value6(Integer value) {
        setReleaseyear(value);
        return this;
    }

    @Override
    public JFilmRecord value7(Integer value) {
        setRentalduration(value);
        return this;
    }

    @Override
    public JFilmRecord value8(BigDecimal value) {
        setRentalrate(value);
        return this;
    }

    @Override
    public JFilmRecord value9(BigDecimal value) {
        setReplacementcost(value);
        return this;
    }

    @Override
    public JFilmRecord value10(String value) {
        setSpecialfeatures(value);
        return this;
    }

    @Override
    public JFilmRecord value11(String value) {
        setTitle(value);
        return this;
    }

    @Override
    public JFilmRecord value12(Integer value) {
        setLanguageId(value);
        return this;
    }

    @Override
    public JFilmRecord value13(Integer value) {
        setOriginalLanguageId(value);
        return this;
    }

    @Override
    public JFilmRecord values(Integer value1, String value2, LocalDateTime value3, Integer value4, String value5, Integer value6, Integer value7, BigDecimal value8, BigDecimal value9, String value10, String value11, Integer value12, Integer value13) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached JFilmRecord
     */
    public JFilmRecord() {
        super(JFilm.FILM);
    }

    /**
     * Create a detached, initialised JFilmRecord
     */
    public JFilmRecord(Integer filmid, String description, LocalDateTime lastupdate, Integer length, String rating, Integer releaseyear, Integer rentalduration, BigDecimal rentalrate, BigDecimal replacementcost, String specialfeatures, String title, Integer languageId, Integer originalLanguageId) {
        super(JFilm.FILM);

        setFilmid(filmid);
        setDescription(description);
        setLastupdate(lastupdate);
        setLength(length);
        setRating(rating);
        setReleaseyear(releaseyear);
        setRentalduration(rentalduration);
        setRentalrate(rentalrate);
        setReplacementcost(replacementcost);
        setSpecialfeatures(specialfeatures);
        setTitle(title);
        setLanguageId(languageId);
        setOriginalLanguageId(originalLanguageId);
        resetChangedOnNotNull();
    }

    /**
     * Create a detached, initialised JFilmRecord
     */
    public JFilmRecord(jooq.jooq_dsl.tables.pojos.JFilm value) {
        super(JFilm.FILM);

        if (value != null) {
            setFilmid(value.getFilmid());
            setDescription(value.getDescription());
            setLastupdate(value.getLastupdate());
            setLength(value.getLength());
            setRating(value.getRating());
            setReleaseyear(value.getReleaseyear());
            setRentalduration(value.getRentalduration());
            setRentalrate(value.getRentalrate());
            setReplacementcost(value.getReplacementcost());
            setSpecialfeatures(value.getSpecialfeatures());
            setTitle(value.getTitle());
            setLanguageId(value.getLanguageId());
            setOriginalLanguageId(value.getOriginalLanguageId());
            resetChangedOnNotNull();
        }
    }
}