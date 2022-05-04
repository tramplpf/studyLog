# 如何定位线上OOM

[TOC]

## 造成OOM的原因

1. 一次性申请的对象太多，比如一次性从数据库中夹在过多的数据

   解决方案：更改申请对象的数量

2. 内存资源耗尽未释放

   解决方案：找到未释放的对象进行释放

   3. 本身资源不足

      通过 jmap -heap 查看堆信息

      



## 如何快速定位出现OOM的原因





### 模拟OOM现象

整体思路：使用spring-boot编写一个简单的web程序，

场景一复现：在一个方法中，不断的创建一个对象，并且向List中加入，看看什么时候会发生OOM

场景二复现：通过JDBC 多次查询海量数据



1. 编写好的demo，通过 如下命令启动，之前通过浏览器触发：

```shell
java -jar jvmdemo.jar &
```

​         这里通过 & 让java程序在后台运行，而不是一直占用着控制台。在实际生产中，还需要对启动过程中的日志进行重定向。 

2. 启动之后，通过如下命令来插件JVM 运行的堆栈信息

   ```shell
   $> jmap -haap 进程号
   ```

<img src="./pic/001_启动后一些信息获取.png">

通过浏览器触发向list中添加对象的方法

http://127.0.0.1:8080/addObjs





## 解决方案

方案一：启动时添加相关参数，在发生OOM的时候导出堆信息，启动程序的命令如下

```shell
$> java -Xms10M -Xmx10M -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=./jvm_logs/ -jar jvm-demo-0.0.1-SNAPSHOT.jar &
```

这里要注意： heap文件导出的路径应该存在，并且有访问权限，否则导不出相关的文件。 



<img src="./pic/003_添加jvm参数后发生oom时的情景.png">



使用 jvisualvm 命令查看导出的Dump文件 



<img src="./pic/005_jvisualvm命令启动程序的界面.png">



<img src="./pic/006_借助工具分析dump文件.png">



<img src="./pic/008_dump文件分析.png" alt="dump文件分析">



<img src="./pic/009_定位发生OOM问题的代码.png">







## 验证环境

<img src="./pic/004_运行时相关的java环境.png">



## 学习过程中遇到的问题：

1. 启动的时候添加参数异常

   <img src="./pic/003_模拟过程中遇到的问题_v20220310.png">



2. 分析Dump文件的软件异常

   <img src="./pic/007_使用jvm工具查看dump报错.png">

​					   解决方案：启动时指定堆的最大内存

​						$> jvisualvm -J-client -J-Xmx1024m 

