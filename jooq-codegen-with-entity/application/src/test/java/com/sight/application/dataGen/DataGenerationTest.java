package com.sight.application.dataGen;

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

/**
 * Create Random BoardType, User, Board
 */
public class DataGenerationTest extends IntegrationTest {

    @Autowired
    private UserService userService;

    @Autowired
    private BoardTypeService boardTypeService;

    @Autowired
    private BoardService boardService;

    // 랜덤으로 생성할 유저 사이즈
    private static final int RANDOM_USER_SIZE = 0;

    // 랜덤으로 생성할 게시판 종류 사이즈
    private static final int RANDOM_BOARD_TYPE_SIZE = 0;

    // split data insertion to aviod oom
    private static final int RANDOM_BOARD_INSERTION_CHUNK_SIZE = 40000;
    private static final int RANDOM_BOARD_INSERTION_CHUNK_LOOP_SIZE = 100;

    private static final int TOTAL_REGISTERED_BOARD_SIZE = RANDOM_BOARD_INSERTION_CHUNK_SIZE * RANDOM_BOARD_INSERTION_CHUNK_LOOP_SIZE;

    @Test
    @DisplayName("[Dummy Data Generation] User, Board Type, Board generate")
    void Dummy_Data_Generation() {

        List<BoardType> randomBoardType = boardTypeService.createAndGetAllRandomBoardType(RANDOM_BOARD_TYPE_SIZE);
        List<AppUser> randomUser = userService.createAndGetAllRandomUser(RANDOM_USER_SIZE);

        int insertedTotalBoardSize = 0;
        for (int i = 0; i < RANDOM_BOARD_INSERTION_CHUNK_LOOP_SIZE ; i++) {
            insertedTotalBoardSize += boardService.createRandomBoard(randomUser, randomBoardType, RANDOM_BOARD_INSERTION_CHUNK_SIZE);
        }

        Assertions.assertEquals(insertedTotalBoardSize, TOTAL_REGISTERED_BOARD_SIZE);
    }
}