package com.sight.application.app.domain.board;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDetailDto {
  private Long boardSeq;
  private Long boardTypeSeq;
  private Long userSeq;
  private String typeNm;
  private String userNm;
  private String title;
  private String content;
  private LocalDateTime regDate;
}
