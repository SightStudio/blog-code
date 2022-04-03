package com.sight.jooq.domain;

import com.sight.jooq.app.domain.board.Board;
import com.sight.jooq.app.domain.board.BoardService;
import com.sight.jooq.app.domain.board.type.BoardType;
import com.sight.jooq.app.domain.board.type.BoardTypeService;
import com.sight.jooq.config.IntegrationTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DataGeneration extends IntegrationTest {

    @Autowired
    private BoardTypeService boardTypeService;

    @Autowired
    private BoardService boardService;

    private static final int RANDOM_BOARD_TYPE_SIZE = 3000;

    // oom 회피를 위해 나눠서 집어넣음
    private static final int RANDOM_BOARD_INSERTION_CHUNK_SIZE = 100000;
    private static final int RANDOM_BOARD_INSERTION_CHUNK_LOOP_SIZE = 30;

    private static final int TOTAL_REGISTERED_BOARD_SIZE = RANDOM_BOARD_INSERTION_CHUNK_SIZE * RANDOM_BOARD_INSERTION_CHUNK_LOOP_SIZE;

    @Test
    @DisplayName("[더미데이터 생성] 게시판 타입 게시판 랜덤생성")
    void 게시판_타입_게시판_랜덤생성() {

        List<BoardType> randomBoardType = boardTypeService.createAndGetAllRandomBoardType(RANDOM_BOARD_TYPE_SIZE);

        int insertedTotalBoardSize = 0;
        for (int i = 0; i < RANDOM_BOARD_INSERTION_CHUNK_LOOP_SIZE ; i++) {
            insertedTotalBoardSize += boardService.createRandomBoard(randomBoardType, RANDOM_BOARD_INSERTION_CHUNK_SIZE);
        }

        Assertions.assertEquals(insertedTotalBoardSize, TOTAL_REGISTERED_BOARD_SIZE);
    }
}