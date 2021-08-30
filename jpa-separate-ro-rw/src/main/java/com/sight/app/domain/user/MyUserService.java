package com.sight.app.domain.user;

import com.sight.app.web.dto.user.MyUserCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MyUserService {

    private final MyUserRepository myUserRepository;

    // 아래 트랜잭션은 RW 노드에서 실행됨
    @Transactional
    public Long createUser(MyUserCreateRequest request) {
        MyUser newUser = new MyUser(request);
        myUserRepository.save(newUser);
        return newUser.getUserSeq();
    }

    // 아래 트랜잭션은 RO 노드에서 실행됨
    @Transactional(readOnly = true)
    public MyUser getUser(Long userSeq) {
        return myUserRepository.findById(userSeq)
                .orElse(null);
    }

    // 아래 트랜잭션은 RW 노드에서 실행됨
    @Transactional
    public Long createAndGetUserCount(MyUserCreateRequest request) {
        MyUser newUser = new MyUser(request);
        myUserRepository.save(newUser);

        return myUserRepository.count();
    }
}
