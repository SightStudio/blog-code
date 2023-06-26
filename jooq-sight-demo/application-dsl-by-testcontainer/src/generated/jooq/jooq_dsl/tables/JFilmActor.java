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
import jooq.jooq_dsl.tables.records.JFilmActorRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function3;
import org.jooq.Index;
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
public class JFilmActor extends TableImpl<JFilmActorRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>sakila.film_actor</code>
     */
    public static final JFilmActor FILM_ACTOR = new JFilmActor();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<JFilmActorRecord> getRecordType() {
        return JFilmActorRecord.class;
    }

    /**
     * The column <code>sakila.film_actor.actor_id</code>.
     */
    public final TableField<JFilmActorRecord, Integer> ACTOR_ID = createField(DSL.name("actor_id"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>sakila.film_actor.film_id</code>.
     */
    public final TableField<JFilmActorRecord, Integer> FILM_ID = createField(DSL.name("film_id"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>sakila.film_actor.last_update</code>.
     */
    public final TableField<JFilmActorRecord, LocalDateTime> LAST_UPDATE = createField(DSL.name("last_update"), SQLDataType.LOCALDATETIME(0).nullable(false).defaultValue(DSL.field(DSL.raw("CURRENT_TIMESTAMP"), SQLDataType.LOCALDATETIME)), this, "");

    private JFilmActor(Name alias, Table<JFilmActorRecord> aliased) {
        this(alias, aliased, null);
    }

    private JFilmActor(Name alias, Table<JFilmActorRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>sakila.film_actor</code> table reference
     */
    public JFilmActor(String alias) {
        this(DSL.name(alias), FILM_ACTOR);
    }

    /**
     * Create an aliased <code>sakila.film_actor</code> table reference
     */
    public JFilmActor(Name alias) {
        this(alias, FILM_ACTOR);
    }

    /**
     * Create a <code>sakila.film_actor</code> table reference
     */
    public JFilmActor() {
        this(DSL.name("film_actor"), null);
    }

    public <O extends Record> JFilmActor(Table<O> child, ForeignKey<O, JFilmActorRecord> key) {
        super(child, key, FILM_ACTOR);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : JSakila.SAKILA;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.asList(Indexes.FILM_ACTOR_IDX_FK_FILM_ID);
    }

    @Override
    public UniqueKey<JFilmActorRecord> getPrimaryKey() {
        return Keys.KEY_FILM_ACTOR_PRIMARY;
    }

    @Override
    public List<ForeignKey<JFilmActorRecord, ?>> getReferences() {
        return Arrays.asList(Keys.FK_FILM_ACTOR_ACTOR, Keys.FK_FILM_ACTOR_FILM);
    }

    private transient JActor _actor;
    private transient JFilm _film;

    /**
     * Get the implicit join path to the <code>sakila.actor</code> table.
     */
    public JActor actor() {
        if (_actor == null)
            _actor = new JActor(this, Keys.FK_FILM_ACTOR_ACTOR);

        return _actor;
    }

    /**
     * Get the implicit join path to the <code>sakila.film</code> table.
     */
    public JFilm film() {
        if (_film == null)
            _film = new JFilm(this, Keys.FK_FILM_ACTOR_FILM);

        return _film;
    }

    @Override
    public JFilmActor as(String alias) {
        return new JFilmActor(DSL.name(alias), this);
    }

    @Override
    public JFilmActor as(Name alias) {
        return new JFilmActor(alias, this);
    }

    @Override
    public JFilmActor as(Table<?> alias) {
        return new JFilmActor(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public JFilmActor rename(String name) {
        return new JFilmActor(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public JFilmActor rename(Name name) {
        return new JFilmActor(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public JFilmActor rename(Table<?> name) {
        return new JFilmActor(name.getQualifiedName(), null);
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
