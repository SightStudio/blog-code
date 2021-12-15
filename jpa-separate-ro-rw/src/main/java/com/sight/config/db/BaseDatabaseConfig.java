package com.sight.config.db;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class BaseDatabaseConfig {

    protected final Environment env;

    public BaseDatabaseConfig(Environment env) {
        this.env = env;
    }

    protected String getDialect() {
        return env.getProperty("spring.jpa.database-platform");
    }

    protected Map<String, Object> getJpaPropertyMap(final DataSourceType dataSourceType) {

        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", getDdlAuto(dataSourceType));
        properties.put("hibernate.dialect", getDialect());
        return properties;
    }

    protected HibernateJpaVendorAdapter getJpaVendorAdapter() {
        return new HibernateJpaVendorAdapter();
    }

    protected String getDdlAuto(final DataSourceType dataSourceType) {
        final String ddlAuto = dataSourceType.getDataSourceProperty() + ".ddl-auto";
        return env.getProperty(ddlAuto);
    }
}
