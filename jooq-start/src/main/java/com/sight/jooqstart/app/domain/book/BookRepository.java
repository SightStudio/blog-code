package com.sight.jooqstart.app.domain.book;

import com.sight.jooqstart.app.domain.author.AuthorDto;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static first.tables.Author.AUTHOR;
import static first.tables.Book.BOOK;

@Repository
@RequiredArgsConstructor
public class BookRepository {

    private final DSLContext dsl;
    private final ModelMapper mapper;

}