package com.sight.application.domain.board;

import com.sight.application.app.domain.board.BoardRepository;
import com.sight.application.config.JooqRepoTest;
import com.sight.entity.Board;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;

@Import(BoardRepository.class)
public class BoardRepositoryTest extends JooqRepoTest {

  @Autowired
  private BoardRepository boardRepository;

  @Test
  public void 게시글_목록_단순_조회() {
    List<Board> boardWithPaging = boardRepository.getBoardWithPaging(1, 20);
    System.out.println(boardWithPaging);
  }
}
