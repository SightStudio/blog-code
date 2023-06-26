/*
 * This file is generated by jOOQ.
 */
package jooq.jooq_dsl.routines;


import java.math.BigDecimal;

import jooq.jooq_dsl.JSakila;

import org.jooq.Parameter;
import org.jooq.impl.AbstractRoutine;
import org.jooq.impl.Internal;
import org.jooq.impl.SQLDataType;


/**
 * Provides a customizable report on best customers
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JRewardsReport extends AbstractRoutine<java.lang.Void> {

    private static final long serialVersionUID = 1L;

    /**
     * The parameter <code>sakila.rewards_report.min_monthly_purchases</code>.
     */
    public static final Parameter<Byte> MIN_MONTHLY_PURCHASES = Internal.createParameter("min_monthly_purchases", SQLDataType.TINYINT, false, false);

    /**
     * The parameter
     * <code>sakila.rewards_report.min_dollar_amount_purchased</code>.
     */
    public static final Parameter<BigDecimal> MIN_DOLLAR_AMOUNT_PURCHASED = Internal.createParameter("min_dollar_amount_purchased", SQLDataType.DECIMAL(10, 2), false, false);

    /**
     * The parameter <code>sakila.rewards_report.count_rewardees</code>.
     */
    public static final Parameter<Integer> COUNT_REWARDEES = Internal.createParameter("count_rewardees", SQLDataType.INTEGER, false, false);

    /**
     * Create a new routine call instance
     */
    public JRewardsReport() {
        super("rewards_report", JSakila.SAKILA);

        addInParameter(MIN_MONTHLY_PURCHASES);
        addInParameter(MIN_DOLLAR_AMOUNT_PURCHASED);
        addOutParameter(COUNT_REWARDEES);
    }

    /**
     * Set the <code>min_monthly_purchases</code> parameter IN value to the
     * routine
     */
    public void setMinMonthlyPurchases(Byte value) {
        setValue(MIN_MONTHLY_PURCHASES, value);
    }

    /**
     * Set the <code>min_dollar_amount_purchased</code> parameter IN value to
     * the routine
     */
    public void setMinDollarAmountPurchased(BigDecimal value) {
        setValue(MIN_DOLLAR_AMOUNT_PURCHASED, value);
    }

    /**
     * Get the <code>count_rewardees</code> parameter OUT value from the routine
     */
    public Integer getCountRewardees() {
        return get(COUNT_REWARDEES);
    }
}
