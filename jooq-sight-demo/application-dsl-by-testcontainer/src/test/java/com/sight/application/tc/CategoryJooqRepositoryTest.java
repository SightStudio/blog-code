package com.sight.application.tc;

import com.sight.application.tc.config.IntegrationTest;
import com.sight.application.tc.dtos.CategorySummaryDto;
import com.sight.application.tc.dtos.FilmSummaryDto;
import com.sight.application.tc.repository.CategoryJooqRepository;
import com.sight.application.tc.repository.FilmJooqRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryJooqRepositoryTest extends IntegrationTest {

  @Autowired
  CategoryJooqRepository jooqRepository;

  @Test
  @DisplayName("영화 요약정보 확인")
  @Disabled
  void test1() {
    // given
    String title = "ACADEMY DINOSAUR";

    CategorySummaryDto filmSummary = jooqRepository.findCategorySummaryByTitle(title);

    Assertions.assertEquals(filmSummary.getTitle(), title);
  }
}
