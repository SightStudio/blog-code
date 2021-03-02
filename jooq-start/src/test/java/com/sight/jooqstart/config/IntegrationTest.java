package com.sight.jooqstart.config;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

@Profile(AppProfile.TEST)
@Transactional
@SpringBootTest
public abstract class IntegrationTest { }
