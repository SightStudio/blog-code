package com.sight.application.tc.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class FilmSummaryDto {
  private Long filmId;
  private String title;
  private String actors;
}
