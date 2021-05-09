package com.test.sight.domain.user;

import com.test.sight.domain.RecordableEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class User extends RecordableEntity {

    @Id @GeneratedValue
    @Column(name = "user_seq")
    private Long seq;

    private String name;

    private LocalDate birth;
}