package com.test.sight.domain;

import com.test.sight.config.IntegrationTest;
import com.test.sight.domain.user.User;
import com.test.sight.domain.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

public class UserRegisterTest extends IntegrationTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void test() {
        User user = new User();

        user.setBirth(LocalDate.now());
        user.setName("sight");

        userRepository.save(user);

        System.out.println(user);
    }
}
