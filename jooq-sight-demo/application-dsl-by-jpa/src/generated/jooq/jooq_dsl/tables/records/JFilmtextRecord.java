/*
 * This file is generated by jOOQ.
 */
package jooq.jooq_dsl.tables.records;


import jooq.jooq_dsl.tables.JFilmtext;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JFilmtextRecord extends UpdatableRecordImpl<JFilmtextRecord> implements Record3<Integer, String, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>FilmText.filmId</code>.
     */
    public JFilmtextRecord setFilmid(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>FilmText.filmId</code>.
     */
    public Integer getFilmid() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>FilmText.description</code>.
     */
    public JFilmtextRecord setDescription(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>FilmText.description</code>.
     */
    public String getDescription() {
        return (String) get(1);
    }

    /**
     * Setter for <code>FilmText.title</code>.
     */
    public JFilmtextRecord setTitle(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>FilmText.title</code>.
     */
    public String getTitle() {
        return (String) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<Integer, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<Integer, String, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return JFilmtext.FILMTEXT.FILMID;
    }

    @Override
    public Field<String> field2() {
        return JFilmtext.FILMTEXT.DESCRIPTION;
    }

    @Override
    public Field<String> field3() {
        return JFilmtext.FILMTEXT.TITLE;
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
    public String component3() {
        return getTitle();
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
    public String value3() {
        return getTitle();
    }

    @Override
    public JFilmtextRecord value1(Integer value) {
        setFilmid(value);
        return this;
    }

    @Override
    public JFilmtextRecord value2(String value) {
        setDescription(value);
        return this;
    }

    @Override
    public JFilmtextRecord value3(String value) {
        setTitle(value);
        return this;
    }

    @Override
    public JFilmtextRecord values(Integer value1, String value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached JFilmtextRecord
     */
    public JFilmtextRecord() {
        super(JFilmtext.FILMTEXT);
    }

    /**
     * Create a detached, initialised JFilmtextRecord
     */
    public JFilmtextRecord(Integer filmid, String description, String title) {
        super(JFilmtext.FILMTEXT);

        setFilmid(filmid);
        setDescription(description);
        setTitle(title);
        resetChangedOnNotNull();
    }

    /**
     * Create a detached, initialised JFilmtextRecord
     */
    public JFilmtextRecord(jooq.jooq_dsl.tables.pojos.JFilmtext value) {
        super(JFilmtext.FILMTEXT);

        if (value != null) {
            setFilmid(value.getFilmid());
            setDescription(value.getDescription());
            setTitle(value.getTitle());
            resetChangedOnNotNull();
        }
    }
}
