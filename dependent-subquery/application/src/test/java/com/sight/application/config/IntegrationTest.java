package com.sight.application.config;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

@Profile(AppProfile.TEST)
@SpringBootTest
public abstract class IntegrationTest { }
