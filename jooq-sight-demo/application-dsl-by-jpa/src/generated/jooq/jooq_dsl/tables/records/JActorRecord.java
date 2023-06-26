/*
 * This file is generated by jOOQ.
 */
package jooq.jooq_dsl.tables.records;


import java.time.LocalDateTime;

import jooq.jooq_dsl.tables.JActor;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JActorRecord extends UpdatableRecordImpl<JActorRecord> implements Record4<Integer, String, String, LocalDateTime> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>Actor.actorId</code>.
     */
    public JActorRecord setActorid(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>Actor.actorId</code>.
     */
    public Integer getActorid() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>Actor.firstName</code>.
     */
    public JActorRecord setFirstname(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>Actor.firstName</code>.
     */
    public String getFirstname() {
        return (String) get(1);
    }

    /**
     * Setter for <code>Actor.lastName</code>.
     */
    public JActorRecord setLastname(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>Actor.lastName</code>.
     */
    public String getLastname() {
        return (String) get(2);
    }

    /**
     * Setter for <code>Actor.lastUpdate</code>.
     */
    public JActorRecord setLastupdate(LocalDateTime value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>Actor.lastUpdate</code>.
     */
    public LocalDateTime getLastupdate() {
        return (LocalDateTime) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<Integer, String, String, LocalDateTime> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<Integer, String, String, LocalDateTime> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return JActor.ACTOR.ACTORID;
    }

    @Override
    public Field<String> field2() {
        return JActor.ACTOR.FIRSTNAME;
    }

    @Override
    public Field<String> field3() {
        return JActor.ACTOR.LASTNAME;
    }

    @Override
    public Field<LocalDateTime> field4() {
        return JActor.ACTOR.LASTUPDATE;
    }

    @Override
    public Integer component1() {
        return getActorid();
    }

    @Override
    public String component2() {
        return getFirstname();
    }

    @Override
    public String component3() {
        return getLastname();
    }

    @Override
    public LocalDateTime component4() {
        return getLastupdate();
    }

    @Override
    public Integer value1() {
        return getActorid();
    }

    @Override
    public String value2() {
        return getFirstname();
    }

    @Override
    public String value3() {
        return getLastname();
    }

    @Override
    public LocalDateTime value4() {
        return getLastupdate();
    }

    @Override
    public JActorRecord value1(Integer value) {
        setActorid(value);
        return this;
    }

    @Override
    public JActorRecord value2(String value) {
        setFirstname(value);
        return this;
    }

    @Override
    public JActorRecord value3(String value) {
        setLastname(value);
        return this;
    }

    @Override
    public JActorRecord value4(LocalDateTime value) {
        setLastupdate(value);
        return this;
    }

    @Override
    public JActorRecord values(Integer value1, String value2, String value3, LocalDateTime value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached JActorRecord
     */
    public JActorRecord() {
        super(JActor.ACTOR);
    }

    /**
     * Create a detached, initialised JActorRecord
     */
    public JActorRecord(Integer actorid, String firstname, String lastname, LocalDateTime lastupdate) {
        super(JActor.ACTOR);

        setActorid(actorid);
        setFirstname(firstname);
        setLastname(lastname);
        setLastupdate(lastupdate);
        resetChangedOnNotNull();
    }

    /**
     * Create a detached, initialised JActorRecord
     */
    public JActorRecord(jooq.jooq_dsl.tables.pojos.JActor value) {
        super(JActor.ACTOR);

        if (value != null) {
            setActorid(value.getActorid());
            setFirstname(value.getFirstname());
            setLastname(value.getLastname());
            setLastupdate(value.getLastupdate());
            resetChangedOnNotNull();
        }
    }
}
