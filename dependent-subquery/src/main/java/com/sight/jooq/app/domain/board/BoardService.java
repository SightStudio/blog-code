package com.sight.jooq.app.domain.board;

import com.github.javafaker.Faker;
import com.github.javafaker.Lorem;
import com.sight.jooq.app.domain.board.type.BoardType;
import com.sight.jooq.web.BoardRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public int createRandomBoard(List<BoardType> boardTypes, int size) {

        int typeSize = boardTypes.size();
        Random random = new Random();
        Faker faker = new Faker();

        List<BoardRegisterRequest> randomBoardList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            Lorem lorem = faker.lorem();
            BoardType boardType = boardTypes.get(random.nextInt(typeSize));

            randomBoardList.add(new BoardRegisterRequest(
                    lorem.characters(10),
                    lorem.characters(100),
                    boardType.getSeq()
            ));
        }

        return boardRepository.bulkRegisterBoard(randomBoardList);
    }
}
