package com.sight.application.config;

import com.sight.application.config.jooq.JooqTestConfig;
import org.springframework.boot.test.autoconfigure.jooq.JooqTest;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

@Import(JooqTestConfig.class)
@Profile(AppProfile.TEST)
@JooqTest
public abstract class JooqRepoTest { }
