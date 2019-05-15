import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    val kotlinVersion = "1.3.31"

    id("org.jetbrains.kotlin.jvm") version kotlinVersion
    id("org.jetbrains.kotlin.plugin.spring") version kotlinVersion

    id("com.adarshr.test-logger") version "1.6.0"
}

testlogger {
    setTheme("mocha")
}

repositories {
    jcenter()
}

dependencies {
    api("io.arrow-kt:arrow-core-data:0.9.0")
    api("io.strikt:strikt-core:0.20.0")

    implementation(kotlin("stdlib-jdk8"))

    val spek_version = "2.0.4"

    testImplementation("org.spekframework.spek2:spek-dsl-jvm:$spek_version")
    testRuntimeOnly("org.spekframework.spek2:spek-runner-junit5:$spek_version")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
        apiVersion = "1.3"
        languageVersion = "1.3"
    }
}
tasks.withType<Test>().configureEach {
    useJUnitPlatform {
        includeEngines.add("spek2")
    }
}
