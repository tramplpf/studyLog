<<<<<<< HEAD
# Chapter4_Packaging executable archives (打包可执行的包)

这个插件可以打包可执行的压缩包(jar文件或者war文件)。 这些压缩包包含应用程序的所有依赖并且可以通过 java -jar 命令来运行它。 

 ## 4.1 Packaging executable jars (打包可执行的jars包)
 可以使用 <bootJar> 任务来构建可执行的jar包。 当[war] 插件被应用的时候，这个任务将会被自动创建，并且这个任务是BootWar的实例。 <assemble> 任务依赖于 <bootWar> 任务,因此运行<assemble>(或者<build>)r任务的时候也运行<bootWar> 任务。 

 ## 4.2 Packing executable wars(打包可执行wars包) 
 可以使用<bootWars> 任务来打包可执行的war包。当应用[war]插件的时候<bootWars>任务会被自动创建这个任务是BootWar的实例。 <assemble>任务依赖于<bootWar>任务，因此在运行<assemble>(或者<build>)任务的时候也会运行<bootWar> 任务。

### 4.2.1 Packing executable and deployable wars (打包可执行可部署的war包)
一个war文件可以打包成一个可以通过 java -jar 命令执行的可执行包，并且它依赖于一个外部的容器。 为了得到这样的可执行war包。 必须向providedRuntime 配置项中添加一个内嵌容器依赖的。 配置内容如下：

Groovy
=======
# Chpter 4 Packaging executable archives (打包可执行的归档包)

插件可以创建可执行的归档包（jar包或者war 包）。 这些归档包含一个应用程序的所有的依赖。 可以通过java -jar 命令来运行这个归档包。 


## 4.1 Packing executable jars (打包可执行jars包)
可以通过 [bootJar] 任务来构建可执行的jar包。 当<java> 插件被应用的时候，这个任务会自动创建并且[bootJar] 任务是 [BootJar] 的一个实例。 [bootJar] 任务依赖于[assemble] 任务，因此当运行 [assemble] 任务（或者[build]任务）的时候，会自动运行 [bootJar] 任务。 


## 4.2 Packing executable wars (打包可执行的wars包)
可以通过[bootWar]任务来构建可执行的wars包。当<War> 插件被应用的时候，[bootWar]任务将会自动创建，并且它是[BootWar]的一个实例。 [assemble]任务被配置为自动依赖[bootWar]任务，因此当你运行[assemble]（或者[build]）任务的时候，将会自动运行[bootWar]任务。 


### 4.2.1 Packing executable and  deployable wars (打包可执行和可部署war包)
一个war 文件可以打包成一个既可以通过 java -jar 命令执行也可以在外部容器部署的归档包。  为了实现这个目的，servlet 容器的依赖应该添加为 providedRuntime 配置。 例如 

Groovy 
>>>>>>> 8f91a23439873f58bce0bd124719542c1b4a8520

    dependencies {
        implementation 'org.springframework.boot:spring-boot-starter-web'
        providedRuntime 'org.springframework.boot:spring-boot-starter-tomcat'
    }

<<<<<<< HEAD
Kotlin

    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-web")
        providedRuntime("org.springframework.boot:spring-boot-starter-tomcat");
    }

上面的配置可以确保这些被打包进war包文件的 'WEB-INF/lib-provided' 目录下，这个路径可以确保外部容器的类和你自己的类不冲突。 

提示: providedRuntime配置依赖于Gradle 的 compileOnly 配置， 在测试的类路径下 compileOnly 依赖不会被引入，因此基于 web 整合的测试都会失败。 


## 4.3 Packing executable and normal archives (打包可执行以及普通的压缩包)
默认情况下，当<bootJar> 或者<bootWar> 任务配置的前提下，<jar>或者<war> 任务将会被禁用。 可以通过启动<jar>或者<war>任务来配置一下项目同时生成可执行的压缩包以及常规的压缩包。 


Groovy

    jar {
        enable = true
    }

Kotlin
    tasks.getByName<Jar>("jar"){
        enabled = true
    }

## 4.4 Configuring executable archive packing (打包可执行的压缩包)
=======
Kotlin 

    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-web")
        providedRuntime("org.springframework.boot:spring-boot-starter-tomcat")
    }

上面的配置可以确保servlet 容器依赖可以被打包到war 文件的 WEB-INF/lib-provided 目录下，这样这些依赖就不会和外部容器的依赖产生冲突。 

提示： providedRuntime 配置是 Gradle 的compileOnly 配置的首选项。 除了其他限制外， compileOnly 依赖不会进入测试的类路径下，因此任何的基于web 继承的测试都将会失败。 


## 4.3 Packing executable and normal archives (同时打包一个可执行包和一个常规归档包)
默认情况下，当配置了[bootJar] 或者[bootWar] 任务的时候，[jar] 或[war] 任务将会被禁止。 一个项目可以同时构建为一个可执行的归档包和另一个常规的归档包通过允许[jar] 和[war] 任务。 

Groovy 

    jar {
        enabled = true
    }


Kotlin 
    tasks.getByName<Jar>("jar") {
         enabled = true
    }

为了避免可执行的归档包和常规的包被写入到相同的路径下，他们中的一个或者另一个需要被配置使用不同的路径。 实现这一目的的一种方式是配置一个 classifier 。 

Groovy
    bootJar {
        classifier = 'boot'
    }

Kotlin

    tasks.getByName<BootJar>("bootJar") {
          classifier = "boot"
    }



## 4.4 Configuring executable archive packaging (配置可执行归档包)
[BootJar] 和[BootWar] 分别是Gradle 的[Jar] 和[War] 任务的子任务。因此，在打包可执行jar 或者war包的时候，所有标准的配置选项都是可用的。 同时也提供了很多的选项为可执行jars或者war 使用。 


### 4.4.1 Configuring the main class （配置主类）
默认情况下， 可执行归档包的主类会通过在任务的类路径下查询具有 public static void main（String[]） 方法的类来进行自动配置。 

这个 main 类也可以通过任务的 mainClassName 属性来明确地指定: 
Groovy 
    bootJar {
        mainClassName = 'com.example.ExampleApplication'
    }

Kotlin
    tasks.getByName<BootJar>("bootJar") {
         mainClassName = "com.example.ExampleApplication"
    }    

同样的，main 类也可以通过使用SpringBoot 的DSL 属性 mainClass 属性来配置为项目级别。     

Groovy 

    SpringBoot {
        mainClassName = 'com.example.ExampleApplication'
    }

Kotlin 

    springBoot {
         mainClassName = "com.example.ExampleApplication"
    }

如果使用了 application(https://docs.gradle.org/current/userguide/application_plugin.html) 插件, 那么必须配置 mainClassName 项目属性。 并且和上面的作用一样。 

Groovy 
    mainClassName = 'com.example.ExampleApplication'

Kotlin
    application {
  mainClassName = "com.example.ExampleApplication"
}

最后， Start-Class 属性可以在任务额 manifest 目录中进行配置：

Groovy 
    bootJar {
        manifest {
            attributes 'Start-Class':'com.example.ExampleApplication'
        }
    }

Kotlin
    tasks.getByName<BootJar>("bootJar") {
    manifest {
        attributes("Start-Class" to "com.example.ExampleApplication")
        }
    }    



### 4.4.2 Excluding Devtools (排除开发工具)
默认情况下， SpringBoot 的开发者模块 org.springframework.boot:spring-boot-devtools 将会被可执行jar或者war包排除在外。 如果你想要在你的归档集合中包括Devtools ，你需要设置 excludeDevtools 属性为false 。 

Groovy
    bootWar {
        excludeDevtools = false
    }


Kotlin
    tasks.getByName<BootWar>("bootWar") {
        isExcludeDevtools = false
    }


### 4.4.3 Configuring libraries thar require unpacking (配置不需要打包的库）
大部分的库可以嵌套在可以归档包来直接使用，但是一些特殊的库是有问题的。 例如，JRuby 包含他自己的内嵌jar包支持，假设 jruby-complete.jar 可以在文件系统上可以使用。 

为了解决任何有问题的库，一个可执行的归档包可以被配置为当可执行归档被被运行的饿时候，不解压特定的内嵌jars包到指定的临时目录。 Libraries can be identified as requiring unpacking using Ant-style patterns that match against the absolute path of the source jar file:

Groovy

    bootJar {
        requiresUnpack '**/jruby-complete-*.jar'
    }

Kotlin 
    tasks.getByName<BootJar>("bootJar") {
     requiresUnpack("**/jruby-complete-*.jar")
}

For more control a closure can also be used. The closure is passed a FileTreeElement and should
return a boolean indicating whether or not unpacking is required.

### 4.4.4 Making an archive fully executable （制作一个可执行的完整的归档包）
(飞： 通过这种方式得到的j归档包，应该不需要java -jar 命令启动)

SpringBoot 提供了创建完全可执行归档包的支持.  通过提前追加一个shell脚本来创建一个完全的可执行的归档包，这个shell脚本知道如何加载应用程序。 在类unix 平台上，这个加载脚本允许归档包像其他可执行程序或者安装的程序一样直接运行。 

为了使用这个特性，加载脚本必须被允许。 

Groovy 

    bootJar {
        lounchScript()
    }

Kotlin

        tasks.getByName<BootJar>("bootJar") {
            launchScript()
        }

上面的配置将会添加Spring Boot 的默认加载脚本到归档包中。 默认的加载脚本包括一些敏感的默认属性。 可以通过使用properties 属性来定制。 

Groovy
    bootJar {
        launchScript {
            properties 'logFilename' : 'example-app.log'
        }
    }

Kotlin
    tasks.getByName<BootJar>("bootJar") {
         launchScript {
         properties(mapOf("logFilename" to "example-app.log"))
    }
}    

如果默认的加载脚本不能满足你的需求， script 属性可以用来让你定制launch 脚本。 

Groovy 
    bootJar {
        launchScript {
            script = file('src/custom.script');
        }
    }

Kotlin 
    tasks.getByName<BootJar>("bootJar") {
  launchScript {
  script = file("src/custom.script")
  }
}



### 4.4.5 Using the PropertiesLauncher （使用属性加载器）
为了使用功能属性加载器来加载一个可执行的jar包或war包，配置任务的manifest的Main-Class 属性 

Groovy 
    bootWar {
        manifest{
            attributes 'Main-Class': 'org.springframework.boot.loader.PropertiesLauncher'
        }
    }


Kotlin
tasks.getByName<BootWar>("bootWar") {
  manifest {
  attributes("Main-Class" to
"org.springframework.boot.loader.PropertiesLauncher")
  }
}

>>>>>>> 8f91a23439873f58bce0bd124719542c1b4a8520


