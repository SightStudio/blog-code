package com.sight.jooq.app.domain.board.type;

import com.github.javafaker.Animal;
import com.github.javafaker.Faker;
import com.sight.jooq.web.BoardTypeRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardTypeService {

    private final BoardTypeRepository boardTypeRepository;

    @Transactional
    public List<BoardType> createAndGetAllRandomBoardType(int size) {

        Map<String, BoardType> boardTypeMap = boardTypeRepository.findAll().stream()
                .collect(Collectors.toMap(BoardType::getBoarTypeCode, Function.identity()));

        Faker faker = new Faker();
        Set<String> distinctCodeSet = new HashSet<>(size);

        Animal animal = faker.animal();
        for (int i = 0; i < size; i++) {
            String name = animal.name();
            if(boardTypeMap.get(name) == null) {
                distinctCodeSet.add(name);
            }
        }

        List<BoardTypeRegisterRequest> requests = distinctCodeSet.stream()
                .map(BoardTypeRegisterRequest::new)
                .toList();

        boardTypeRepository.bulkRegisterBoardType(requests);

        return boardTypeRepository.findAll();
    }
}
