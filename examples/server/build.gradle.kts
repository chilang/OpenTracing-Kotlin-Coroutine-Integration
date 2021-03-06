val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val junit_version: String by project
val coroutines_version: String by project
val opentracing_version: String by project

plugins {
    application
    kotlin("jvm")
    id("org.jetbrains.dokka")
}

application {
    mainClassName = "io.ktor.server.netty.EngineMain"
}

group = rootProject.group
version = rootProject.version

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(project(":coroutine-tracing-api-ktor:coroutine-tracing-api-server-ktor"))
    implementation(project(":coroutine-tracing-api-core"))
    implementation("io.ktor:ktor-server-netty:$ktor_version")
    implementation("io.jaegertracing:jaeger-core:1.1.0")
    implementation("io.jaegertracing:jaeger-client:1.1.0")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}