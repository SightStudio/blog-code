package com.test.sight.domain.user.role;

import com.test.sight.domain.RecordableEntity;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.Nonnull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Role extends RecordableEntity {

    @Id
    @GeneratedValue
    @Column(name = "user_seq")
    private Long seq;

    @Nonnull
    private Integer level;
}
