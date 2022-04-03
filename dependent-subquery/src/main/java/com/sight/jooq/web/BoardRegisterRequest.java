package com.sight.jooq.web;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BoardRegisterRequest {
    private String title;
    private String content;
    private Long boardTypeSeq;
}
