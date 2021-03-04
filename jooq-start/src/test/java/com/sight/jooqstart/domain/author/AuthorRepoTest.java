package com.sight.jooqstart.domain.author;


import com.sight.jooqstart.app.domain.author.AuthorBookDto;
import com.sight.jooqstart.app.domain.author.AuthorDto;
import com.sight.jooqstart.app.domain.author.AuthorRepository;
import com.sight.jooqstart.config.JooqRepoTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;

import java.time.LocalDate;
import java.util.List;

@Import(AuthorRepository.class)
public class AuthorRepoTest extends JooqRepoTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    @DisplayName("[Author] 저자_입력_테스트")
    void 저자_입력_테스트() {

        // given
        AuthorDto author = new AuthorDto("Sight", "Studio", LocalDate.parse("1995-12-12"), 1995);

        // when
        AuthorDto result = authorRepository.save(author);

        // then
        Assertions.assertEquals(author.getFirstName()  , result.getFirstName());
        Assertions.assertEquals(author.getLastName()   , result.getLastName());
        Assertions.assertEquals(author.getYearOfBirth(), result.getYearOfBirth());
        Assertions.assertEquals(author.getDateOfBirth(), result.getDateOfBirth());
    }

    @Test
    @DisplayName("[Author] 저자_삭제_테스트")
    void 저자_삭제_테스트() {

        // given
        AuthorDto author = new AuthorDto("Sight", "Studio", LocalDate.parse("1995-12-12"), 1995);

        // when
        AuthorDto result = authorRepository.save(author);
        int deleteCnt = authorRepository.removeAuthor(result);

        // then
        Assertions.assertEquals(1 , deleteCnt);
    }

    @Test
    @DisplayName("[Author] 저자가 작성한 책 목록 조회 (저자 정보 포함)")
    void 저자_책_목록_조회() {
        List<AuthorBookDto> authorByIdWithBook = authorRepository.getAuthorsBookList(1);
        System.out.println(authorByIdWithBook);
    }
}
