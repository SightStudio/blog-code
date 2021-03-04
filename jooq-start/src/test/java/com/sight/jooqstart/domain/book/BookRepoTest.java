package com.sight.jooqstart.domain.book;

import com.sight.jooqstart.app.domain.book.BookRepository;
import com.sight.jooqstart.config.JooqRepoTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;


@Import(BookRepository.class)
public class BookRepoTest extends JooqRepoTest {

    @Autowired
    private BookRepository bookRepository;
}
