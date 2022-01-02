package com.sightstudio.jooq.app.domain.author;

import com.sightstudio.jooq.app.web.request.AuthorRegisterRequest;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "year_of_birth", nullable = false)
    private Integer yearOfBirth;

    @Column(name = "distinguished")
    private Boolean distinguished;

    public Author() { }

    public Author(String firstName, String lastName, LocalDate dateOfBirth, Integer yearOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.yearOfBirth = yearOfBirth;
    }

    public Author(AuthorRegisterRequest registerRequest) {
        this.firstName = registerRequest.getFirstName();
        this.lastName = registerRequest.getLastName();
        this.dateOfBirth = registerRequest.getDateOfBirth();
        this.yearOfBirth = registerRequest.getYearOfBirth();
    }
}
