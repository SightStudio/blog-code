package com.sight.app.domain.user;

import com.sight.app.domain.BaseRecordableEntity;
import com.sight.app.web.dto.user.MyUserCreateRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MyUser extends BaseRecordableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_seq")
    private Long userSeq;

    private String name;
    private String email;

    public MyUser(MyUserCreateRequest request) {
        this.name = request.getName();
        this.email = request.getState();
    }
}
