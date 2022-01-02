package com.sightstudio.jooq.config;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

@Profile(AppProfile.TEST)
@SpringBootTest
public abstract class IntegrationTest { }
