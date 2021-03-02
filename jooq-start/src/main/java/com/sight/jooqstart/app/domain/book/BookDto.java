package com.sight.jooqstart.app.domain.book;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDto {
    private Integer id;
    private Integer authorId;
    private String  title;
    private Integer publishedIn;
    private Integer languageId;
}
