package com.sightstudio.jooq.app.domain.author;

import com.sightstudio.jooq.app.web.request.AuthorSearchRequest;
import com.sightstudio.jooq.config.jooq.BaseJooqRepository;
import jooq.jooq_dsl.tables.JAuthor;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;


@Repository
@RequiredArgsConstructor
public class AuthorRepository implements BaseJooqRepository {

    private final DSLContext dsl;

    public Integer registerAuthor(Author authorRegister) {
        final JAuthor author = JAuthor.AUTHOR;
        return dsl.insertInto(author,
                        author.FIRST_NAME,
                        author.LAST_NAME,
                        author.YEAR_OF_BIRTH,
                        author.DATE_OF_BIRTH
                )
                .values(
                        authorRegister.getFirstName(),
                        authorRegister.getLastName(),
                        authorRegister.getYearOfBirth(),
                        authorRegister.getDateOfBirth()
                ).returningResult(author.ID)
                .fetchOneInto(Integer.class);
    }

    public Integer bulkRegisterAuthor(List<Author> authorRegister) {
        final JAuthor author = JAuthor.AUTHOR;

        var insertRows = authorRegister.stream()
                .map(register -> DSL.row(
                        register.getFirstName(),
                        register.getLastName(),
                        register.getYearOfBirth(),
                        register.getDateOfBirth()
                ))
                .collect(Collectors.toList());

        return dsl.insertInto(author,
                        author.FIRST_NAME,
                        author.LAST_NAME,
                        author.YEAR_OF_BIRTH,
                        author.DATE_OF_BIRTH
                )
                .valuesOfRows(insertRows)
                .execute();
    }

    public List<Author> getAuthorList(AuthorSearchRequest searchRequest) {
        final JAuthor author = JAuthor.AUTHOR;
        final int offsetCnt = searchRequest.getPage() * searchRequest.getPage();

        return dsl.select(
                    author.ID,
                    author.FIRST_NAME,
                    author.LAST_NAME,
                    author.DATE_OF_BIRTH,
                    author.YEAR_OF_BIRTH
                )
                .from(author)
                .where(
                    likeIfNotEmpty(author.FIRST_NAME, searchRequest.getFirstName()),
                    likeIfNotEmpty(author.LAST_NAME, searchRequest.getFirstName())
                )
                .offset(offsetCnt)
                .limit(searchRequest.getSize())
                .fetchInto(Author.class);
    }
}