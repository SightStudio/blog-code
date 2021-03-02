package com.sight.jooqstart.domain.book;

import com.sight.jooqstart.app.domain.author.AuthorDto;
import com.sight.jooqstart.app.domain.book.BookRepository;
import com.sight.jooqstart.config.JooqRepoTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;

import java.util.List;


@Import(BookRepository.class)
public class BookRepoTest extends JooqRepoTest {

    @Autowired
    private BookRepository bookRepository;
}
