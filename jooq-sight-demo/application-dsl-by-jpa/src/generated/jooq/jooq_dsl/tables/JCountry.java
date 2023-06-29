/*
 * This file is generated by jOOQ.
 */
package jooq.jooq_dsl.tables;


import java.time.LocalDateTime;
import java.util.function.Function;

import jooq.jooq_dsl.DefaultSchema;
import jooq.jooq_dsl.Keys;
import jooq.jooq_dsl.tables.records.JCountryRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function3;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row3;
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
public class JCountry extends TableImpl<JCountryRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>Country</code>
     */
    public static final JCountry COUNTRY = new JCountry();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<JCountryRecord> getRecordType() {
        return JCountryRecord.class;
    }

    /**
     * The column <code>Country.countryId</code>.
     */
    public final TableField<JCountryRecord, Integer> COUNTRYID = createField(DSL.name("countryId"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>Country.country</code>.
     */
    public final TableField<JCountryRecord, String> COUNTRY_ = createField(DSL.name("country"), SQLDataType.VARCHAR(50).nullable(false), this, "");

    /**
     * The column <code>Country.lastUpdate</code>.
     */
    public final TableField<JCountryRecord, LocalDateTime> LASTUPDATE = createField(DSL.name("lastUpdate"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "");

    private JCountry(Name alias, Table<JCountryRecord> aliased) {
        this(alias, aliased, null);
    }

    private JCountry(Name alias, Table<JCountryRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>Country</code> table reference
     */
    public JCountry(String alias) {
        this(DSL.name(alias), COUNTRY);
    }

    /**
     * Create an aliased <code>Country</code> table reference
     */
    public JCountry(Name alias) {
        this(alias, COUNTRY);
    }

    /**
     * Create a <code>Country</code> table reference
     */
    public JCountry() {
        this(DSL.name("Country"), null);
    }

    public <O extends Record> JCountry(Table<O> child, ForeignKey<O, JCountryRecord> key) {
        super(child, key, COUNTRY);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public Identity<JCountryRecord, Integer> getIdentity() {
        return (Identity<JCountryRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<JCountryRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_9;
    }

    @Override
    public JCountry as(String alias) {
        return new JCountry(DSL.name(alias), this);
    }

    @Override
    public JCountry as(Name alias) {
        return new JCountry(alias, this);
    }

    @Override
    public JCountry as(Table<?> alias) {
        return new JCountry(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public JCountry rename(String name) {
        return new JCountry(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public JCountry rename(Name name) {
        return new JCountry(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public JCountry rename(Table<?> name) {
        return new JCountry(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<Integer, String, LocalDateTime> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function3<? super Integer, ? super String, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function3<? super Integer, ? super String, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}