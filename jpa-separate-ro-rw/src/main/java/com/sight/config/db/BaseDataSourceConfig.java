package com.sight.config.db;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class BaseDataSourceConfig {

    protected final Environment env;

    // Multiple-Database 스키마 목록
    public static final String BOARD = "board";
    public static final String USER = "user";

    public BaseDataSourceConfig(Environment env) {
        this.env = env;
    }

    protected String getDriverClassName(final DataSourceType dataSourceType) {
        final String driverClassName = dataSourceType.getDataSourceProperty() + ".driverClassName";
        return env.getProperty(driverClassName);
    }

    protected String getJdbcUrl(final DataSourceType dataSourceType, DataSourceRole dataSourceRole) {

        final String jdbcUrl = String.format(
                "%s.%s.jdbc-url",
                dataSourceType.getDataSourceProperty(),
                dataSourceRole.getNameSpace()
        );

        return env.getProperty(jdbcUrl);
    }

    protected String getUsername(final DataSourceType dataSourceType) {
        final String username = dataSourceType.getDataSourceProperty() + ".username";
        return env.getProperty(username);
    }

    protected String getPassword(final DataSourceType dataSourceType) {
        final String password = dataSourceType.getDataSourceProperty() + ".password";
        return env.getProperty(password);
    }
}
