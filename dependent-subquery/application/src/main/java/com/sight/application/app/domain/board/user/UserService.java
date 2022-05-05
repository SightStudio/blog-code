package com.sight.application.app.domain.board.user;

import com.github.javafaker.Faker;
import com.sight.entity.AppUser;
import com.sight.application.web.UserRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<AppUser> createAndGetAllRandomUser(int size) {

        Faker faker = new Faker();

        Map<String, AppUser> prevUserMap = userRepository.findAll().stream()
                .collect(Collectors.toMap(AppUser::getUserId, Function.identity()));

        List<UserRegisterRequest> newUserList = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            String userId  = faker.lorem().characters(5);
            String userName = faker.name().fullName();

            if(prevUserMap.get(userId) == null) {
                newUserList.add(new UserRegisterRequest(userId, userName));
            }
        }

        userRepository.bulkRegisterUser(newUserList);

        return userRepository.findAll();
    }
}
