package com.sight.config.db.user;

import com.sight.config.AppProfile;
import com.sight.config.db.BaseDataSourceConfig;
import com.sight.config.db.DataSourceRole;
import com.sight.config.db.DataSourceType;
import com.sight.config.db.board.BoardRouteDataSource;
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
public class UserDataSourceConfig extends BaseDataSourceConfig {

    public static final String DATASOURCE = "userDataSource";
    public static final String ROUTE_DATASOURCE = "userRouteDataSource";
    public static final String RW_DATASOURCE = "userRwDataSource";
    public static final String RO_DATASOURCE = "userRoDataSource";
    public static final String TEST_DATASOURCE = "userTestDataSource";
    public static final DataSourceType dataSourceType = DataSourceType.USER;

    public UserDataSourceConfig(Environment env) {
        super(env);
    }

    @Profile(AppProfile.NON_TEST)
    @Bean(name = DATASOURCE)
    public DataSource dataSource(
            @Qualifier(UserDataSourceConfig.ROUTE_DATASOURCE) DataSource routeDataSource
    ) {
        return new LazyConnectionDataSourceProxy(routeDataSource);
    }


    @Profile(AppProfile.NON_TEST)
    @Bean(name = ROUTE_DATASOURCE)
    public DataSource routingDataSource(
            @Qualifier(UserDataSourceConfig.RW_DATASOURCE) DataSource rwDataSource,
            @Qualifier(UserDataSourceConfig.RO_DATASOURCE) DataSource roDataSource
    ) {
        Map<Object, Object> dataSourceMap = new HashMap<>();
        dataSourceMap.put(DataSourceRole.READ_WRITE, rwDataSource);
        dataSourceMap.put(DataSourceRole.READ_ONLY, roDataSource);

        return new UserRouteDataSource(dataSourceMap);
    }


    @Profile(AppProfile.NON_TEST)
    @Bean(name = RW_DATASOURCE)
    public DataSource rwDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(getJdbcUrl(dataSourceType, DataSourceRole.READ_WRITE));
        dataSource.setDriverClassName(getDriverClassName(dataSourceType));
        dataSource.setUsername(getUsername(dataSourceType));
        dataSource.setPassword(getPassword(dataSourceType));

        return dataSource;
    }

    @Profile(AppProfile.NON_TEST)
    @Bean(name = RO_DATASOURCE)
    public DataSource roDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(getJdbcUrl(dataSourceType, DataSourceRole.READ_ONLY));
        dataSource.setDriverClassName(getDriverClassName(dataSourceType));
        dataSource.setUsername(getUsername(dataSourceType));
        dataSource.setPassword(getPassword(dataSourceType));

        return dataSource;
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
