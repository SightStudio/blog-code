package com.sightstudio.jooq.app.domain.author;

import com.sightstudio.jooq.app.domain.book.BookDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorBookDto {
    private BookDto book;
    private Author author;
}
