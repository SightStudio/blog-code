package com.sight.batch.config;

import org.jooq.conf.ExecuteWithoutWhere;
import org.jooq.conf.RenderImplicitJoinType;
import org.springframework.boot.autoconfigure.jooq.DefaultConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JooqConfig {
    @Bean
    public DefaultConfigurationCustomizer jooqDefaultConfigurationCustomizer() {
        return c -> c.settings()

                // where 절 없이 delete, update 실행 금지
                .withExecuteDeleteWithoutWhere(ExecuteWithoutWhere.THROW)
                .withExecuteUpdateWithoutWhere(ExecuteWithoutWhere.THROW)

                // implicit join 사용 금지
                .withRenderImplicitJoinType(RenderImplicitJoinType.THROW)
                .withRenderImplicitJoinToManyType(RenderImplicitJoinType.THROW)
                .withRenderSchema(false);
    }
}
