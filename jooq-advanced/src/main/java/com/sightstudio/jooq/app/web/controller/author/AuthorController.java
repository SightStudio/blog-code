package com.sightstudio.jooq.app.web.controller.author;

import com.sightstudio.jooq.app.domain.author.Author;
import com.sightstudio.jooq.app.domain.author.AuthorDto;
import com.sightstudio.jooq.app.domain.author.AuthorService;
import com.sightstudio.jooq.app.web.request.AuthorBulkRegisterRequest;
import com.sightstudio.jooq.app.web.request.AuthorRegisterRequest;
import com.sightstudio.jooq.app.web.request.AuthorSearchRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    /**
     * GET /author 저자 목록 조회
     */
    @GetMapping
    public List<AuthorDto> getAuthorList(AuthorSearchRequest searchRequest) {
        return authorService.getAuthorList(searchRequest);
    }

    /**
     * POST /author 저자 등록
     */
    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void registerAuthor(@RequestBody AuthorRegisterRequest request) {
        authorService.registerAuthor(request);
    }

    /**
     * POST /author/bulk 저자 다중 등록
     * 비교를 위해 API 엔드포인트를 따로 둠
     */
    @PostMapping("/bulk")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void registerAuthors(@RequestBody AuthorBulkRegisterRequest request) {
        authorService.registerAuthor(request);
    }
}