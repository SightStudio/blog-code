package com.sight.config.db;

import com.sight.config.db.board.BoardDatabaseConfig;
import com.sight.config.db.user.UserDatabaseConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class ChainedTransactionConfig {

    @Bean
    @Primary
    @Autowired
    public PlatformTransactionManager chainedTransactionManager(
            @Qualifier(BoardDatabaseConfig.transactionManager) PlatformTransactionManager firstTxManager,
            @Qualifier(UserDatabaseConfig.transactionManager) PlatformTransactionManager secondTxManager)
    {
        return new ChainedTransactionManager(firstTxManager, secondTxManager);
    }
}
