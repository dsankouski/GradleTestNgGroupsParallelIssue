import java.util.regex.Pattern

plugins {
    java
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

tasks.test {
    useTestNG {
        if (project.hasProperty("groups")) {
            val testNgGroups = project.property("groups").toString()
                    .split(Pattern.compile("\\W+"))
            logger.quiet("Running tests with groups: $testNgGroups")
            this.includeGroups(*testNgGroups.toTypedArray())
        }
        if (project.hasProperty("parallel.threadCount")) {
            parallel = "classes"
            threadCount = Integer.valueOf(project.property("parallel.threadCount").toString())
        }
    }
    if (project.hasProperty("parallel.forkCount")) {
        maxParallelForks = Integer.valueOf(project.property("parallel.forkCount").toString())
    }
    testLogging {
        showStackTraces = true
        showExceptions = true
        showCauses = true
        showStandardStreams = true
    }
}

dependencies {
    testImplementation("org.testng", "testng", "7.1.0")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}