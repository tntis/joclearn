plugins {
    java
    id("org.springframework.boot") version "3.5.7"
    id("io.spring.dependency-management") version "1.1.7"
    id("java-test-fixtures")
}

group = "jocture"
version = "0.0.1-SNAPSHOT"
description = "joclearn"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "java-test-fixtures")

    repositories {
        mavenCentral()
    }

    dependencies {
        compileOnly("org.projectlombok:lombok")
        annotationProcessor("org.projectlombok:lombok")

        testImplementation("org.springframework.boot:spring-boot-starter-test")
        testFixturesImplementation("org.springframework.boot:spring-boot-starter-test")
        testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

project(":modules:app-boot") {
    dependencies {
        implementation(project(":modules:presentation"))
        implementation(project(":modules:application"))
        implementation(project(":modules:domain"))
        implementation(project(":modules:infra"))
    }
}

project(":modules:presentation") {
    dependencies {
        implementation(project(":modules:application"))
    }
}

project(":modules:application") {
    dependencies {
        implementation(project(":modules:domain"))

        testImplementation(project(":modules:app-boot"))
        testImplementation(testFixtures(project(":modules:infra")))
    }
}

project(":modules:domain") {
    dependencies {
        testImplementation(testFixtures(project(":modules:infra")))
    }
}

project(":modules:infra") {
    dependencies {
        implementation(project(":modules:domain"))

        testFixturesImplementation(project(":modules:domain"))
    }
}
