package com.sight.config.db.user;

import com.sight.config.AppProfile;
import com.sight.config.db.BaseDatabaseConfig;
import com.sight.config.db.DataSourceType;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    basePackages = UserDatabaseConfig.entityPackage,
    entityManagerFactoryRef = UserDatabaseConfig.entityManager,
    transactionManagerRef = UserDatabaseConfig.transactionManager
)
public class UserDatabaseConfig extends BaseDatabaseConfig {

    public static final String entityManager = "userEntityManagerFactory";
    public static final String transactionManager = "userTransactionManager";
    public static final String entityPackage = "com.sight.app.domain.user";
    public static final DataSourceType dataSourceType = DataSourceType.USER;

    public UserDatabaseConfig(Environment env) {
        super(env);
    }

    @Profile(AppProfile.NON_TEST)
    @Bean(name = entityManager)
    public LocalContainerEntityManagerFactoryBean entityManagerFactory (
            @Qualifier(UserDataSourceConfig.ROUTE_DATASOURCE) DataSource routeDataSource
    ) {

        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setDataSource(routeDataSource);
        entityManager.setJpaVendorAdapter(getJpaVendorAdapter());
        entityManager.setJpaPropertyMap(getJpaPropertyMap(dataSourceType));
        entityManager.setPackagesToScan(UserDatabaseConfig.entityPackage);
        entityManager.setPersistenceUnitName(dataSourceType.getDataSourceSchemaName());

        return entityManager;
    }

    @Profile(AppProfile.TEST)
    @Bean(name = entityManager)
    public LocalContainerEntityManagerFactoryBean testEntityManagerFactory (
            @Qualifier(UserDataSourceConfig.TEST_DATASOURCE) DataSource testDataSource
    ) {

        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setDataSource(testDataSource);
        entityManager.setJpaVendorAdapter(getJpaVendorAdapter());
        entityManager.setJpaPropertyMap(getJpaPropertyMap(dataSourceType));
        entityManager.setPackagesToScan(UserDatabaseConfig.entityPackage);
        entityManager.setPersistenceUnitName(dataSourceType.getDataSourceSchemaName());

        return entityManager;
    }

    @Bean(name = transactionManager)
    public PlatformTransactionManager transactionManager(
            @Qualifier(UserDatabaseConfig.entityManager) EntityManagerFactory entityManagerFactory
    ) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
}
