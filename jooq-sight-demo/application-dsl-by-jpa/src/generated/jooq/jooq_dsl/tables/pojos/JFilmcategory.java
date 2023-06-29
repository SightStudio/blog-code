/*
 * This file is generated by jOOQ.
 */
package jooq.jooq_dsl.tables.pojos;


import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JFilmcategory implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Long id;
    private final LocalDateTime lastupdate;
    private final Integer categoryId;
    private final Integer filmId;

    public JFilmcategory(JFilmcategory value) {
        this.id = value.id;
        this.lastupdate = value.lastupdate;
        this.categoryId = value.categoryId;
        this.filmId = value.filmId;
    }

    public JFilmcategory(
        Long id,
        LocalDateTime lastupdate,
        Integer categoryId,
        Integer filmId
    ) {
        this.id = id;
        this.lastupdate = lastupdate;
        this.categoryId = categoryId;
        this.filmId = filmId;
    }

    /**
     * Getter for <code>FilmCategory.id</code>.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Getter for <code>FilmCategory.lastUpdate</code>.
     */
    public LocalDateTime getLastupdate() {
        return this.lastupdate;
    }

    /**
     * Getter for <code>FilmCategory.category_id</code>.
     */
    public Integer getCategoryId() {
        return this.categoryId;
    }

    /**
     * Getter for <code>FilmCategory.film_id</code>.
     */
    public Integer getFilmId() {
        return this.filmId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final JFilmcategory other = (JFilmcategory) obj;
        if (this.id == null) {
            if (other.id != null)
                return false;
        }
        else if (!this.id.equals(other.id))
            return false;
        if (this.lastupdate == null) {
            if (other.lastupdate != null)
                return false;
        }
        else if (!this.lastupdate.equals(other.lastupdate))
            return false;
        if (this.categoryId == null) {
            if (other.categoryId != null)
                return false;
        }
        else if (!this.categoryId.equals(other.categoryId))
            return false;
        if (this.filmId == null) {
            if (other.filmId != null)
                return false;
        }
        else if (!this.filmId.equals(other.filmId))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.lastupdate == null) ? 0 : this.lastupdate.hashCode());
        result = prime * result + ((this.categoryId == null) ? 0 : this.categoryId.hashCode());
        result = prime * result + ((this.filmId == null) ? 0 : this.filmId.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("JFilmcategory (");

        sb.append(id);
        sb.append(", ").append(lastupdate);
        sb.append(", ").append(categoryId);
        sb.append(", ").append(filmId);

        sb.append(")");
        return sb.toString();
    }
}