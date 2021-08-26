package com.sight.config.db;

public enum DataSourceRole {
    READ_WRITE("rw"),  // 쓰기 전용
    READ_ONLY("ro"),   // 읽기 전용
    TEST_ONLY("test"); // 테스트 전용
    private final String nameSpace;

    DataSourceRole(final String nameSpace) {
        this.nameSpace = nameSpace;
    }

    public String getNameSpace() {
        return nameSpace;
    }
}
