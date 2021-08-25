package com.sight.testType;

import com.sight.config.db.board.BoardDataSourceConfig;
import com.sight.config.db.board.BoardDatabaseConfig;
import com.sight.testConfig.JpaTestConfig;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import javax.transaction.Transactional;

@DataJpaTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(value = {
    JpaTestConfig.class,
    BoardDatabaseConfig.class,
    BoardDataSourceConfig.class
})
public abstract class DataJpaRepoTest implements BaseTest {

}
