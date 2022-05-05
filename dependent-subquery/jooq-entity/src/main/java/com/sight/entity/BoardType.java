package com.sight.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "board_type")
@NoArgsConstructor
public class BoardType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_type_seq", nullable = false)
    private Long boardTypeSeq;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "code_name", nullable = false)
    private String codeName;
}
