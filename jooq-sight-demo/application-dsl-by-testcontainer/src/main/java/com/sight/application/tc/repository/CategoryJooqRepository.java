package com.sight.application.tc.repository;

import static com.sight.application.tc.config.jooq.meta.conditions.JooqBaseCondition.eq;
import static org.jooq.impl.DSL.concat;
import static org.jooq.impl.DSL.groupConcat;
import static org.jooq.impl.DSL.select;
import static org.jooq.impl.DSL.val;

import com.sight.application.tc.dtos.CategorySummaryDto;
import com.sight.application.tc.dtos.FilmSummaryDto;
import jooq.jooq_dsl.tables.JActor;
import jooq.jooq_dsl.tables.JCategory;
import jooq.jooq_dsl.tables.JFilm;
import jooq.jooq_dsl.tables.JFilmActor;
import jooq.jooq_dsl.tables.JFilmCategory;
import jooq.jooq_dsl.tables.daos.FilmDao;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.Table;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CategoryJooqRepository extends FilmDao {

  private final DSLContext dsl;

  public CategorySummaryDto findCategorySummaryByTitle (String filmTitle) {
    final JFilm film = JFilm.FILM;
    final JFilmCategory filmCategory = JFilmCategory.FILM_CATEGORY;
    final JCategory category = JCategory.CATEGORY;

    var nested = dsl.select(
        film.FILM_ID,
        film.TITLE,
        filmCategory.CATEGORY_ID
    ).from(film)
     .join(filmCategory)
        .on(eq(film.FILM_ID, filmCategory.FILM_ID))
     .where(film.TITLE.equalIgnoreCase(filmTitle))
     .asTable("f1");

    return dsl.select(
        category.CATEGORY_ID,
        category.NAME,
        nested.field(film.TITLE),
        nested.field(film.FILM_ID)
    ).from(nested)
        .join(category)
        .on(eq(category.CATEGORY_ID, nested.field(filmCategory.CATEGORY_ID)))
    .where()
    .fetchOneInto(CategorySummaryDto.class);
  }
}
