package com.sight.application.tc.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CategorySummaryDto {
  private Long filmId;
  private Long categoryId;
  private String title;
  private String name;
}
