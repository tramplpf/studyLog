# Chapter 5. Publishing your application (发布你自己的应用)




## 5.1 Publishing with the maven plugin (使用maven 插件来公布)

当mavne 插件(https://docs.gradle.org/current/userguide/maven_plugin.html) 被应用的时候，an Upload task for the bootArchives configuration named uploadBootArchives is automatically created。  默认情况下， bootArchives 配置包含 bootJar 或者bootWar 任务提供的压缩包。  [uploadBootArchives] 任务可以被配置成发布压缩包到maven仓库。 


Groovy 

    uploadBootArchives {
        repositories {
            mavenDeployer {
                repository url: 'http://repo.example.com'
            }
        }
    }

Kotlin 

    tasks.getByName<Upload>("uploadBootArchives") {
    repositories.withGroovyBuilder {
    "mavenDeployer" {
    "repository"("url" to "https://repo.example.com")
    }
    }
    }




## 5.2 Publishing with the maven-publish plugin(使用maven-publish 插件来发布)
为了发布你springBoot 应用的jar包或者war包， 在MavenPublication 配置中，使用artifact 方法。 将生成压缩包的任务作为参数传递给artifact 方法。 
例如，为了发布bootJar 任务生成的归档宝：使用下面的配置

Groovy

    publishing {
        publications {
            bootJava(MavenPublication){
                artifact bootJar
            }
        }
    }
    repositories {
        maven {
            url 'https://repo.example.com'
        }
    }

Kotlin
publishing {
  publications {
  create<MavenPublication>("bootJava") {
  artifact(tasks.getByName("bootJar"))
  }
  }
  repositories {
  maven {
  url = uri("https://repo.example.com")
  }
  }
}



## 5.3 Distrubuting with the application plugin（使用 application 插件来分发）
当 application 插件被应用的时候， 一个叫做boot的分发任务会被应用。这个分法包中包含bootJar或者bootWar 生成的归档包以及在类unix系统和windows 系统上面生成的加载脚本。  可以使用 [bootDistZip] 任务和 [bootDistTar] 任务来分别构建zip包和tar包。 为了使用application 插件，它的mainClassName属性必须指定为你应用程序的启动类。 