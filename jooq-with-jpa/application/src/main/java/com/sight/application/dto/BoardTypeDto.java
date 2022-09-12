package com.sight.application.dto;

import com.sight.entity.BoardType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class BoardTypeDto {

    private Long boardTypeSeq;

    private String code;

    private String codeName;

    public BoardTypeDto(BoardType boardType) {
        this.boardTypeSeq = boardType.getBoardTypeSeq();
        this.code = boardType.getCode();
        this.codeName = boardType.getCodeName();
    }
}
