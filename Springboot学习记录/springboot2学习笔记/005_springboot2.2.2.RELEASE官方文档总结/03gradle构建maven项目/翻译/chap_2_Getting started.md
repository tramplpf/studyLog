# Chapter 2. Getting started

为了使用gradle插件，你需要将gradle应用于你的应用。 

gradle 插件被发布在 Gradle‘s plugin portal (https://plugins.gradle.org/plugin/org.springframework.boot ) 中，并且可以在plugins块中使用。 

Groovy

    plugins{
        id 'org.springframework.boot' version '2.2.2.RELEASE'
    }

Kotlin

    plugins{
        id("org.springframework.boot") version "2.2.2.RELEASE"
    }


独立使用gradle插件让你的项目有所变化。Instead, 当gradle 插件侦查到其他的插件被应用的时候，会做出适当的反应。 例如， java 插件会定义一个任务来自动构建一个可执行的jar包  一个典型的 Spring Boot 项目将会应用  groovy， java 和org.jetbrains.kotlin.jvm 插件以及 io.spring.dependency-management 插件是最小的组合。 例如：

Groovy

    apply plugin 'java'
    apply plugin 'io.spring.dependency-management'

Kotlin

    plugins {
        java 
        id("org.springframework.boot") version "2.2.2.RELEASE"
    }
    apply(plugin = "io.spring.dependency-management")

想要知道spring boot 的gradle插件在其他插件存在的情况下回有什么响应， 可以查看 reacting to other plugins 章节的内容。 

