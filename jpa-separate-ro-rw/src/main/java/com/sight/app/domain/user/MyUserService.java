package com.sight.app.domain.user;

import com.sight.app.web.dto.user.MyUserCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MyUserService {

    private final MyUserRepository myUserRepository;

    @Transactional
    public Long createUser(MyUserCreateRequest request) {
        MyUser newUser = new MyUser(request);
        myUserRepository.save(newUser);
        return newUser.getUserSeq();
    }

    @Transactional(readOnly = true)
    public MyUser getUser(Long userSeq) {
        return myUserRepository.findById(userSeq)
                .orElse(null);
    }
}
