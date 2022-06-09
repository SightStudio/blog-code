package com.sight.application.domain.board;

import com.sight.application.app.dco.OrderBy;
import com.sight.application.app.domain.board.BoardDetailDto;
import com.sight.application.app.domain.board.BoardRepository;
import com.sight.application.app.domain.board.BoardSqlEdit;
import com.sight.application.app.domain.board.BoardSqlSearch;
import com.sight.application.config.JooqRepoTest;
import com.sight.entity.Board;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;

@Import(BoardRepository.class)
public class BoardRepositoryTest extends JooqRepoTest {

  @Autowired
  private BoardRepository boardRepository;

  @Test
  public void 게시글_목록_단순_조회() {
    final int PAGE_SIZE = 20;

    BoardSqlSearch search = new BoardSqlSearch();
    search.setPage(2);
    search.setPageSize(PAGE_SIZE);
    search.setStartDt(LocalDate.of(2020, 1, 1));
    search.setFinishDt(null);
//    search.setFinishDt(LocalDate.of(2022, 12, 12));
    search.setOrderBy(OrderBy.DESC);

    List<Board> boardWithPaging = boardRepository.getBoardList(search);

    Assertions.assertEquals(boardWithPaging.size(), PAGE_SIZE);
  }

  @Test
  public void 게시글_상세조회_DEPENDENT_SUBQUERY() {
    final int PAGE_SIZE = 20;

    BoardSqlSearch search = new BoardSqlSearch();
    search.setPage(2);
    search.setPageSize(PAGE_SIZE);
    search.setStartDt(LocalDate.of(2020, 1, 1));
    search.setFinishDt(null);
//    search.setFinishDt(LocalDate.of(2022, 12, 12));
    search.setOrderBy(OrderBy.DESC);

    List<BoardDetailDto> boardWithPaging = boardRepository.getBoardDetailedList_DependentSubquery(search);

    Assertions.assertEquals(boardWithPaging.size(), PAGE_SIZE);
  }

  @Test
  public void 게시글_상세조회_LEFT_JOIN() {
    final int PAGE_SIZE = 20;

    BoardSqlSearch search = new BoardSqlSearch();
    search.setPage(2);
    search.setPageSize(PAGE_SIZE);
    search.setStartDt(LocalDate.of(2020, 1, 1));
    search.setFinishDt(null);
//    search.setFinishDt(LocalDate.of(2022, 12, 12));
    search.setOrderBy(OrderBy.DESC);

    List<BoardDetailDto> boardWithPaging = boardRepository.getBoardDetailedList_LeftJoin(search);

    Assertions.assertEquals(boardWithPaging.size(), PAGE_SIZE);
  }

  @Test
  public void 게시글_수정_UPDATE() {
    BoardSqlEdit sqlEdit = new BoardSqlEdit();
    sqlEdit.setContent("수정 내용");
    sqlEdit.setTitle("수정 제목");
    int updatedRowCnt = boardRepository.editBoard(20L, sqlEdit);

    Assertions.assertEquals(updatedRowCnt, 1);
  }
}
