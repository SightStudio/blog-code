package com.sight.application.app.domain.board;

import com.sight.application.app.dco.OrderBy;
import com.sight.application.app.dto.OffsetPageSqlSearch;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardSqlSearch extends OffsetPageSqlSearch {
  private OrderBy orderBy = OrderBy.DESC;
  private LocalDate startDt = LocalDate.now();
  private LocalDate finishDt = LocalDate.now();
  private String titleKeyword = "";
  private String contentKeyword = "";
}
