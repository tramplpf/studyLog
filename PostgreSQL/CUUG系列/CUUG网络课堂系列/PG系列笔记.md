从零学PostgreSQL

## 第一讲 PostgreSQL简介
### Objectives
* PostgreSQL特点
* PostgreSQL版本介绍
* PostgreSQL学习资源
* PostgreSQL客户群分布
* PostgreSQL软件下载
* 基于PostgreSQL国产数据库


PostgreSQL特点
<img src="./pic/01_PG的特点.png">

极限值：
<img src="./pic/02_PG的特点_极限值.png">

众多功能和标准兼容性
<img src="./pic/03_PG的特点_众多功能和标准兼容性.png">


<img src="./pic/04_PG的特点_高度可定制性.png">


PostgreSQL学习资源
<img src="./pic/05_PG的学习资源.png">

PG的客户群
<img src="./pic/06_PG的客户群.png">

 <img src="./pic/07_基于PostgreSQL的国产数据库.png">

 

## 第二和第三讲PG安装和PG建库

### Objectives
* 创建用户与环境配置
* 系统内核参数配置
* PostgreSQL安装

<img src="./pic/02PG安装/01_用户与环境配置.png">

安装的时候，不要使用root用户安装，而是使用pg用户来进行安装。 

useradd 命令新增用户的时候，不指定用户组的情况下，用户默认的用户组和用户名一样么？


<img src="./pic/02PG安装/02_内核参数配置.png">
内核参数配置与否，不会影响PG数据库的安装，但是会影响后续PG数据库运行的性能。 


<img src="./pic/02PG安装/03_安装方式.png">


<img src="./pic/02PG安装/04_依赖包检查.png">

依赖包检查的命令
```shell
  rpm -qa | grep gcc 
```

<img src="./pic/02PG安装/05_源代码安装.png">

<img src="./pic/02PG安装/06_配置可选项.png">

<img src="./pic/02PG安装/07_编译可选项.png">


## 第三讲PG数据库的创建
### Objectives
* 创建PostgreSQL数据库
* 启动与关闭PostgreSQL数据库
* 使用PostgreSQL数据库

<img src="./pic/03PG建库/01_创建数据库集簇.png>
initdb 的-W选项： 提示你创建postgres超级管理员的秘密。



## 第四讲：PG实例结构
### Objectives
* PostgreSQL实例简介
* PostgreSQL初始化参数文件
* PostgreSQL内存结构
* PostgreSQL后台进程

<img src="./pic/04PG实例结构/01_PG实例结构.png">


* 建立一个连接和创建一个会话.png
  * 两个进程之间建立连接
  * 建立连接之后，在pg的服务器端，创建一个会话
<img src="./pic/04PG实例结构/02_建立一个连接和创建一个会话.png">




* 初始化参数文件
<img src="./pic/04PG实例结构/04_初始化参数文件.png">



