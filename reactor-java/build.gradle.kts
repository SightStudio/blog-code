plugins {
    java
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.projectreactor:reactor-core:3.3.8.RELEASE")
    testImplementation("io.projectreactor:reactor-test:3.3.8.RELEASE")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.3.1")
    testImplementation("org.junit-pioneer:junit-pioneer:0.9.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.3.1")
}
