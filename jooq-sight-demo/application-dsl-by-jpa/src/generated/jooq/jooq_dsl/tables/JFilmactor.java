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
import jooq.jooq_dsl.tables.records.JFilmactorRecord;

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
public class JFilmactor extends TableImpl<JFilmactorRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>FilmActor</code>
     */
    public static final JFilmactor FILMACTOR = new JFilmactor();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<JFilmactorRecord> getRecordType() {
        return JFilmactorRecord.class;
    }

    /**
     * The column <code>FilmActor.id</code>.
     */
    public final TableField<JFilmactorRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>FilmActor.lastUpdate</code>.
     */
    public final TableField<JFilmactorRecord, LocalDateTime> LASTUPDATE = createField(DSL.name("lastUpdate"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "");

    /**
     * The column <code>FilmActor.actor_id</code>.
     */
    public final TableField<JFilmactorRecord, Integer> ACTOR_ID = createField(DSL.name("actor_id"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>FilmActor.film_id</code>.
     */
    public final TableField<JFilmactorRecord, Integer> FILM_ID = createField(DSL.name("film_id"), SQLDataType.INTEGER.nullable(false), this, "");

    private JFilmactor(Name alias, Table<JFilmactorRecord> aliased) {
        this(alias, aliased, null);
    }

    private JFilmactor(Name alias, Table<JFilmactorRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>FilmActor</code> table reference
     */
    public JFilmactor(String alias) {
        this(DSL.name(alias), FILMACTOR);
    }

    /**
     * Create an aliased <code>FilmActor</code> table reference
     */
    public JFilmactor(Name alias) {
        this(alias, FILMACTOR);
    }

    /**
     * Create a <code>FilmActor</code> table reference
     */
    public JFilmactor() {
        this(DSL.name("FilmActor"), null);
    }

    public <O extends Record> JFilmactor(Table<O> child, ForeignKey<O, JFilmactorRecord> key) {
        super(child, key, FILMACTOR);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public Identity<JFilmactorRecord, Long> getIdentity() {
        return (Identity<JFilmactorRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<JFilmactorRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_34;
    }

    @Override
    public List<ForeignKey<JFilmactorRecord, ?>> getReferences() {
        return Arrays.asList(Keys.FKGC9OQ44FBIUDOR7IIJU3Y6ADM, Keys.FK5IFUSA27CR9P4UBNDWWAEE0KB);
    }

    private transient JActor _actor;
    private transient JFilm _film;

    /**
     * Get the implicit join path to the <code>PUBLIC.Actor</code> table.
     */
    public JActor actor() {
        if (_actor == null)
            _actor = new JActor(this, Keys.FKGC9OQ44FBIUDOR7IIJU3Y6ADM);

        return _actor;
    }

    /**
     * Get the implicit join path to the <code>PUBLIC.Film</code> table.
     */
    public JFilm film() {
        if (_film == null)
            _film = new JFilm(this, Keys.FK5IFUSA27CR9P4UBNDWWAEE0KB);

        return _film;
    }

    @Override
    public JFilmactor as(String alias) {
        return new JFilmactor(DSL.name(alias), this);
    }

    @Override
    public JFilmactor as(Name alias) {
        return new JFilmactor(alias, this);
    }

    @Override
    public JFilmactor as(Table<?> alias) {
        return new JFilmactor(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public JFilmactor rename(String name) {
        return new JFilmactor(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public JFilmactor rename(Name name) {
        return new JFilmactor(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public JFilmactor rename(Table<?> name) {
        return new JFilmactor(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<Long, LocalDateTime, Integer, Integer> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function4<? super Long, ? super LocalDateTime, ? super Integer, ? super Integer, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function4<? super Long, ? super LocalDateTime, ? super Integer, ? super Integer, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}