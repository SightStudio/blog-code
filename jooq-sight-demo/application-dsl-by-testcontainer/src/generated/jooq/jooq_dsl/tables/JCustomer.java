/*
 * This file is generated by jOOQ.
 */
package jooq.jooq_dsl.tables;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import jooq.jooq_dsl.Indexes;
import jooq.jooq_dsl.JSakila;
import jooq.jooq_dsl.Keys;
import jooq.jooq_dsl.tables.records.JCustomerRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function9;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row9;
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
public class JCustomer extends TableImpl<JCustomerRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>sakila.customer</code>
     */
    public static final JCustomer CUSTOMER = new JCustomer();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<JCustomerRecord> getRecordType() {
        return JCustomerRecord.class;
    }

    /**
     * The column <code>sakila.customer.customer_id</code>.
     */
    public final TableField<JCustomerRecord, Integer> CUSTOMER_ID = createField(DSL.name("customer_id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>sakila.customer.store_id</code>.
     */
    public final TableField<JCustomerRecord, Integer> STORE_ID = createField(DSL.name("store_id"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>sakila.customer.first_name</code>.
     */
    public final TableField<JCustomerRecord, String> FIRST_NAME = createField(DSL.name("first_name"), SQLDataType.VARCHAR(45).nullable(false), this, "");

    /**
     * The column <code>sakila.customer.last_name</code>.
     */
    public final TableField<JCustomerRecord, String> LAST_NAME = createField(DSL.name("last_name"), SQLDataType.VARCHAR(45).nullable(false), this, "");

    /**
     * The column <code>sakila.customer.email</code>.
     */
    public final TableField<JCustomerRecord, String> EMAIL = createField(DSL.name("email"), SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>sakila.customer.address_id</code>.
     */
    public final TableField<JCustomerRecord, Integer> ADDRESS_ID = createField(DSL.name("address_id"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>sakila.customer.active</code>.
     */
    public final TableField<JCustomerRecord, Byte> ACTIVE = createField(DSL.name("active"), SQLDataType.TINYINT.nullable(false).defaultValue(DSL.inline("1", SQLDataType.TINYINT)), this, "");

    /**
     * The column <code>sakila.customer.create_date</code>.
     */
    public final TableField<JCustomerRecord, LocalDateTime> CREATE_DATE = createField(DSL.name("create_date"), SQLDataType.LOCALDATETIME(0).nullable(false), this, "");

    /**
     * The column <code>sakila.customer.last_update</code>.
     */
    public final TableField<JCustomerRecord, LocalDateTime> LAST_UPDATE = createField(DSL.name("last_update"), SQLDataType.LOCALDATETIME(0).defaultValue(DSL.field(DSL.raw("CURRENT_TIMESTAMP"), SQLDataType.LOCALDATETIME)), this, "");

    private JCustomer(Name alias, Table<JCustomerRecord> aliased) {
        this(alias, aliased, null);
    }

    private JCustomer(Name alias, Table<JCustomerRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>sakila.customer</code> table reference
     */
    public JCustomer(String alias) {
        this(DSL.name(alias), CUSTOMER);
    }

    /**
     * Create an aliased <code>sakila.customer</code> table reference
     */
    public JCustomer(Name alias) {
        this(alias, CUSTOMER);
    }

    /**
     * Create a <code>sakila.customer</code> table reference
     */
    public JCustomer() {
        this(DSL.name("customer"), null);
    }

    public <O extends Record> JCustomer(Table<O> child, ForeignKey<O, JCustomerRecord> key) {
        super(child, key, CUSTOMER);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : JSakila.SAKILA;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.asList(Indexes.CUSTOMER_IDX_FK_ADDRESS_ID, Indexes.CUSTOMER_IDX_FK_STORE_ID, Indexes.CUSTOMER_IDX_LAST_NAME);
    }

    @Override
    public Identity<JCustomerRecord, Integer> getIdentity() {
        return (Identity<JCustomerRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<JCustomerRecord> getPrimaryKey() {
        return Keys.KEY_CUSTOMER_PRIMARY;
    }

    @Override
    public List<ForeignKey<JCustomerRecord, ?>> getReferences() {
        return Arrays.asList(Keys.FK_CUSTOMER_STORE, Keys.FK_CUSTOMER_ADDRESS);
    }

    private transient JStore _store;
    private transient JAddress _address;

    /**
     * Get the implicit join path to the <code>sakila.store</code> table.
     */
    public JStore store() {
        if (_store == null)
            _store = new JStore(this, Keys.FK_CUSTOMER_STORE);

        return _store;
    }

    /**
     * Get the implicit join path to the <code>sakila.address</code> table.
     */
    public JAddress address() {
        if (_address == null)
            _address = new JAddress(this, Keys.FK_CUSTOMER_ADDRESS);

        return _address;
    }

    @Override
    public JCustomer as(String alias) {
        return new JCustomer(DSL.name(alias), this);
    }

    @Override
    public JCustomer as(Name alias) {
        return new JCustomer(alias, this);
    }

    @Override
    public JCustomer as(Table<?> alias) {
        return new JCustomer(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public JCustomer rename(String name) {
        return new JCustomer(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public JCustomer rename(Name name) {
        return new JCustomer(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public JCustomer rename(Table<?> name) {
        return new JCustomer(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row9 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row9<Integer, Integer, String, String, String, Integer, Byte, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function9<? super Integer, ? super Integer, ? super String, ? super String, ? super String, ? super Integer, ? super Byte, ? super LocalDateTime, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function9<? super Integer, ? super Integer, ? super String, ? super String, ? super String, ? super Integer, ? super Byte, ? super LocalDateTime, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
