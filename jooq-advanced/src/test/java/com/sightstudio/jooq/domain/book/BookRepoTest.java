package com.sightstudio.jooq.domain.book;

import com.sightstudio.jooq.app.domain.book.BookRepository;
import com.sightstudio.jooq.config.JooqRepoTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;


@Import(BookRepository.class)
public class BookRepoTest extends JooqRepoTest {

    @Autowired
    private BookRepository bookRepository;
}
