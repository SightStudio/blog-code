package com.sight.application.tc.repository;

import static com.sight.application.tc.config.jooq.meta.conditions.JooqBaseCondition.eq;
import static jooq.jooq_dsl.Indexes.ACTOR_IDX_ACTOR_LAST_NAME;
import static org.jooq.impl.DSL.concat;
import static org.jooq.impl.DSL.val;

import com.sight.application.tc.dtos.FilmSummaryDto;
import jooq.jooq_dsl.tables.JActor;
import jooq.jooq_dsl.tables.JFilm;
import jooq.jooq_dsl.tables.JFilmActor;
import jooq.jooq_dsl.tables.daos.FilmDao;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.util.mysql.MySQLDSL;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class FilmJooqRepository extends FilmDao {

  private final DSLContext dsl;

  public FilmSummaryDto findFilmSummaryByTitle (String filmTitle) {
    final JFilm film = JFilm.FILM;
    final JFilmActor filmActor = JFilmActor.FILM_ACTOR;
    final JActor actor = JActor.ACTOR;
    final String actorIDX = ACTOR_IDX_ACTOR_LAST_NAME.getName();

    return dsl.select(
        film.FILM_ID,
        film.TITLE,
        MySQLDSL.groupConcat(concat(actor.FIRST_NAME, val("-"), actor.LAST_NAME)).separator(",").as("actors")
    ).hint("/*+ INDEX_DESC (film idx_fk_original_language_id) */")
     .from(film)
     .join(filmActor)
        .on(eq(film.FILM_ID, filmActor.FILM_ID))
    .join(actor.useIndex(actorIDX))
        .on(eq(actor.ACTOR_ID, filmActor.ACTOR_ID))
    .where(
        film.TITLE.equalIgnoreCase(filmTitle)
    )
    .groupBy(film.FILM_ID)
    .fetchOneInto(FilmSummaryDto.class);
  }
}
