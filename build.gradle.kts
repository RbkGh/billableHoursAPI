import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.3.0.RELEASE"
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
    war
    kotlin("jvm") version "1.3.72"
    kotlin("plugin.spring") version "1.3.72"
    kotlin("plugin.jpa") version "1.3.72"
}

group = "com.techustle"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-web")
    //flyway db migrations library
    implementation("org.flywaydb:flyway-core")
    //json webtoken library
    implementation("io.jsonwebtoken:jjwt:0.9.0")
    //googe java libraries for extra java functionalities
    implementation("com.google.guava:guava:28.0-jre")
    //spring fox library for automatic API documentation
    implementation("io.springfox:springfox-swagger2:2.8.0")
    implementation("io.springfox:springfox-swagger-ui:2.8.0")

    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.11.+")

    implementation("org.hibernate.validator:hibernate-validator:6.0.2.Final")
    implementation("org.hibernate.validator:hibernate-validator-annotation-processor:6.0.2.Final")
//    <dependency>
//    <groupId>javax.el</groupId>
//    <artifactId>javax.el-api</artifactId>
//    <version>3.0.0</version>
//    </dependency>
//
//    <dependency>
//    <groupId>org.glassfish.web</groupId>
//    <artifactId>javax.el</artifactId>
//    <version>2.2.6</version>
//    </dependency>

    runtimeOnly("mysql:mysql-connector-java")
    runtimeOnly("com.h2database:h2")
    runtimeOnly("org.springframework.boot:spring-boot-devtools")
    providedRuntime("org.springframework.boot:spring-boot-starter-tomcat")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }

//    testImplementation("org.junit.jupiter:junit-jupiter-api:5.2.0")
//    testCompile("org.junit.jupiter:junit-jupiter-params:5.2.0")
//    testRuntime("org.junit.jupiter:junit-jupiter-engine:5.2.0")
//    testCompile("org.mockito:mockito-core:2.+")
//    testCompile("org.mockito:mockito-junit-jupiter:2.18.3")

    testImplementation("org.springframework.security:spring-security-test")
    testImplementation("com.h2database:h2:1.4.194")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}
