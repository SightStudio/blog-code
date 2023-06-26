/*
 * This file is generated by jOOQ.
 */
package jooq.jooq_dsl.tables;


import java.math.BigDecimal;
import java.util.function.Function;

import jooq.jooq_dsl.JSakila;
import jooq.jooq_dsl.tables.records.JSalesByFilmCategoryRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function2;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row2;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * VIEW
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JSalesByFilmCategory extends TableImpl<JSalesByFilmCategoryRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>sakila.sales_by_film_category</code>
     */
    public static final JSalesByFilmCategory SALES_BY_FILM_CATEGORY = new JSalesByFilmCategory();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<JSalesByFilmCategoryRecord> getRecordType() {
        return JSalesByFilmCategoryRecord.class;
    }

    /**
     * The column <code>sakila.sales_by_film_category.category</code>.
     */
    public final TableField<JSalesByFilmCategoryRecord, String> CATEGORY = createField(DSL.name("category"), SQLDataType.VARCHAR(25).nullable(false), this, "");

    /**
     * The column <code>sakila.sales_by_film_category.total_sales</code>.
     */
    public final TableField<JSalesByFilmCategoryRecord, BigDecimal> TOTAL_SALES = createField(DSL.name("total_sales"), SQLDataType.DECIMAL(27, 2), this, "");

    private JSalesByFilmCategory(Name alias, Table<JSalesByFilmCategoryRecord> aliased) {
        this(alias, aliased, null);
    }

    private JSalesByFilmCategory(Name alias, Table<JSalesByFilmCategoryRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("VIEW"), TableOptions.view("create view `sales_by_film_category` as select `c`.`name` AS `category`,sum(`p`.`amount`) AS `total_sales` from (((((`sakila`.`payment` `p` join `sakila`.`rental` `r` on((`p`.`rental_id` = `r`.`rental_id`))) join `sakila`.`inventory` `i` on((`r`.`inventory_id` = `i`.`inventory_id`))) join `sakila`.`film` `f` on((`i`.`film_id` = `f`.`film_id`))) join `sakila`.`film_category` `fc` on((`f`.`film_id` = `fc`.`film_id`))) join `sakila`.`category` `c` on((`fc`.`category_id` = `c`.`category_id`))) group by `c`.`name` order by `total_sales` desc"));
    }

    /**
     * Create an aliased <code>sakila.sales_by_film_category</code> table
     * reference
     */
    public JSalesByFilmCategory(String alias) {
        this(DSL.name(alias), SALES_BY_FILM_CATEGORY);
    }

    /**
     * Create an aliased <code>sakila.sales_by_film_category</code> table
     * reference
     */
    public JSalesByFilmCategory(Name alias) {
        this(alias, SALES_BY_FILM_CATEGORY);
    }

    /**
     * Create a <code>sakila.sales_by_film_category</code> table reference
     */
    public JSalesByFilmCategory() {
        this(DSL.name("sales_by_film_category"), null);
    }

    public <O extends Record> JSalesByFilmCategory(Table<O> child, ForeignKey<O, JSalesByFilmCategoryRecord> key) {
        super(child, key, SALES_BY_FILM_CATEGORY);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : JSakila.SAKILA;
    }

    @Override
    public JSalesByFilmCategory as(String alias) {
        return new JSalesByFilmCategory(DSL.name(alias), this);
    }

    @Override
    public JSalesByFilmCategory as(Name alias) {
        return new JSalesByFilmCategory(alias, this);
    }

    @Override
    public JSalesByFilmCategory as(Table<?> alias) {
        return new JSalesByFilmCategory(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public JSalesByFilmCategory rename(String name) {
        return new JSalesByFilmCategory(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public JSalesByFilmCategory rename(Name name) {
        return new JSalesByFilmCategory(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public JSalesByFilmCategory rename(Table<?> name) {
        return new JSalesByFilmCategory(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<String, BigDecimal> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function2<? super String, ? super BigDecimal, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function2<? super String, ? super BigDecimal, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
