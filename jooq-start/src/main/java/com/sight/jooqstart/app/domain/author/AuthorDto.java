package com.sight.jooqstart.app.domain.author;

import com.sight.jooqstart.app.domain.book.BookDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AuthorDto {

    private Integer   id;
    private String firstName;
    private String lastName;

    private LocalDate dateOfBirth;
    private Integer yearOfBirth;

    private Boolean distinguished;

    public AuthorDto() { }

    public AuthorDto(String firstName, String lastName, LocalDate dateOfBirth, Integer yearOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.distinguished = true;
    }
}
