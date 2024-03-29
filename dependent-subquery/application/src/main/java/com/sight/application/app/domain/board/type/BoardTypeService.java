package com.sight.application.app.domain.board.type;

import com.github.javafaker.Faker;
import com.github.javafaker.Lorem;
import com.sight.entity.BoardType;
import com.sight.application.web.BoardTypeRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardTypeService {

    private final BoardTypeRepository boardTypeRepository;

    public List<BoardType> createAndGetAllRandomBoardType(int size) {

        Map<String, BoardType> boardTypeMap = boardTypeRepository.findAll().stream()
                .collect(Collectors.toMap(BoardType::getCode, Function.identity()));

        Faker faker = new Faker();
        Set<String> distinctCodeSet = new HashSet<>(size);

        Lorem lorem = faker.lorem();
        for (int i = 0; i < size; i++) {
            String code = lorem.characters(15);
            if(boardTypeMap.get(code) == null) {
                distinctCodeSet.add(code);
            }
        }

        List<BoardTypeRegisterRequest> requests = distinctCodeSet.stream()
                .map(code -> new BoardTypeRegisterRequest(code, faker.animal().name()))
                .toList();

        boardTypeRepository.bulkRegisterBoardType(requests);

        return boardTypeRepository.findAll();
    }
}
