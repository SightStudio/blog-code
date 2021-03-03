package com.sight.jooqstart.app.domain.author;

import com.sight.jooqstart.app.domain.book.BookDto;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static first.tables.Author.AUTHOR;
import static first.tables.Book.BOOK;

@Repository
@RequiredArgsConstructor
public class AuthorRepository {

    private final DSLContext dsl;
    private final ModelMapper mapper;

    public AuthorDto save(AuthorDto dto) {
        return dsl.insertInto(AUTHOR,
                AUTHOR.FIRST_NAME, AUTHOR.LAST_NAME, AUTHOR.YEAR_OF_BIRTH, AUTHOR.DATE_OF_BIRTH, AUTHOR.DISTINGUISHED)
                .values(createInsertRecord(dto))
                .returning()
                .fetchOne()
                .into(AuthorDto.class);
    }

    public List<AuthorBookDto> getAuthorsBookList(Integer id) {
        return dsl.select(
                AUTHOR.ID.as("author_id")                      ,
                AUTHOR.FIRST_NAME.as("author_firstname")       ,
                AUTHOR.LAST_NAME.as("author_lastname")         ,
                AUTHOR.DATE_OF_BIRTH.as("author_dateofbirth")  ,
                AUTHOR.YEAR_OF_BIRTH.as("author_yearofbirth")  ,
                AUTHOR.DISTINGUISHED.as("author_distinguished"),
                BOOK.ID.as("book_id")                   ,
                BOOK.AUTHOR_ID.as("book_authorid")      ,
                BOOK.TITLE.as("book_title")             ,
                BOOK.PUBLISHED_IN.as("book_publishedin"),
                BOOK.LANGUAGE_ID.as("book_languageid")
        )
        .from(AUTHOR)
            .join(BOOK)
                .on(BOOK.AUTHOR_ID.eq(AUTHOR.ID))
        .where(AUTHOR.ID.eq(id))
        .stream()
        .map(row -> mapper.map(row, AuthorBookDto.class))
        .collect(Collectors.toList());
    }

    public AuthorDto getAuthorById(Integer id) {
        return dsl.select()
                .from(AUTHOR)
                .where(AUTHOR.ID.eq(id))
                .fetchOneInto(AuthorDto.class);
    }

    private List<Serializable> createInsertRecord(AuthorDto dto) {
        return Arrays.asList(
                dto.getFirstName(),
                dto.getLastName(),
                dto.getYearOfBirth(),
                dto.getDateOfBirth(),
                dto.getDistinguished() ? 1 : 0
        );
    }
}