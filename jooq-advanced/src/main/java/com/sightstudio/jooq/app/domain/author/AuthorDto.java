package com.sightstudio.jooq.app.domain.author;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AuthorDto {

    private Integer id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Integer yearOfBirth;

    public AuthorDto() { }

    public AuthorDto(Author author) {
        this.firstName = author.getFirstName();
        this.lastName = author.getLastName();
        this.dateOfBirth = author.getDateOfBirth();
        this.yearOfBirth = author.getYearOfBirth();
    }
}
