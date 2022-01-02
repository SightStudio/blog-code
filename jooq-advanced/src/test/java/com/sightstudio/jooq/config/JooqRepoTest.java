package com.sightstudio.jooq.config;

import com.sightstudio.jooq.config.jooq.JooqTestConfig;
import org.springframework.boot.test.autoconfigure.jooq.JooqTest;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

@Import(JooqTestConfig.class)
@Profile(AppProfile.TEST)
@JooqTest
public abstract class JooqRepoTest { }
