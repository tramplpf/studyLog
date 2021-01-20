# Chapter4_Packaging executable archives (打包可执行的包)

这个插件可以打包可执行的压缩包(jar文件或者war文件)。 这些压缩包包含应用程序的所有依赖并且可以通过 java -jar 命令来运行它。 

 ## 4.1 Packaging executable jars (打包可执行的jars包)
 可以使用 <bootJar> 任务来构建可执行的jar包。 当[war] 插件被应用的时候，这个任务将会被自动创建，并且这个任务是BootWar的实例。 <assemble> 任务依赖于 <bootWar> 任务,因此运行<assemble>(或者<build>)r任务的时候也运行<bootWar> 任务。 

 ## 4.2 Packing executable wars(打包可执行wars包) 
 可以使用<bootWars> 任务来打包可执行的war包。当应用[war]插件的时候<bootWars>任务会被自动创建这个任务是BootWar的实例。 <assemble>任务依赖于<bootWar>任务，因此在运行<assemble>(或者<build>)任务的时候也会运行<bootWar> 任务。

### 4.2.1 Packing executable and deployable wars (打包可执行可部署的war包)
一个war文件可以打包成一个可以通过 java -jar 命令执行的可执行包，并且它依赖于一个外部的容器。 为了得到这样的可执行war包。 必须向providedRuntime 配置项中添加一个内嵌容器依赖的。 配置内容如下：

Groovy

    dependencies {
        implementation 'org.springframework.boot:spring-boot-starter-web'
        providedRuntime 'org.springframework.boot:spring-boot-starter-tomcat'
    }

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


