package com.sight.testType;

import com.sight.config.AppProfile;
import org.springframework.test.context.ActiveProfiles;

import java.nio.file.Path;
import java.nio.file.Paths;

@ActiveProfiles(AppProfile.LOCAL)
public interface BaseTest {

    default String getResourcePath() {
        Path resourcePath = Paths.get("src", "test", "resources");
        return resourcePath.toFile().getAbsolutePath();
    }
}
