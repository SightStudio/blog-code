package com.sight.application.tc;

import com.sight.application.tc.config.IntegrationTest;
import com.sight.application.tc.dtos.FilmSummaryDto;
import com.sight.application.tc.repository.FilmJooqRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class FilmRepositoryTest extends IntegrationTest {

  @Autowired
  FilmJooqRepository jooqRepository;

  @Test
  @DisplayName("영화 요약정보 확인")
  @Disabled
  void test1() {
    // given
    String title = "ACADEMY DINOSAUR";

    FilmSummaryDto filmSummary = jooqRepository.findFilmSummaryByTitle(title);

    Assertions.assertEquals(filmSummary.getTitle(), title);
  }

}
