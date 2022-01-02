package com.sightstudio.jooq.domain.author;


import com.sightstudio.jooq.app.domain.author.Author;
import com.sightstudio.jooq.app.domain.author.AuthorRepository;
import com.sightstudio.jooq.config.JooqRepoTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;

import java.time.LocalDate;

@Import(AuthorRepository.class)
public class AuthorRepoTest extends JooqRepoTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    @DisplayName("[Author] 저자를_저장하고_PK_값을_가져온다")
    void 저자를_저장하고_PK_값을_가져온다() {

        // given
        Author author = new Author("Sight", "Studio", LocalDate.parse("1995-12-12"), 1995);

        // when
        Integer authorId = authorRepository.registerAuthor(author);

        // then
        Assertions.assertNotNull(authorId);
    }

//    @Test
//    @DisplayName("[Author] 저자_삭제_테스트")
//    void 저자_삭제_테스트() {
//
//        // given
//        AuthorDto author = new AuthorDto("Sight", "Studio", LocalDate.parse("1995-12-12"), 1995);
//
//        // when
//        AuthorDto result = authorRepository.save(author);
//        int deleteCnt = authorRepository.removeAuthor(result);
//
//        // then
//        Assertions.assertEquals(1 , deleteCnt);
//    }
//
//    @Test
//    @DisplayName("[Author] 저자가 작성한 책 목록 조회 (저자 정보 포함)")
//    void 저자_책_목록_조회() {
//        List<AuthorBookDto> authorByIdWithBook = authorRepository.getAuthorsBookList(1);
//        System.out.println(authorByIdWithBook);
//    }
}
