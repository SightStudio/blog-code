package com.sightstudio.jooq.app.web.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor
public class AuthorBulkRegisterRequest {
    private List<AuthorRegisterRequest> authorList;
}
