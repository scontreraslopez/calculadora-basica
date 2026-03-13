plugins {
    id("java")
}

group = "io.github.scontreraslopez"
version = "1.0-SNAPSHOT"

// 1. OBLIGAMOS a usar una versión específica de Java (ej. Java 21)
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}

// 2. FORZAMOS UTF-8 para evitar problemas con tildes y eñes en Windows
tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}