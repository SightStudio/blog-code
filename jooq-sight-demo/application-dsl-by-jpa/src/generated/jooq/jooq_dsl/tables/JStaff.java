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
import jooq.jooq_dsl.tables.records.JStaffRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function11;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row11;
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
public class JStaff extends TableImpl<JStaffRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>Staff</code>
     */
    public static final JStaff STAFF = new JStaff();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<JStaffRecord> getRecordType() {
        return JStaffRecord.class;
    }

    /**
     * The column <code>Staff.staffId</code>.
     */
    public final TableField<JStaffRecord, Integer> STAFFID = createField(DSL.name("staffId"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>Staff.active</code>.
     */
    public final TableField<JStaffRecord, Boolean> ACTIVE = createField(DSL.name("active"), SQLDataType.BOOLEAN.nullable(false), this, "");

    /**
     * The column <code>Staff.email</code>.
     */
    public final TableField<JStaffRecord, String> EMAIL = createField(DSL.name("email"), SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>Staff.firstName</code>.
     */
    public final TableField<JStaffRecord, String> FIRSTNAME = createField(DSL.name("firstName"), SQLDataType.VARCHAR(45).nullable(false), this, "");

    /**
     * The column <code>Staff.lastName</code>.
     */
    public final TableField<JStaffRecord, String> LASTNAME = createField(DSL.name("lastName"), SQLDataType.VARCHAR(45).nullable(false), this, "");

    /**
     * The column <code>Staff.lastUpdate</code>.
     */
    public final TableField<JStaffRecord, LocalDateTime> LASTUPDATE = createField(DSL.name("lastUpdate"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "");

    /**
     * The column <code>Staff.password</code>.
     */
    public final TableField<JStaffRecord, String> PASSWORD = createField(DSL.name("password"), SQLDataType.VARCHAR(40), this, "");

    /**
     * The column <code>Staff.picture</code>.
     */
    public final TableField<JStaffRecord, String> PICTURE = createField(DSL.name("picture"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>Staff.username</code>.
     */
    public final TableField<JStaffRecord, String> USERNAME = createField(DSL.name("username"), SQLDataType.VARCHAR(16).nullable(false), this, "");

    /**
     * The column <code>Staff.address_id</code>.
     */
    public final TableField<JStaffRecord, Integer> ADDRESS_ID = createField(DSL.name("address_id"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>Staff.store_id</code>.
     */
    public final TableField<JStaffRecord, Integer> STORE_ID = createField(DSL.name("store_id"), SQLDataType.INTEGER.nullable(false), this, "");

    private JStaff(Name alias, Table<JStaffRecord> aliased) {
        this(alias, aliased, null);
    }

    private JStaff(Name alias, Table<JStaffRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>Staff</code> table reference
     */
    public JStaff(String alias) {
        this(DSL.name(alias), STAFF);
    }

    /**
     * Create an aliased <code>Staff</code> table reference
     */
    public JStaff(Name alias) {
        this(alias, STAFF);
    }

    /**
     * Create a <code>Staff</code> table reference
     */
    public JStaff() {
        this(DSL.name("Staff"), null);
    }

    public <O extends Record> JStaff(Table<O> child, ForeignKey<O, JStaffRecord> key) {
        super(child, key, STAFF);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public Identity<JStaffRecord, Integer> getIdentity() {
        return (Identity<JStaffRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<JStaffRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_4;
    }

    @Override
    public List<ForeignKey<JStaffRecord, ?>> getReferences() {
        return Arrays.asList(Keys.FK77S643WTYQVYF8FR94S7CDG4Y, Keys.FKLP23E96799F77M0QL42NXUJ5G);
    }

    private transient JAddress _address;
    private transient JStore _store;

    /**
     * Get the implicit join path to the <code>PUBLIC.Address</code> table.
     */
    public JAddress address() {
        if (_address == null)
            _address = new JAddress(this, Keys.FK77S643WTYQVYF8FR94S7CDG4Y);

        return _address;
    }

    /**
     * Get the implicit join path to the <code>PUBLIC.Store</code> table.
     */
    public JStore store() {
        if (_store == null)
            _store = new JStore(this, Keys.FKLP23E96799F77M0QL42NXUJ5G);

        return _store;
    }

    @Override
    public JStaff as(String alias) {
        return new JStaff(DSL.name(alias), this);
    }

    @Override
    public JStaff as(Name alias) {
        return new JStaff(alias, this);
    }

    @Override
    public JStaff as(Table<?> alias) {
        return new JStaff(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public JStaff rename(String name) {
        return new JStaff(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public JStaff rename(Name name) {
        return new JStaff(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public JStaff rename(Table<?> name) {
        return new JStaff(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row11 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row11<Integer, Boolean, String, String, String, LocalDateTime, String, String, String, Integer, Integer> fieldsRow() {
        return (Row11) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function11<? super Integer, ? super Boolean, ? super String, ? super String, ? super String, ? super LocalDateTime, ? super String, ? super String, ? super String, ? super Integer, ? super Integer, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function11<? super Integer, ? super Boolean, ? super String, ? super String, ? super String, ? super LocalDateTime, ? super String, ? super String, ? super String, ? super Integer, ? super Integer, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
