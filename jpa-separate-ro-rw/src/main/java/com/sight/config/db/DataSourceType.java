package com.sight.config.db;

public enum DataSourceType {

    BOARD(BaseDataSourceConfig.BOARD, "app.datasource.board"),
    USER(BaseDataSourceConfig.USER, "app.datasource.user");

    private final String dataSourceSchemaName;
    private final String dataSourceProperty;

    DataSourceType(String dataSourceSchemaName, String dataSourceProperty) {
        this.dataSourceSchemaName = dataSourceSchemaName;
        this.dataSourceProperty = dataSourceProperty;
    }

    public String getDataSourceProperty() {
        return dataSourceProperty;
    }

    public String getDataSourceSchemaName() {
        return dataSourceSchemaName;
    }
}