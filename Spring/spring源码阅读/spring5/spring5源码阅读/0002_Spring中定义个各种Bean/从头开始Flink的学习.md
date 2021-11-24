# 从头开始Flink的学习



## 环境搭建

```shel
curl https://flink.apache.org/q/quickstart-scala.sh | bash -s 1.6.3
```



之后当前路径下有一个quickstart项目，进入之后执行

```shell
$%> mvn clean package 
```

报错：



解决方案：

在pom文件中的scala-maven-plugin插件下面加入一个参数：

```pom.xml
<configuration>
		<args>
    		<arg>-nobootcp</arg>
    </args>
</configuration>
```

-nobootcp 参数解释：

-nobootcp or --no-boot-class-path： Do not use the boot classpath for the scala jars. 





