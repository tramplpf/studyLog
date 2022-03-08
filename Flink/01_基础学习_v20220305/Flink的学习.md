# Flink 的学习

## Flink集群环境的搭建

Flink的下载地址： https://flink.apache.org/downloads.html

下载的软件下载Flink1.12.7 以及Pre-bundled-Hadoop2.8.3 两个软件。其中Pre-bundled-Hadoop2.8.3 是Flink和Hadoop进行交互的一个中间件。 2.8.3版本是可以和Hadoop3进行交互的。 

实验环境和前置软件

​		实验环境：准备三台服务器，预装Centos7 操作系统，在/etc/hosts 文件中分配配置机器名hadoop01，hadoop02，hadoop03。 IP地址不重要，因为集群都会通过机器名来进行配置。三台服务器需要配置时间同步。 

​		前置安装的软件： JDK8， Hadoop3.2.2 版本（搭建yarn集群时需要）。 Zookeeper 采用3.5.8 版本（Flink内置来zookeeper，在优化部署时通常还是采用外置的zookeeper）。



### Standalone 模式搭建Flink集群

Standalone 模式的官方指导文件：

https://nightlies.apache.org/flink/flink-docs-release-1.12/

https://nightlies.apache.org/flink/flink-docs-release-1.12/deployment/resource-providers/standalone/

 也可以通过如下地址访问最新的访问地址：

https://nightlies.apache.org/flink/flink-docs-stable/























