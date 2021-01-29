package com.sight.blog.config.test

import java.nio.file.Path
import java.nio.file.Paths

interface BaseTest {

    fun getResourcePath(): String {
        val resourceDirectory: Path = Paths.get("src", "test", "resources")
        return resourceDirectory.toFile().absolutePath
    }
}