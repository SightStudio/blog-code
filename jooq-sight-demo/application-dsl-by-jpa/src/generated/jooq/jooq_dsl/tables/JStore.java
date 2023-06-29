/*
 * This file is generated by jOOQ.
 */
package jooq.jooq_dsl.tables;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import jooq.jooq_dsl.DefaultSchema;
import jooq.jooq_dsl.Keys;
import jooq.jooq_dsl.tables.records.JStoreRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function4;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row4;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JStore extends TableImpl<JStoreRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>Store</code>
     */
    public static final JStore STORE = new JStore();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<JStoreRecord> getRecordType() {
        return JStoreRecord.class;
    }

    /**
     * The column <code>Store.storeId</code>.
     */
    public final TableField<JStoreRecord, Integer> STOREID = createField(DSL.name("storeId"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>Store.lastUpdate</code>.
     */
    public final TableField<JStoreRecord, LocalDateTime> LASTUPDATE = createField(DSL.name("lastUpdate"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "");

    /**
     * The column <code>Store.address_id</code>.
     */
    public final TableField<JStoreRecord, Integer> ADDRESS_ID = createField(DSL.name("address_id"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>Store.manager_staff_id</code>.
     */
    public final TableField<JStoreRecord, Integer> MANAGER_STAFF_ID = createField(DSL.name("manager_staff_id"), SQLDataType.INTEGER.nullable(false), this, "");

    private JStore(Name alias, Table<JStoreRecord> aliased) {
        this(alias, aliased, null);
    }

    private JStore(Name alias, Table<JStoreRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>Store</code> table reference
     */
    public JStore(String alias) {
        this(DSL.name(alias), STORE);
    }

    /**
     * Create an aliased <code>Store</code> table reference
     */
    public JStore(Name alias) {
        this(alias, STORE);
    }

    /**
     * Create a <code>Store</code> table reference
     */
    public JStore() {
        this(DSL.name("Store"), null);
    }

    public <O extends Record> JStore(Table<O> child, ForeignKey<O, JStoreRecord> key) {
        super(child, key, STORE);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public Identity<JStoreRecord, Integer> getIdentity() {
        return (Identity<JStoreRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<JStoreRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_4C;
    }

    @Override
    public List<ForeignKey<JStoreRecord, ?>> getReferences() {
        return Arrays.asList(Keys.FK1U30WQ6FJM3TRHXIH98K8THEH, Keys.FK7PERKXQJ3MDYTMGT8RILAMH5O);
    }

    private transient JAddress _address;
    private transient JStaff _staff;

    /**
     * Get the implicit join path to the <code>PUBLIC.Address</code> table.
     */
    public JAddress address() {
        if (_address == null)
            _address = new JAddress(this, Keys.FK1U30WQ6FJM3TRHXIH98K8THEH);

        return _address;
    }

    /**
     * Get the implicit join path to the <code>PUBLIC.Staff</code> table.
     */
    public JStaff staff() {
        if (_staff == null)
            _staff = new JStaff(this, Keys.FK7PERKXQJ3MDYTMGT8RILAMH5O);

        return _staff;
    }

    @Override
    public JStore as(String alias) {
        return new JStore(DSL.name(alias), this);
    }

    @Override
    public JStore as(Name alias) {
        return new JStore(alias, this);
    }

    @Override
    public JStore as(Table<?> alias) {
        return new JStore(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public JStore rename(String name) {
        return new JStore(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public JStore rename(Name name) {
        return new JStore(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public JStore rename(Table<?> name) {
        return new JStore(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<Integer, LocalDateTime, Integer, Integer> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function4<? super Integer, ? super LocalDateTime, ? super Integer, ? super Integer, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function4<? super Integer, ? super LocalDateTime, ? super Integer, ? super Integer, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}