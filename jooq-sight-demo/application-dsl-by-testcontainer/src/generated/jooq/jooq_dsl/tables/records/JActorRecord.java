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
     * Setter for <code>sakila.actor.actor_id</code>.
     */
    public JActorRecord setActorId(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>sakila.actor.actor_id</code>.
     */
    public Integer getActorId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>sakila.actor.first_name</code>.
     */
    public JActorRecord setFirstName(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>sakila.actor.first_name</code>.
     */
    public String getFirstName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>sakila.actor.last_name</code>.
     */
    public JActorRecord setLastName(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>sakila.actor.last_name</code>.
     */
    public String getLastName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>sakila.actor.last_update</code>.
     */
    public JActorRecord setLastUpdate(LocalDateTime value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>sakila.actor.last_update</code>.
     */
    public LocalDateTime getLastUpdate() {
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
        return JActor.ACTOR.ACTOR_ID;
    }

    @Override
    public Field<String> field2() {
        return JActor.ACTOR.FIRST_NAME;
    }

    @Override
    public Field<String> field3() {
        return JActor.ACTOR.LAST_NAME;
    }

    @Override
    public Field<LocalDateTime> field4() {
        return JActor.ACTOR.LAST_UPDATE;
    }

    @Override
    public Integer component1() {
        return getActorId();
    }

    @Override
    public String component2() {
        return getFirstName();
    }

    @Override
    public String component3() {
        return getLastName();
    }

    @Override
    public LocalDateTime component4() {
        return getLastUpdate();
    }

    @Override
    public Integer value1() {
        return getActorId();
    }

    @Override
    public String value2() {
        return getFirstName();
    }

    @Override
    public String value3() {
        return getLastName();
    }

    @Override
    public LocalDateTime value4() {
        return getLastUpdate();
    }

    @Override
    public JActorRecord value1(Integer value) {
        setActorId(value);
        return this;
    }

    @Override
    public JActorRecord value2(String value) {
        setFirstName(value);
        return this;
    }

    @Override
    public JActorRecord value3(String value) {
        setLastName(value);
        return this;
    }

    @Override
    public JActorRecord value4(LocalDateTime value) {
        setLastUpdate(value);
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
    public JActorRecord(Integer actorId, String firstName, String lastName, LocalDateTime lastUpdate) {
        super(JActor.ACTOR);

        setActorId(actorId);
        setFirstName(firstName);
        setLastName(lastName);
        setLastUpdate(lastUpdate);
        resetChangedOnNotNull();
    }

    /**
     * Create a detached, initialised JActorRecord
     */
    public JActorRecord(jooq.jooq_dsl.tables.pojos.JActor value) {
        super(JActor.ACTOR);

        if (value != null) {
            setActorId(value.getActorId());
            setFirstName(value.getFirstName());
            setLastName(value.getLastName());
            setLastUpdate(value.getLastUpdate());
            resetChangedOnNotNull();
        }
    }
}
