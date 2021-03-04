package com.sight.jooqstart.app.domain.author;

import com.sight.jooqstart.app.domain.book.BookDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorBookDto {
    private BookDto book;
    private AuthorDto author;
}
