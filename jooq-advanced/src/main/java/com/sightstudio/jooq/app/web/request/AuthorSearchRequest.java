package com.sightstudio.jooq.app.web.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AuthorSearchRequest {
    private int page = 0;
    private int size = 20;
    private String firstName = "";
    private String lastName  = "";
}
