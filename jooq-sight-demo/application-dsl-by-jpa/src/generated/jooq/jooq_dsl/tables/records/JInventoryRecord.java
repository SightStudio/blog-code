/*
 * This file is generated by jOOQ.
 */
package jooq.jooq_dsl.tables.records;


import java.time.LocalDateTime;

import jooq.jooq_dsl.tables.JInventory;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JInventoryRecord extends UpdatableRecordImpl<JInventoryRecord> implements Record4<Integer, LocalDateTime, Integer, Integer> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>Inventory.inventoryId</code>.
     */
    public JInventoryRecord setInventoryid(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>Inventory.inventoryId</code>.
     */
    public Integer getInventoryid() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>Inventory.lastUpdate</code>.
     */
    public JInventoryRecord setLastupdate(LocalDateTime value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>Inventory.lastUpdate</code>.
     */
    public LocalDateTime getLastupdate() {
        return (LocalDateTime) get(1);
    }

    /**
     * Setter for <code>Inventory.film_id</code>.
     */
    public JInventoryRecord setFilmId(Integer value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>Inventory.film_id</code>.
     */
    public Integer getFilmId() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>Inventory.store_id</code>.
     */
    public JInventoryRecord setStoreId(Integer value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>Inventory.store_id</code>.
     */
    public Integer getStoreId() {
        return (Integer) get(3);
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
    public Row4<Integer, LocalDateTime, Integer, Integer> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<Integer, LocalDateTime, Integer, Integer> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return JInventory.INVENTORY.INVENTORYID;
    }

    @Override
    public Field<LocalDateTime> field2() {
        return JInventory.INVENTORY.LASTUPDATE;
    }

    @Override
    public Field<Integer> field3() {
        return JInventory.INVENTORY.FILM_ID;
    }

    @Override
    public Field<Integer> field4() {
        return JInventory.INVENTORY.STORE_ID;
    }

    @Override
    public Integer component1() {
        return getInventoryid();
    }

    @Override
    public LocalDateTime component2() {
        return getLastupdate();
    }

    @Override
    public Integer component3() {
        return getFilmId();
    }

    @Override
    public Integer component4() {
        return getStoreId();
    }

    @Override
    public Integer value1() {
        return getInventoryid();
    }

    @Override
    public LocalDateTime value2() {
        return getLastupdate();
    }

    @Override
    public Integer value3() {
        return getFilmId();
    }

    @Override
    public Integer value4() {
        return getStoreId();
    }

    @Override
    public JInventoryRecord value1(Integer value) {
        setInventoryid(value);
        return this;
    }

    @Override
    public JInventoryRecord value2(LocalDateTime value) {
        setLastupdate(value);
        return this;
    }

    @Override
    public JInventoryRecord value3(Integer value) {
        setFilmId(value);
        return this;
    }

    @Override
    public JInventoryRecord value4(Integer value) {
        setStoreId(value);
        return this;
    }

    @Override
    public JInventoryRecord values(Integer value1, LocalDateTime value2, Integer value3, Integer value4) {
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
     * Create a detached JInventoryRecord
     */
    public JInventoryRecord() {
        super(JInventory.INVENTORY);
    }

    /**
     * Create a detached, initialised JInventoryRecord
     */
    public JInventoryRecord(Integer inventoryid, LocalDateTime lastupdate, Integer filmId, Integer storeId) {
        super(JInventory.INVENTORY);

        setInventoryid(inventoryid);
        setLastupdate(lastupdate);
        setFilmId(filmId);
        setStoreId(storeId);
        resetChangedOnNotNull();
    }

    /**
     * Create a detached, initialised JInventoryRecord
     */
    public JInventoryRecord(jooq.jooq_dsl.tables.pojos.JInventory value) {
        super(JInventory.INVENTORY);

        if (value != null) {
            setInventoryid(value.getInventoryid());
            setLastupdate(value.getLastupdate());
            setFilmId(value.getFilmId());
            setStoreId(value.getStoreId());
            resetChangedOnNotNull();
        }
    }
}
