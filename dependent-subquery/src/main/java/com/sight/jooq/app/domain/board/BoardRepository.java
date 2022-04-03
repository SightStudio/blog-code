package com.sight.jooq.app.domain.board;

import com.sight.jooq.config.jooq.BaseJooqRepository;
import com.sight.jooq.web.BoardRegisterRequest;
import jooq.jooq_dsl.tables.JBoard;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
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
                        LocalDateTime.now()
                ))
                .collect(Collectors.toList());

        return dsl.insertInto(board,
                board.TITLE,
                board.CONTENT,
                board.BOARD_TYPE_SEQ,
                board.REG_DATE
        ).valuesOfRows(insertRows)
        .execute();
    }
}
