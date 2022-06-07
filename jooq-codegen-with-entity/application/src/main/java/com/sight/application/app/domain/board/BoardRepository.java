package com.sight.application.app.domain.board;

import com.sight.application.app.util.RandomUtil;
import com.sight.application.config.jooq.BaseJooqRepository;
import com.sight.application.web.BoardRegisterRequest;
import com.sight.entity.Board;
import jooq.jooq_dsl.tables.JBoard;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class BoardRepository implements BaseJooqRepository {

    private final DSLContext dsl;

    public int bulkRegisterBoard(List<BoardRegisterRequest> boardList) {
        final JBoard board = JBoard.BOARD;
        var insertRows = boardList.stream()
                .map(request -> DSL.row(
                        request.getTitle(),
                        request.getContent(),
                        request.getBoardTypeSeq(),
                        request.getUserSeq(),
                        RandomUtil.getRandomDateTime(
                            LocalDate.of(2015, 11, 12),
                            LocalDate.of(2022, 4, 4)
                        )
                ))
                .collect(Collectors.toList());

        return dsl.insertInto(board,
                board.TITLE,
                board.CONTENT,
                board.BOARD_TYPE_SEQ,
                board.USER_SEQ,
                board.REG_DATE
        ).valuesOfRows(insertRows)
        .execute();
    }

    public List<Board> getBoardWithPaging(int page, int pageSize) {
      final JBoard board = JBoard.BOARD;
      return dsl.select(board.asterisk())
          .from(board)
          .limit(pageSize)
          .offset(page * pageSize)
          .fetchInto(Board.class);
    }
}
