import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import java.util.regex.Pattern

plugins {
    java
    id("com.github.johnrengelman.shadow") version "6.1.0"
    kotlin("jvm") version "1.4.10"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.testng", "testng", "7.4.0")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_11
}

tasks.register("testJar", type = ShadowJar::class) {
    group = "build"

    dependsOn("testClasses")
    archiveBaseName.set("autotests-fat-jar")
    from(sourceSets.main.map { it.runtimeClasspath.files })
    from(sourceSets.test.map { it.runtimeClasspath.files })
    from(project.configurations.testRuntime.get().files)
    manifest {
        attributes["Multi-Release"] = true
    }
}
