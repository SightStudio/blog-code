package com.sight.jooqstart.config;

import com.sight.jooqstart.config.jooq.JooqTestConfig;
import org.springframework.boot.test.autoconfigure.jooq.JooqTest;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

@Import(JooqTestConfig.class)
@Profile(AppProfile.TEST)
@Transactional
@JooqTest
public abstract class JooqRepoTest { }
