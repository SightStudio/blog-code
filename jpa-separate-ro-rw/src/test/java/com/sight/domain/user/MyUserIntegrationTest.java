package com.sight.domain.user;

import com.sight.app.domain.user.MyUser;
import com.sight.app.domain.user.MyUserService;
import com.sight.app.web.dto.user.MyUserCreateRequest;
import com.sight.testType.IntegrationTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.sight.app.domain.user.QMyUser.myUser;

public class MyUserIntegrationTest extends IntegrationTest {

    @Autowired
    MyUserService myUserService;

    @Test
    @DisplayName("[RW 노드] 신규 유저 생성")
    public void 신규_유저_생성() {
        MyUserCreateRequest 신규_유저_정보 = new MyUserCreateRequest("Sight", "sdm3285@gmail.com");
        Long userSeq = myUserService.createUser(신규_유저_정보);

        Assertions.assertTrue(userSeq > 0);
    }

    @Test
    @DisplayName("[RO 노드] 유저 조회")
    public void 유저_조회() {
        MyUser myUser = myUserService.getUser(6L);
        Assertions.assertEquals(6L, myUser.getUserSeq());
    }

    @Test
    @DisplayName("[RW 노드] 신규 유저를 생성하고, 전체 유저 수를 조회한다.")
    public void 신규_유저_생성_후_전체_유저_수_조회() {
        MyUserCreateRequest 신규_유저_정보 = new MyUserCreateRequest("Sight", "sdm3285@gmail.com");

        Long 전체_유저_수 = myUserService.createAndGetUserCount(신규_유저_정보);

        Assertions.assertTrue(전체_유저_수 > 0);
    }
}