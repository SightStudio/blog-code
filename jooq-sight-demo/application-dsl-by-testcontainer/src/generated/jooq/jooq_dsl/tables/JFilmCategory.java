/*
 * This file is generated by jOOQ.
 */
package jooq.jooq_dsl.tables;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import jooq.jooq_dsl.JSakila;
import jooq.jooq_dsl.Keys;
import jooq.jooq_dsl.tables.records.JFilmCategoryRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function3;
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
public class JFilmCategory extends TableImpl<JFilmCategoryRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>sakila.film_category</code>
     */
    public static final JFilmCategory FILM_CATEGORY = new JFilmCategory();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<JFilmCategoryRecord> getRecordType() {
        return JFilmCategoryRecord.class;
    }

    /**
     * The column <code>sakila.film_category.film_id</code>.
     */
    public final TableField<JFilmCategoryRecord, Integer> FILM_ID = createField(DSL.name("film_id"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>sakila.film_category.category_id</code>.
     */
    public final TableField<JFilmCategoryRecord, Integer> CATEGORY_ID = createField(DSL.name("category_id"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>sakila.film_category.last_update</code>.
     */
    public final TableField<JFilmCategoryRecord, LocalDateTime> LAST_UPDATE = createField(DSL.name("last_update"), SQLDataType.LOCALDATETIME(0).nullable(false).defaultValue(DSL.field(DSL.raw("CURRENT_TIMESTAMP"), SQLDataType.LOCALDATETIME)), this, "");

    private JFilmCategory(Name alias, Table<JFilmCategoryRecord> aliased) {
        this(alias, aliased, null);
    }

    private JFilmCategory(Name alias, Table<JFilmCategoryRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>sakila.film_category</code> table reference
     */
    public JFilmCategory(String alias) {
        this(DSL.name(alias), FILM_CATEGORY);
    }

    /**
     * Create an aliased <code>sakila.film_category</code> table reference
     */
    public JFilmCategory(Name alias) {
        this(alias, FILM_CATEGORY);
    }

    /**
     * Create a <code>sakila.film_category</code> table reference
     */
    public JFilmCategory() {
        this(DSL.name("film_category"), null);
    }

    public <O extends Record> JFilmCategory(Table<O> child, ForeignKey<O, JFilmCategoryRecord> key) {
        super(child, key, FILM_CATEGORY);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : JSakila.SAKILA;
    }

    @Override
    public UniqueKey<JFilmCategoryRecord> getPrimaryKey() {
        return Keys.KEY_FILM_CATEGORY_PRIMARY;
    }

    @Override
    public List<ForeignKey<JFilmCategoryRecord, ?>> getReferences() {
        return Arrays.asList(Keys.FK_FILM_CATEGORY_FILM, Keys.FK_FILM_CATEGORY_CATEGORY);
    }

    private transient JFilm _film;
    private transient JCategory _category;

    /**
     * Get the implicit join path to the <code>sakila.film</code> table.
     */
    public JFilm film() {
        if (_film == null)
            _film = new JFilm(this, Keys.FK_FILM_CATEGORY_FILM);

        return _film;
    }

    /**
     * Get the implicit join path to the <code>sakila.category</code> table.
     */
    public JCategory category() {
        if (_category == null)
            _category = new JCategory(this, Keys.FK_FILM_CATEGORY_CATEGORY);

        return _category;
    }

    @Override
    public JFilmCategory as(String alias) {
        return new JFilmCategory(DSL.name(alias), this);
    }

    @Override
    public JFilmCategory as(Name alias) {
        return new JFilmCategory(alias, this);
    }

    @Override
    public JFilmCategory as(Table<?> alias) {
        return new JFilmCategory(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public JFilmCategory rename(String name) {
        return new JFilmCategory(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public JFilmCategory rename(Name name) {
        return new JFilmCategory(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public JFilmCategory rename(Table<?> name) {
        return new JFilmCategory(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<Integer, Integer, LocalDateTime> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function3<? super Integer, ? super Integer, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function3<? super Integer, ? super Integer, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
