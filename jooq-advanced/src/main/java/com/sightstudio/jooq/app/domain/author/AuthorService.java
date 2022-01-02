package com.sightstudio.jooq.app.domain.author;

import com.sightstudio.jooq.app.web.request.AuthorBulkRegisterRequest;
import com.sightstudio.jooq.app.web.request.AuthorRegisterRequest;
import com.sightstudio.jooq.app.web.request.AuthorSearchRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public List<AuthorDto> getAuthorList(AuthorSearchRequest searchRequest) {
        return authorRepository.getAuthorList(searchRequest).stream()
                .map(AuthorDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public int registerAuthor(AuthorRegisterRequest registerRequest) {
        Author author = new Author(registerRequest);
        return authorRepository.registerAuthor(author);
    }

    @Transactional
    public int registerAuthor(AuthorBulkRegisterRequest registerRequest) {
        List<Author> authors = registerRequest.getAuthorList().stream()
                .map(Author::new)
                .collect(Collectors.toList());

        return authorRepository.bulkRegisterAuthor(authors);
    }
}
