/*
 * This file is generated by jOOQ.
 */
package jooq.jooq_dsl.tables.pojos;


import java.io.Serializable;
import java.math.BigDecimal;

import jooq.jooq_dsl.enums.NicerButSlowerFilmListRating;


/**
 * VIEW
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JNicerButSlowerFilmList implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Integer fid;
    private final String title;
    private final String description;
    private final String category;
    private final BigDecimal price;
    private final Short length;
    private final NicerButSlowerFilmListRating rating;
    private final String actors;

    public JNicerButSlowerFilmList(JNicerButSlowerFilmList value) {
        this.fid = value.fid;
        this.title = value.title;
        this.description = value.description;
        this.category = value.category;
        this.price = value.price;
        this.length = value.length;
        this.rating = value.rating;
        this.actors = value.actors;
    }

    public JNicerButSlowerFilmList(
        Integer fid,
        String title,
        String description,
        String category,
        BigDecimal price,
        Short length,
        NicerButSlowerFilmListRating rating,
        String actors
    ) {
        this.fid = fid;
        this.title = title;
        this.description = description;
        this.category = category;
        this.price = price;
        this.length = length;
        this.rating = rating;
        this.actors = actors;
    }

    /**
     * Getter for <code>sakila.nicer_but_slower_film_list.FID</code>.
     */
    public Integer getFid() {
        return this.fid;
    }

    /**
     * Getter for <code>sakila.nicer_but_slower_film_list.title</code>.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Getter for <code>sakila.nicer_but_slower_film_list.description</code>.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Getter for <code>sakila.nicer_but_slower_film_list.category</code>.
     */
    public String getCategory() {
        return this.category;
    }

    /**
     * Getter for <code>sakila.nicer_but_slower_film_list.price</code>.
     */
    public BigDecimal getPrice() {
        return this.price;
    }

    /**
     * Getter for <code>sakila.nicer_but_slower_film_list.length</code>.
     */
    public Short getLength() {
        return this.length;
    }

    /**
     * Getter for <code>sakila.nicer_but_slower_film_list.rating</code>.
     */
    public NicerButSlowerFilmListRating getRating() {
        return this.rating;
    }

    /**
     * Getter for <code>sakila.nicer_but_slower_film_list.actors</code>.
     */
    public String getActors() {
        return this.actors;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final JNicerButSlowerFilmList other = (JNicerButSlowerFilmList) obj;
        if (this.fid == null) {
            if (other.fid != null)
                return false;
        }
        else if (!this.fid.equals(other.fid))
            return false;
        if (this.title == null) {
            if (other.title != null)
                return false;
        }
        else if (!this.title.equals(other.title))
            return false;
        if (this.description == null) {
            if (other.description != null)
                return false;
        }
        else if (!this.description.equals(other.description))
            return false;
        if (this.category == null) {
            if (other.category != null)
                return false;
        }
        else if (!this.category.equals(other.category))
            return false;
        if (this.price == null) {
            if (other.price != null)
                return false;
        }
        else if (!this.price.equals(other.price))
            return false;
        if (this.length == null) {
            if (other.length != null)
                return false;
        }
        else if (!this.length.equals(other.length))
            return false;
        if (this.rating == null) {
            if (other.rating != null)
                return false;
        }
        else if (!this.rating.equals(other.rating))
            return false;
        if (this.actors == null) {
            if (other.actors != null)
                return false;
        }
        else if (!this.actors.equals(other.actors))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.fid == null) ? 0 : this.fid.hashCode());
        result = prime * result + ((this.title == null) ? 0 : this.title.hashCode());
        result = prime * result + ((this.description == null) ? 0 : this.description.hashCode());
        result = prime * result + ((this.category == null) ? 0 : this.category.hashCode());
        result = prime * result + ((this.price == null) ? 0 : this.price.hashCode());
        result = prime * result + ((this.length == null) ? 0 : this.length.hashCode());
        result = prime * result + ((this.rating == null) ? 0 : this.rating.hashCode());
        result = prime * result + ((this.actors == null) ? 0 : this.actors.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("JNicerButSlowerFilmList (");

        sb.append(fid);
        sb.append(", ").append(title);
        sb.append(", ").append(description);
        sb.append(", ").append(category);
        sb.append(", ").append(price);
        sb.append(", ").append(length);
        sb.append(", ").append(rating);
        sb.append(", ").append(actors);

        sb.append(")");
        return sb.toString();
    }
}
