package com.sight.application.tc.config;

import com.sight.application.tc.JooqTcDSLApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(classes = JooqTcDSLApplication.class)
@Transactional
public abstract class IntegrationTest {

}
