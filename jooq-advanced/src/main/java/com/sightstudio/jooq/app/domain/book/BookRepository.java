package com.sightstudio.jooq.app.domain.book;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BookRepository {
    private final DSLContext dsl;
    private final ModelMapper mapper;
}