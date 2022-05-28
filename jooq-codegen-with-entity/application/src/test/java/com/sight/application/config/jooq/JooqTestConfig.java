package com.sight.application.config.jooq;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.NameTokenizers;
import org.modelmapper.jooq.RecordValueReader;
import org.modelmapper.module.jdk8.Jdk8Module;
import org.modelmapper.module.jsr310.Jsr310Module;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class JooqTestConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.registerModule(new Jsr310Module());
        mapper.registerModule(new Jdk8Module());

        mapper.getConfiguration()
              .setSourceNameTokenizer(NameTokenizers.UNDERSCORE)
              .addValueReader(new RecordValueReader());

        return mapper;
    }
}
