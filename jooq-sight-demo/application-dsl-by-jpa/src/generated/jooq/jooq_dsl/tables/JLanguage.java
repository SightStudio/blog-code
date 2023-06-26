/*
 * This file is generated by jOOQ.
 */
package jooq.jooq_dsl.tables;


import java.time.LocalDateTime;
import java.util.function.Function;

import jooq.jooq_dsl.DefaultSchema;
import jooq.jooq_dsl.Keys;
import jooq.jooq_dsl.tables.records.JLanguageRecord;

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
public class JLanguage extends TableImpl<JLanguageRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>Language</code>
     */
    public static final JLanguage LANGUAGE = new JLanguage();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<JLanguageRecord> getRecordType() {
        return JLanguageRecord.class;
    }

    /**
     * The column <code>Language.languageId</code>.
     */
    public final TableField<JLanguageRecord, Integer> LANGUAGEID = createField(DSL.name("languageId"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>Language.lastUpdate</code>.
     */
    public final TableField<JLanguageRecord, LocalDateTime> LASTUPDATE = createField(DSL.name("lastUpdate"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "");

    /**
     * The column <code>Language.name</code>.
     */
    public final TableField<JLanguageRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(20).nullable(false), this, "");

    private JLanguage(Name alias, Table<JLanguageRecord> aliased) {
        this(alias, aliased, null);
    }

    private JLanguage(Name alias, Table<JLanguageRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>Language</code> table reference
     */
    public JLanguage(String alias) {
        this(DSL.name(alias), LANGUAGE);
    }

    /**
     * Create an aliased <code>Language</code> table reference
     */
    public JLanguage(Name alias) {
        this(alias, LANGUAGE);
    }

    /**
     * Create a <code>Language</code> table reference
     */
    public JLanguage() {
        this(DSL.name("Language"), null);
    }

    public <O extends Record> JLanguage(Table<O> child, ForeignKey<O, JLanguageRecord> key) {
        super(child, key, LANGUAGE);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public Identity<JLanguageRecord, Integer> getIdentity() {
        return (Identity<JLanguageRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<JLanguageRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_A;
    }

    @Override
    public JLanguage as(String alias) {
        return new JLanguage(DSL.name(alias), this);
    }

    @Override
    public JLanguage as(Name alias) {
        return new JLanguage(alias, this);
    }

    @Override
    public JLanguage as(Table<?> alias) {
        return new JLanguage(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public JLanguage rename(String name) {
        return new JLanguage(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public JLanguage rename(Name name) {
        return new JLanguage(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public JLanguage rename(Table<?> name) {
        return new JLanguage(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<Integer, LocalDateTime, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function3<? super Integer, ? super LocalDateTime, ? super String, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function3<? super Integer, ? super LocalDateTime, ? super String, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
