package com.sightstudio.jooq.app.domain.author;

import com.sightstudio.jooq.app.web.request.AuthorSearchRequest;
import com.sightstudio.jooq.config.jooq.BaseJooqRepository;
import jooq.jooq_dsl.tables.JAuthor;
import jooq.jooq_dsl.tables.JBook;
import jooq.jooq_dsl.tables.records.JAuthorRecord;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.InsertValuesStep4;
import org.jooq.InsertValuesStepN;
import org.jooq.TableField;
import org.jooq.impl.DSL;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Repository
@RequiredArgsConstructor
public class AuthorRepository implements BaseJooqRepository {

    private final DSLContext dsl;
    private final ModelMapper mapper;

    public Integer registerAuthor(Author authorRegister) {
        final JAuthor AUTHOR = JAuthor.AUTHOR;

        return dsl.insertInto(AUTHOR,
                        AUTHOR.FIRST_NAME,
                        AUTHOR.LAST_NAME,
                        AUTHOR.YEAR_OF_BIRTH,
                        AUTHOR.DATE_OF_BIRTH
                )
                .values(
                        authorRegister.getFirstName(),
                        authorRegister.getLastName(),
                        authorRegister.getYearOfBirth(),
                        authorRegister.getDateOfBirth()
                ).returningResult(AUTHOR.ID)
                .fetchOneInto(Integer.class);
    }

    public Integer bulkRegisterAuthorJava8(List<Author> authorRegister) {
        final JAuthor AUTHOR = JAuthor.AUTHOR;

        InsertValuesStep4<JAuthorRecord, String, String, Integer, LocalDate> insertStep = dsl.insertInto(
                AUTHOR,
                AUTHOR.FIRST_NAME,
                AUTHOR.LAST_NAME,
                AUTHOR.YEAR_OF_BIRTH,
                AUTHOR.DATE_OF_BIRTH
        );

        for (Author author : authorRegister) {
            insertStep.values(
                    author.getFirstName(),
                    author.getLastName(),
                    author.getYearOfBirth(),
                    author.getDateOfBirth()
            );
        }
        return insertStep.execute();
    }

    public Integer bulkRegisterAuthor(List<Author> authorRegister) {
        final JAuthor AUTHOR = JAuthor.AUTHOR;

        var insertRows = authorRegister.stream()
                .map(register -> DSL.row(
                        register.getFirstName(),
                        register.getLastName(),
                        register.getYearOfBirth(),
                        register.getDateOfBirth()
                ))
                .collect(Collectors.toList());

        return dsl.insertInto(AUTHOR,
                        AUTHOR.FIRST_NAME,
                        AUTHOR.LAST_NAME,
                        AUTHOR.YEAR_OF_BIRTH,
                        AUTHOR.DATE_OF_BIRTH
                )
                .valuesOfRows(insertRows)
                .execute();
    }

    public List<Author> getAuthorList(AuthorSearchRequest searchRequest) {
        final JAuthor AUTHOR = JAuthor.AUTHOR;
        final int offsetCnt = searchRequest.getPage() * searchRequest.getPage();

//        dsl.select(DSL.field("SLEEP(6)"))
//           .from("DUAL")
//           .execute();

        return dsl.select(
                    AUTHOR.ID,
                    AUTHOR.FIRST_NAME,
                    AUTHOR.LAST_NAME,
                    AUTHOR.DATE_OF_BIRTH,
                    AUTHOR.YEAR_OF_BIRTH
                )
                .from(AUTHOR)
                .where(
                    likeIfNotEmpty(AUTHOR.FIRST_NAME, searchRequest.getFirstName()),
                    likeIfNotEmpty(AUTHOR.LAST_NAME, searchRequest.getFirstName())
                )
                .offset(offsetCnt)
                .limit(searchRequest.getSize())
                .fetchInto(Author.class);
    }

    public List<Author> getAuthorListIdIn(List<Integer> authorIdList) {
        final JAuthor AUTHOR = JAuthor.AUTHOR;

        return dsl.select(
                        AUTHOR.ID,
                        AUTHOR.FIRST_NAME,
                        AUTHOR.LAST_NAME,
                        AUTHOR.DATE_OF_BIRTH,
                        AUTHOR.YEAR_OF_BIRTH
                )
                .from(AUTHOR)
                .where(
                    inIfNotEmpty(AUTHOR.ID, authorIdList)
                )
                .fetchInto(Author.class);
    }

    public List<AuthorBookDto> getAuthorsBookList(Integer id) {
        final JAuthor AUTHOR = JAuthor.AUTHOR;
        final JBook BOOK = JBook.BOOK;

        return dsl.select(
                        AUTHOR.ID             .as("author_id")           ,
                        AUTHOR.FIRST_NAME     .as("author_firstname")    ,
                        AUTHOR.LAST_NAME      .as("author_lastname")     ,
                        AUTHOR.DATE_OF_BIRTH  .as("author_dateofbirth")  ,
                        AUTHOR.YEAR_OF_BIRTH  .as("author_yearofbirth")  ,
                        AUTHOR.DISTINGUISHED  .as("author_distinguished"),
                        BOOK.ID               .as("book_id")         ,
                        BOOK.AUTHOR_ID        .as("book_authorid")   ,
                        BOOK.TITLE            .as("book_title")      ,
                        BOOK.PUBLISHED_IN     .as("book_publishedin"),
                        BOOK.LANGUAGE_ID      .as("book_languageid")
                )
                .from(AUTHOR)
                .join(BOOK)
                    .on(BOOK.AUTHOR_ID.eq(AUTHOR.ID))
                .where(AUTHOR.ID.eq(id))
                .stream()
                .map(row -> mapper.map(row, AuthorBookDto.class))
                .collect(Collectors.toList());
    }
}