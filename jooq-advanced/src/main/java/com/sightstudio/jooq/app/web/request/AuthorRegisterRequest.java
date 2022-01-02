package com.sightstudio.jooq.app.web.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class AuthorRegisterRequest {
    private String firstName;
    private String lastName;

    private LocalDate dateOfBirth;
    private Integer yearOfBirth;
}
