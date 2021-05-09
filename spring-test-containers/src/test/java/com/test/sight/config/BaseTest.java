package com.test.sight.config;

import java.io.InputStream;

interface BaseTest {
    default InputStream getResourceAsStream(final String path) {
        return this.getResourceAsStream(path);
    }
}
