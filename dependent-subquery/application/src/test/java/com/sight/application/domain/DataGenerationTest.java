package com.sight.application.domain;

import com.sight.application.app.domain.board.BoardService;
import com.sight.application.app.domain.board.type.BoardTypeService;
import com.sight.application.app.domain.board.user.UserService;
import com.sight.application.config.IntegrationTest;
import com.sight.entity.BoardType;
import com.sight.entity.AppUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DataGenerationTest extends IntegrationTest {

    @Autowired
    private UserService userService;

    @Autowired
    private BoardTypeService boardTypeService;

    @Autowired
    private BoardService boardService;

    private static final int RANDOM_USER_SIZE = 0;
    private static final int RANDOM_BOARD_TYPE_SIZE = 0;

    // oom 회피를 위해 나눠서 insert
    private static final int RANDOM_BOARD_INSERTION_CHUNK_SIZE = 50000;
    private static final int RANDOM_BOARD_INSERTION_CHUNK_LOOP_SIZE = 20;

    private static final int TOTAL_REGISTERED_BOARD_SIZE = RANDOM_BOARD_INSERTION_CHUNK_SIZE * RANDOM_BOARD_INSERTION_CHUNK_LOOP_SIZE;

    @Test
    @DisplayName("[더미데이터 생성] 유저, 게시판 타입, 게시판 랜덤생성")
    void 게시판_랜덤생성() {

        List<BoardType> randomBoardType = boardTypeService.createAndGetAllRandomBoardType(RANDOM_BOARD_TYPE_SIZE);
        List<AppUser> randomUser = userService.createAndGetAllRandomUser(RANDOM_USER_SIZE);

        int insertedTotalBoardSize = 0;
        for (int i = 0; i < RANDOM_BOARD_INSERTION_CHUNK_LOOP_SIZE ; i++) {
            insertedTotalBoardSize += boardService.createRandomBoard(randomUser, randomBoardType, RANDOM_BOARD_INSERTION_CHUNK_SIZE);
        }

        Assertions.assertEquals(insertedTotalBoardSize, TOTAL_REGISTERED_BOARD_SIZE);
    }
}