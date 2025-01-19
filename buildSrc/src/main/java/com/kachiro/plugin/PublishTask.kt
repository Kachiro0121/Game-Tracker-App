package com.kachiro.plugin

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.CacheableTask
import org.gradle.api.tasks.TaskAction

@CacheableTask
open class PublishTask: DefaultTask() {

    @TaskAction
    fun publish() {
        println("Задача для публикации выполнена.")
    }

}