package com.sight.application.app.domain.board;

import com.github.javafaker.Faker;
import com.github.javafaker.Lorem;
import com.sight.entity.BoardType;
import com.sight.entity.AppUser;
import com.sight.application.dto.BoardRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardJooqRepository boardJooqRepository;
    private final BoardJpaRepository boardJpaRepository;

    @Transactional
    public int createRandomBoard(List<AppUser> users, List<BoardType> boardTypes, int size) {
        int typeSize = boardTypes.size();
        int userSize = users.size();
        Random random = new Random();
        Faker faker = new Faker();

        List<BoardRegisterRequest> randomBoardList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            Lorem lorem = faker.lorem();
            BoardType boardType = boardTypes.get(random.nextInt(typeSize));
            AppUser writer = users.get(random.nextInt(userSize));

            randomBoardList.add(new BoardRegisterRequest(
                    lorem.characters(10),
                    lorem.characters(100),
                    boardType.getBoardTypeSeq(),
                    writer.getUserSeq()
            ));
        }

        return boardJooqRepository.bulkRegisterBoard(randomBoardList);
    }
}
