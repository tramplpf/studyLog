# IMBWebSphere消息队列配置_V20220909.md



## 配置队列管理器等

<img src="./pic/01_IMB客户端配置_V20220909.png" align="left">



### 新建队列管理器

<img src="./pic/02_新建队列管理器01.png" align="left">



②指定队列管理器的名称

<img src="./pic/03_新建队列管理器02.png" align="left">

<img src="./pic/03_新建队列管理器03.png" align="left">



③为队列管理器设置监听的端口

最好是一开始就规划好端口的取值，目前还不知道在创建后如何修改监听的端口号

<img src="./pic/06_指定队列管理器监听的端口号.png" align="left">



<img src="./pic/09_新建队列管理器06.png" align="left">



### 新建服务器连接通道

<img src="./pic/10_新建服务器连接通道.png" align="left">



指定服务器连接通道的名称

名称可以重复

<img src="./pic/10_新建服务器连接通道_指定服务器连接通道的名称.png" align="left">



设置服务器连接通道的属性

目前都是保持默认值

<img src="./pic/12_设置服务器连接通道的属性-MCA.png">



<img src="./pic/12_设置服务器连接通道的属性-SSL.png" aling="left">



<img src="./pic/12_设置服务器连接通道的属性-常规.png" align="left">



<img src="./pic/12_设置服务器连接通道的属性-出口.png" align="left">



<img src="./pic/12_设置服务器连接通道的属性-扩展.png" align="left">



<img src="./pic/12_设置服务器连接通道的属性-统计信息.png" align="left">



新建好的服务器连接通道如下

<img src="./pic/13_新建好的服务器连接通道.png" align="left">



<img src="./pic/14_通道的启动.png" align="left">



### 创建本地队列

无论是接收队列还是发送队列，在IBM MQ中都需要创建对应的本地队列

<img src="./pic/15_新建本地队列.png" align="left">



<img src="./pic/16_为ibm的发送队列创建本地队列.png" align="left">

为本地队列设置属性

<img src="./pic/17_为本地队列设置属性_常规.png" align="left">

<img src="./pic/17_为本地队列设置属性_触发.png">

<img src="./pic/17_为本地队列设置属性_存储器.png" align="left">



<img src="./pic/17_为本地队列设置属性_集群.png" align="left">



<img src="./pic/17_为本地队列设置属性_扩展.png" align="left">



<img src="./pic/17_为本地队列设置属性_事件.png" align="left">

<img src="./pic/17_为本地队列设置属性_统计信息.png" align="left">



## 遇到的问题



1. ### 2035： MQRC_NOT_AUTHORIZED 

<img src="./pic/18_连接过程遇到的问题.png">

在控制台执行如下命令

```bash
$> RUNMQSC QM.AIM02.TEST（队列管理器名称）
   ALTER QMGR CHLAUTH(DISABLED)
```



<img src="./pic/19_为队列管理器授权_01.png">

<img src="./pic/19_为队列管理器授权_02.png">