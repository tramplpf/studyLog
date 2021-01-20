# chap_8_Reacting to other plugins(对其他插件做出响应)
当其他的插件被应用的时候，SpringBoot 的插件会对项目的配置做出不同的变化。 这一部分描述这些变化。 

## 8.1 Reacting to the Java plugin (响应java插件)
当Gradle的java 插件被应用到项目中的时候，Spring boot 的插件将会：
1.  创建一个叫做 [bootJar] 的BootJar 任务，这个任务将会为项目创建一个可执行的，胖的jar包。 这个jar包将会包含在运行时类路径下的所有文件；类文件将会打包进 BOOT-INF/classes 路径下，而依赖的jar包将会打包进 BOOT-INF/lib 目录下。 

2. 配置[assemble]任务依赖于[bootJar]任务
3. 禁止 [jar]任务
4. 创建一个叫做bootRun的BootRun的任务，这个任务可以运行你的程序。
5. 创建一个叫做bootArchives的配置项，这个配置项包含了bootJar 任务生成的artifact 
6. 配置所有的javaCompile 任务的编码为UTF-8 
7. 配置所有的javaCompile 任务使用--parameters 编译参数

## 8.2 Reacting to the Kotlin plugin 
当 gradle 的kotlin 插件被应用的时候，SpringBoot插件将会
1. Aligns the Kotlin version used in Spring Boot’s dependency management with the version of the
plugin. This is achieved by setting the kotlin.version property with a value that matches the
version of the Kotlin plugin.
2. Configures any KotlinCompile tasks to use the -java-parameters compiler argument


## 8.3 Reacting to the war plugin （对 war 插件做出响应）
当Gralde 的war插件被应用的时候，SpringBoot 插件将会：
1. 创建一个叫做bootWar的BootWar任务实例，bootWar 将会为你的项目创建一个可执行的，胖的jar包。 对于标准的包结构，在 providedRuntime 配置中的所有内容都会打包到 WEB-INF/lib-provided 里面。 
2. 配置assemble任务依赖于bootWar 任务 
3. 禁用war 任务
4. 配置bootArchives 配置项来包含bootWar任务生成的artifact 。 

## 8.4 Reacting to the dependency management plugin 
当 io.spring.dependency-management 插件(https://github.com/spring-gradle-plugins/dependency-management-plugin)被应用到你的项目中时， SpringBoot插件将会自动导入spring-boot-dependencies 清单文件(bom)


## 8.5 Reacting to the application plugin （对application 插件做出响应）
当gradle 的application 插件被应用的时候，springBoot 的插件将会:
1. Creates a CreateStartScripts task named bootStartScripts that will create scripts that launch the artifact in the bootArchives configuration using java -jar. The task is configured to use the applicationDefaultJvmArgs property as a convention for its defaultJvmOpts property
2. 创建一个叫做boot的发行包，该发型包在它的lib路径下包含 bootArchives 配置并且在它的bin 路径下包含它的启动脚本
3. 配置bootRun 任务使用mainClassName的属性值作为它的main 属性的属性值。 
4. 配置bootRun 任务使用 applicationDefaultJvmArgs属性的取值作为bootRun任务的jvmArgs的属性值
5. 配置bootJar 任务在它的manifest中的Start-Class 的取值使用mainClassName的属性值
6. 配置bootWar 任务在它的manifest中的Start-Class 的取值使用mainClassName的属性值


## 8.6 Reacting to the maven plugin (对maven 插件做出响应)
当gradle 的maven 插件应用到你的项目中时，SpringBoot 插件将会配置一个 uploadBootArchives Upload 任务来确保springboot 插件生成的pom文件中没有任何的依赖。 

