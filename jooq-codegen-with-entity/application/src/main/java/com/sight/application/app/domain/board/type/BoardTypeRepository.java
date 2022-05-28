package com.sight.application.app.domain.board.type;

import com.sight.application.config.jooq.BaseJooqRepository;
import com.sight.entity.BoardType;
import com.sight.application.web.BoardTypeRegisterRequest;
import jooq.jooq_dsl.tables.JBoardType;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class BoardTypeRepository implements BaseJooqRepository {

    private final DSLContext dsl;

    public int bulkRegisterBoardType(List<BoardTypeRegisterRequest> boardTypeList) {
        final JBoardType boardType = JBoardType.BOARD_TYPE;

        if(CollectionUtils.isEmpty(boardTypeList)) {
            return 0;
        }

        var insertRows = boardTypeList.stream()
                .map(request -> DSL.row(
                        request.getCode(),
                        request.getCodeName()
                ))
                .collect(Collectors.toList());

        return dsl.insertInto(
                    boardType,
                    boardType.CODE,
                    boardType.CODE_NAME
                ).valuesOfRows(insertRows)
                .execute();
    }

    public List<BoardType> findAll() {
        final JBoardType boardType = JBoardType.BOARD_TYPE;

        return dsl.select(
                    boardType.BOARD_TYPE_SEQ,
                    boardType.CODE,
                    boardType.CODE_NAME
                ).from(boardType)
                .fetchInto(BoardType.class);
    }
}
