package com.test.sight.domain.board;

import com.test.sight.domain.RecordableEntity;
import com.test.sight.domain.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Board extends RecordableEntity {

    @Id @GeneratedValue
    @Column(name = "board_seq")
    private Long seq;

    private String title;

    private LocalDate content;

    @ManyToOne(fetch = FetchType.LAZY)
    private User writer;
}