val ktorVersion: String by project
val kotlinVersion: String by project
val logbackVersion: String by project

plugins {
    application
    kotlin("jvm") version "1.4.21"
}

group = "de.mari"
version = "0.0.1"

application {
    mainClassName = "io.ktor.server.netty.EngineMain"
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=true")
}

repositories {
    mavenLocal()
    jcenter()
    maven { url = uri("https://kotlin.bintray.com/ktor") }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    implementation("ch.qos.logback:logback-classic:$logbackVersion")
    implementation("io.ktor:ktor-server-core:$ktorVersion")
    implementation("io.ktor:ktor-server-host-common:$ktorVersion")
    implementation("io.ktor:ktor-jackson:$ktorVersion")
    testImplementation("io.ktor:ktor-server-tests:$ktorVersion")
}

kotlin.sourceSets["main"].kotlin.srcDirs("src")
kotlin.sourceSets["test"].kotlin.srcDirs("test")

sourceSets["main"].resources.srcDirs("resources")
sourceSets["test"].resources.srcDirs("resources")

val fatJar = task("fatJar", type = org.gradle.jvm.tasks.Jar::class) {
    manifest {
        attributes["Implementation-Title"] = "Ktor - Vue Fat Jar"
        attributes["Implementation-Version"] = project.version
        attributes["Main-Class"] = "io.ktor.server.netty.EngineMain"
    }
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
    with(tasks.jar.get() as CopySpec)
}

var env = "production"

val setDev = tasks.register("setDev") {
    env = "development"
}

tasks.processResources {
    outputs.upToDateWhen { false }
    filesMatching("*.conf") {
        when (env) {
            "development" -> {
                expand(
                    "KTOR_ENV" to "dev",
                    "KTOR_PORT" to "8081",
                    "KTOR_MODULE" to "build",
                    "KTOR_AUTORELOAD" to "true"
                )
            }
            "production" -> {
                expand(
                    "KTOR_ENV" to "production",
                    "KTOR_PORT" to "80",
                    "KTOR_MODULE" to "",
                    "KTOR_AUTORELOAD" to "false"
                )
            }
        }
    }
}

val addTypes = tasks.register<Copy>("addTypes") {
    delete("$projectDir/src/types/")
    from("../shared/build/libs/kt-jvm/")
    include("**/*.kt")
    into("$projectDir/src/types/")
}

tasks {
    "run" {
        dependsOn(setDev)
    }
    "build" {
        dependsOn(":client:build")
        dependsOn(fatJar)
        doLast {
            copy {
                delete("$rootDir/build")
                from(fatJar)
                into(file("$rootDir/build"))
            }
        }
    }
}