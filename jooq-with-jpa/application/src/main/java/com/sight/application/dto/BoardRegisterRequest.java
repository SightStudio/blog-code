package com.sight.application.dto;

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
    private Long userSeq;
}
