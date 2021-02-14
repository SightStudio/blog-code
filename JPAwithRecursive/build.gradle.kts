import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.4.1"
    id("io.spring.dependency-management") version "1.0.10.RELEASE"
    kotlin("jvm")             version "1.4.21"
    kotlin("kapt")            version "1.4.21"
    kotlin("plugin.spring")   version "1.4.21"
    kotlin("plugin.jpa")      version "1.4.21"
    kotlin("plugin.allopen")  version "1.4.21"
    kotlin("plugin.noarg")    version "1.4.21"
}

group = "com.sight"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8
val queryDsl = "4.3.1"
val blaze    = "1.5.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // JPA
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    // QueryDSL And Blaze
    implementation("com.querydsl:querydsl-jpa:${queryDsl}")
    kapt("com.querydsl:querydsl-apt:${queryDsl}:jpa")
    kaptTest("com.querydsl:querydsl-apt:${queryDsl}:jpa")

    implementation(platform("com.blazebit:blaze-persistence-bom:$blaze"))
    implementation("com.blazebit:blaze-persistence-integration-querydsl-expressions:$blaze")
    compileOnly("com.blazebit:blaze-persistence-core-api:$blaze")
    runtimeOnly("com.blazebit:blaze-persistence-core-impl:$blaze")
    runtimeOnly("com.blazebit:blaze-persistence-integration-hibernate-5.4:$blaze")

    testImplementation(platform("com.blazebit:blaze-persistence-bom:$blaze"))
    testImplementation("com.blazebit:blaze-persistence-integration-querydsl-expressions:$blaze")
    testCompileOnly("com.blazebit:blaze-persistence-core-api:$blaze")
    testRuntimeOnly("com.blazebit:blaze-persistence-core-impl:$blaze")
    testRuntimeOnly("com.blazebit:blaze-persistence-integration-hibernate-5.4:$blaze")

    // drivers
    runtimeOnly("com.microsoft.sqlserver:mssql-jdbc")
    runtimeOnly("com.oracle.database.jdbc:ojdbc8")
    runtimeOnly("mysql:mysql-connector-java")
    runtimeOnly("org.mariadb.jdbc:mariadb-java-client")
    runtimeOnly("org.postgresql:postgresql")

    testImplementation("io.mockk:mockk:1.10.0")
    testImplementation("com.ninja-squad:springmockk:2.0.3")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
        exclude(module = "mockito-core")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
