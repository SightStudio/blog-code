package com.sight.jooq.app.domain.board.type;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "board_type")
@NoArgsConstructor
public class BoardType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_type_seq", nullable = false)
    private Long seq;

    @Column(name = "code", nullable = false)
    private String boarTypeCode;

    @Column(name = "code_name", nullable = false)
    private String content;
}
