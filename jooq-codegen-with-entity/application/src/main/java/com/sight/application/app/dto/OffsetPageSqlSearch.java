package com.sight.application.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class OffsetPageSqlSearch {

  // 페이지는 1 부터 시작
  int page = 1;
  int pageSize = 30;

  public int getOffsetSize() {
    return (page - 1) * pageSize;
  }

  public int getLimit() {
    return pageSize;
  }
}
