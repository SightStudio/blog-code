package com.sight.jooq.web;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BoardTypeRegisterRequest {
    private String code;
    private String codeName;

    public BoardTypeRegisterRequest(String code) {
        this.code = code;
        this.codeName = code;
    }
}
