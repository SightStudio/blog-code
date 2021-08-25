package com.sight.config.db.board;

import com.sight.config.AppProfile;
import com.sight.config.db.BaseDataSourceConfig;
import com.sight.config.db.DataSourceRole;
import com.sight.config.db.DataSourceType;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class BoardDataSourceConfig extends BaseDataSourceConfig {

    public static final String ROUTE_DATASOURCE = "boardRouteDataSource";
    public static final String RW_DATASOURCE = "boardRwDataSource";
    public static final String RO_DATASOURCE = "boardRoDataSource";
    public static final String TEST_DATASOURCE = "boardTestDataSource";
    public static final DataSourceType dataSourceType = DataSourceType.BOARD;

    public BoardDataSourceConfig(Environment env) {
        super(env);
    }

    @Profile(AppProfile.NON_TEST)
    @Bean(name = ROUTE_DATASOURCE)
    public DataSource routingDataSource(
            @Qualifier(BoardDataSourceConfig.RW_DATASOURCE) DataSource rwDataSource,
            @Qualifier(BoardDataSourceConfig.RO_DATASOURCE) DataSource roDataSource
    ) {
        BoardRouteDataSource routingDataSource = new BoardRouteDataSource();

        Map<Object, Object> dataSourceMap = new HashMap<>();
        dataSourceMap.put(DataSourceRole.READ_WRITE, rwDataSource);
        dataSourceMap.put(DataSourceRole.READ_ONLY , roDataSource);

        routingDataSource.setTargetDataSources(dataSourceMap);
        routingDataSource.setDefaultTargetDataSource(rwDataSource);

        return routingDataSource;
    }


    @Profile(AppProfile.NON_TEST)
    @Bean(name = RW_DATASOURCE)
    public DataSource rwDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(getJdbcUrl(dataSourceType, DataSourceRole.READ_WRITE));
        dataSource.setDriverClassName(getDriverClassName(dataSourceType));
        dataSource.setUsername(getUsername(dataSourceType));
        dataSource.setPassword(getPassword(dataSourceType));

        return new LazyConnectionDataSourceProxy(dataSource);
    }

    @Profile(AppProfile.NON_TEST)
    @Bean(name = RO_DATASOURCE)
    public DataSource roDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(getJdbcUrl(dataSourceType, DataSourceRole.READ_ONLY));
        dataSource.setDriverClassName(getDriverClassName(dataSourceType));
        dataSource.setUsername(getUsername(dataSourceType));
        dataSource.setPassword(getPassword(dataSourceType));

        return new LazyConnectionDataSourceProxy(dataSource);
    }

    @Profile(AppProfile.TEST)
    @Bean(name = TEST_DATASOURCE)
    public DataSource testDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(getJdbcUrl(dataSourceType, DataSourceRole.TEST_ONLY));
        dataSource.setDriverClassName(getDriverClassName(dataSourceType));
        dataSource.setUsername(getUsername(dataSourceType));
        dataSource.setPassword(getPassword(dataSourceType));

        return dataSource;
    }
}
