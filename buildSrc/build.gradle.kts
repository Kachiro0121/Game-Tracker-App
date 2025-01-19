import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.24"
    `kotlin-dsl`
}

val javaVersion = JavaVersion.VERSION_17

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions.jvmTarget = javaVersion.toString()
}

repositories {
    mavenCentral()
    google()
    gradlePluginPortal()
}

gradlePlugin {
    plugins {
        create("publishingPlugin") {
            id = "com.kachiro.publishing"
            description = "publishing"
            implementationClass = "com.kachiro.plugin.PublishingPlugin"
        }
    }
}

dependencies{
    implementation(gradleApi())
    implementation(localGroovy())
}