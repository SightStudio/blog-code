/*
 * This file is generated by jOOQ.
 */
package jooq.jooq_dsl.tables.pojos;


import java.io.Serializable;
import java.math.BigDecimal;


/**
 * VIEW
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JSalesByFilmCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String category;
    private final BigDecimal totalSales;

    public JSalesByFilmCategory(JSalesByFilmCategory value) {
        this.category = value.category;
        this.totalSales = value.totalSales;
    }

    public JSalesByFilmCategory(
        String category,
        BigDecimal totalSales
    ) {
        this.category = category;
        this.totalSales = totalSales;
    }

    /**
     * Getter for <code>sakila.sales_by_film_category.category</code>.
     */
    public String getCategory() {
        return this.category;
    }

    /**
     * Getter for <code>sakila.sales_by_film_category.total_sales</code>.
     */
    public BigDecimal getTotalSales() {
        return this.totalSales;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final JSalesByFilmCategory other = (JSalesByFilmCategory) obj;
        if (this.category == null) {
            if (other.category != null)
                return false;
        }
        else if (!this.category.equals(other.category))
            return false;
        if (this.totalSales == null) {
            if (other.totalSales != null)
                return false;
        }
        else if (!this.totalSales.equals(other.totalSales))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.category == null) ? 0 : this.category.hashCode());
        result = prime * result + ((this.totalSales == null) ? 0 : this.totalSales.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("JSalesByFilmCategory (");

        sb.append(category);
        sb.append(", ").append(totalSales);

        sb.append(")");
        return sb.toString();
    }
}
