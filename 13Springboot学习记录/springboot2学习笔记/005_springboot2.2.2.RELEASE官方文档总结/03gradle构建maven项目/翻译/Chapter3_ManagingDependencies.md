# Chapter 3. Managing dependencies(依赖管理)

当你使用 "io.spring.dependency-management" 插件的时候，springboot 的插件将会自动导入来自指定版本的 Spring Boot 的 spring-boot-dependencies 的清单文件。 它(springboot的插件)提供了一个被maven 用户所一致的依赖管理的方式。 
例如，当你声明了在bom 文件中管理的依赖的时候，它允许你忽略这些依赖的版本号，为了使用这个功能，一常规的方式简单的声明依赖，但是可以回来版本号。 

Groovy 

    dependencies {
        implementation 'org.springframework.boot:spring-boot-starter-web'
        implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    }


Kotlin

    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-web")
        implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    }

## 3.1 定制管理版本

当依赖管理插件被用来开工至依赖的版本的时候，spring-boot-dependencies 清单文件会自动导入。 请参考 清单文件bom (https://github.com/spring-projects/spring-boot/blob/v2.2.2.RELEASE/spring-boot-project/spring-boot-dependencies/pom.xml) 来获取这些属性的完整列表 


为了管理一个被管理的版本，你需要设置它的正确的属性。 例如，为了定制 SLF4J 的版本，它的版本号被 slf4j.version 属性管理。 

Groovy 

    ext['slf4j.version'] = '1.7.20' 

Kotlin
    extra["slf4j.version"] = "1.7.20"


提示： 每一个Spring Boot 的版本都被设计和反复测试了一些列的第三方的依赖。 覆盖版本可能会导致兼容性问题，应该谨慎修改。 


## 3.2 Using Spring Boot's dependency management in isolation (单独的使用SpringBoot 的依赖管理)

可以不通过向SpringBoot 项目中添加springboot 的插件来单独的使用SpringBoot 的依赖管理。 SpringBootPlugin 类提供了一个BOM_COORDINATES 常量用来在不知道 group ID, artifact ID, 或者 version 的情况下导入清单文件(BOM). 

首先配置你的项目依赖于SpringBoot 插件但是不应用springboot 插件。 

Groovy 

    plugins{
        id 'org.springframework.boot' version '2.2.2.RELEASE' apply false
    }

Kotlin
    plugins {
        id("org.springframework.boot") version "2.2.2.RELEASE" apply false
    }

SpringBoot 的插件依赖于依赖管理的插件意味着，你可以使用依赖管理的插件，但是不需要声明对他的依赖。 这同样意味着，你可以向Spring Boot 用户一样自动化的使用相同的版本管理插件。

应用依赖管理插件(dependency management plugin) 并且配置它实现Spring Boot 的bom：

Groovy 

    apply plugin: 'io.spring.dependency-management'
    dependencyManagement {
        imports {
            mavenBom org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES
        }
    }

Kotlin 
    apply(plugin = "io.spring.dependency-management")
    the<DependencyManagementExtension>().apply {
    imports {
            mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
        }
    }

The Kotlin code above is a bit awkward. That’s because we’re using the imperative way of applying
the dependency management plugin.

We can make the code less awkward by applying the plugin from the root parent project, or by
using the plugins block as we’re doing for the Spring Boot plugin. A downside of this method is that
it forces us to specify the version of the dependency management plugin:

plugins {
  java
  id("org.springframework.boot") version "2.2.2.RELEASE" apply false
  id("io.spring.dependency-management") version "1.0.8.RELEASE"
}
dependencyManagement {
  imports {
mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
  }
}


## 3.3 Learining more 了解更多
为了了解更多关于依赖管理插件的兼容性，请参考  https://github.com/spring-gradle-plugins/dependency-management-plugin/blob/master/README.md 
