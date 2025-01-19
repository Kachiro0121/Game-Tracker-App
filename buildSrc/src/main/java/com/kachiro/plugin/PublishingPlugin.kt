package com.kachiro.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class PublishingPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        println("Hallo from PublishingPlugin config!")
        val extension = project.extensions.create("publishingConfig", PublishingExtension::class.java)
        project.tasks.create("publishToGooglePlay", PublishTask::class.java).apply {
            group = "publishing"
            description = "Публикация приложения на Google Play"
            doLast {
                println("Публикация в трек: ${extension.track}")
                println("Процент раскатки: ${extension.userFraction}")
                println("Release notes: ${extension.releaseNotes ?: "Не указаны"}")
            }
        }
    }

}