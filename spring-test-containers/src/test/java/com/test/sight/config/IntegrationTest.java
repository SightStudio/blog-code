package com.test.sight.config;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.MariaDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import javax.transaction.Transactional;

@ActiveProfiles("test")
@Testcontainers
@SpringBootTest
@Transactional
public abstract class IntegrationTest implements BaseTest {

    @Container
    private static final MariaDBContainer mariaDBContainer = new MariaDBContainer("mariadb:10.4");

}
