# chap_6_Running your application with gradle 
在没有构建一个归档包之前可以使用 [bootRun] 任务来运行你的应用程序。 
[bootRun] 任务是BootRun的一个实例， 而BootRun 是JavaExec 的子类。 因此，在gradle中所有运行 java 进程的常规配置你都可以使用。 这个任务会自动配置来使用你main 资源集合中的类路径。 
默认情况下， 启动类将会自动在任务的类路径下寻找 具有 publish static void main(String[]) 方法的类设置为启动类。 

启动类也可以通过任务的main 属性来专门指定 

Groovy
bootRun {
    main = 'com.example.ExampleApplication'
}

Kotlin 
tasks.getByName<BootRun>("bootRun") {
  main = "com.example.ExampleApplication"
}



同样的， 启动类的名字可以在项目级别使用 SpringBoot 的DSL 语言 mainClassName 属性来指定：

Groovy

    SpringBoot {
        mainClassName = 'com.example.ExampleApplication'
    }

Kotlin
    springBoot {
    mainClassName = "com.example.ExampleApplication"
    }

默认情况下，bootRun 任务将会配置JVM 来优化他的加载来确保在开发环境中快速的启动。 这种表现可以通过使用optimizedLaunch 属性来禁用。 配置如下所示：
Groovy
    bootRun {
        optimizedLaunch = false
    }

Kotlin
    tasks.getByName<BootRun>("bootRun") {
    isOptimizedLaunch = false
    }

如果使用了 application 插件，那么mainClassName 属性必须配置。 

Groovy
    application {
        mainClassName = 'com.example.ExampleApplication'
    }

Kotlin
    application {
    mainClassName = "com.example.ExampleApplication"
    }


## 6.1 Passing arguments to your application (给你的参数传递参数)
和所有的JavaExec 任务一样，可以使用bootRun 的命令行参数 -arge='<arguments>'    来指定参数(这里要求gradle的版本大于等于 4.9 )。  为了使用一个叫做dev的激活文件来运行你的程序，可以使用下面的参数来进行配置：

    $ ./gradlew bootRun --args '--spring.profiles.active=dev'

查看  JavaExec.setArgsStrign 的文档来了解更多的细节 (https://docs.gradle.org/current/javadoc/org/gradle/api/tasks/JavaExec.html#setArgsString-java.lang.String-)


## 6.2 Reloading resources 重新加载资源
如果devtools应用被添加到你的应用中，那么它会自动监听应用程序的改变。 同样的，你可以配置bootRun以便于你的应用从资源的原始位置加载静态资源。 
Groovy
bootRun {
    sourceResources sourceSets.main
}

Kotlin 
tasks.getByName<BootRun>("bootRun") {
  sourceResources(sourceSets["main"])
}


上面的配置可以确保静态资源被运行中的程序动态加载，这对于应用程序的开发是有帮助的。 

