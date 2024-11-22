package com.sight.archunitstart.domain.film.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class FilmActorId implements Serializable {

    private static final long serialVersionUID = -6368019749920334076L;

    @Column(name = "actor_id", columnDefinition = "int UNSIGNED not null")
    private Long actorId;

    @Column(name = "film_id", columnDefinition = "int UNSIGNED not null")
    private Long filmId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FilmActorId entity = (FilmActorId) o;
        return Objects.equals(this.actorId, entity.actorId) && Objects.equals(this.filmId, entity.filmId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorId, filmId);
    }

}
