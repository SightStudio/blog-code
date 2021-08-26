package com.sight.domain.user;

import com.sight.app.domain.user.MyUser;
import com.sight.app.domain.user.MyUserService;
import com.sight.app.web.dto.user.MyUserCreateRequest;
import com.sight.testType.IntegrationTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MyUserIntegrationTest extends IntegrationTest {

    @Autowired
    MyUserService myUserService;

    @Test
    public void 신규_유저_생성_후_조회() {
        MyUserCreateRequest 신규_유저_정보 = new MyUserCreateRequest("Sight", "sdm3285@gmail.com");

        Long  userSeq = myUserService.createUser(신규_유저_정보);
        MyUser myUser = myUserService.getUser(userSeq);

        Assertions.assertEquals(userSeq, myUser.getUserSeq());
    }

    @Test
    public void 유저_조회() {
        MyUser myUser = myUserService.getUser(6L);

        Assertions.assertEquals(6L, myUser.getUserSeq());
    }
}