package com.sight.domain.book;

import com.sight.app.domain.board.Board;
import com.sight.app.domain.board.BoardRepository;
import com.sight.testType.DataJpaRepoTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookIntegrationTest extends DataJpaRepoTest {

    @Autowired
    BoardRepository boardRepository;

    @Test
    public void test() {
        List<Board> all = boardRepository.findAll();
        System.out.println(all);
    }
}
