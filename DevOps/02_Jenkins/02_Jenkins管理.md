

# Jenkins的使用

## 安装

### Mac系统安装

通过brew命令进行管理 

* 安装Jenkins的稳定版本： brew install jenkins-lts

* 启动安装的Jenkins稳定版 brew services start jenkins-lts
* 重启Jenkins稳定版： brew services  restart jenkins-lts
* 更新Jenkins的版本： brew upgrade jenkins-lts

### 通用安装

从如下地址

https://www.jenkins.io/download/ 

下载最新的jenkins的war包。

之后通过 java -jar jenkins.war  命令来启动Jenkins







### Jenkins 忘记密码

进入 Jenkins主目录，备份 config.xml 

修改config.xml 文件

找到关键字 usesecurity，把取值true设置为false。 

重启jenkins。

mac下重启jenkins的命令如下：

```shell
$> brew services restart jenkins-lts
```

之后，就可以无账号和密码登录Jenkins了。 



## 修改Mac系统下Jenkins开机自启的一些参数



修改 /Users/lpf/Library/LaunchAgents 路径下，homebrew.mxcl.jenkins-lts.plist 文件中的参数，相关内容如下。

<img src="./pic/001_修改开机自启时jenkis的相关配置.png">



<img src="./pic/002_jenkins默认启动命令.png">



其他图示：

<img src="./pic/003_mac系统修改jenkins的启动端口号.png">



## Jenkins的使用

### 微服务项目

1. 首先在主页面创建一个视图，用于管理多个构建任务

   如下图：

   ![001_创建一个视图来管理多个任务_v20220323](./pic/001_jenkins的简单使用/001_创建一个视图来管理多个任务_v20220323.png)

![002_创建一个视图来管理多个任务_v20220323](./pic/001_jenkins的简单使用/002_创建一个视图来管理多个任务_v20220323.png)

![003_维护创建好的视图_v20220323](./pic/001_jenkins的简单使用/003_维护创建好的视图_v20220323.png)

1. 创建好视图之后，可以对创建任务

   

   

   ![101_准备新建任务_v20220323](./pic/001_jenkins的简单使用/101_准备新建任务_v20220323.png)

   

   

   ![102_指定任务的名称和任务的类型_v20220323](./pic/001_jenkins的简单使用/102_指定任务的名称和任务的类型_v20220323.png)

   

   

   

   ![103_自由风格的任务我们可以配置那些内容_v20220323](./pic/001_jenkins的简单使用/103_自由风格的任务我们可以配置那些内容_v20220323.png)

   

   

   **General**

   

   ![104_a_v20220323](./pic/001_jenkins的简单使用/104_a_v20220323.png)

   

   ![image-20220323231950326](./pic/001_jenkins的简单使用/105_b_v20220323.png)

​				**源码管理**

​	

![106_源码管理_v20220323](./pic/001_jenkins的简单使用/106_源码管理_v20220323.png)



<img src="./pic/001_jenkins的简单使用/107_源码管理之凭证管理_v20220323.png" alt="107_源码管理之凭证管理_v20220323" style="zoom:50%;" />



​			   **构建触发器**

​				**构建环境**

​				**构建**

![108_构建_v20220323](./pic/001_jenkins的简单使用/108_构建_v20220323.png)

<img src="./pic/001_jenkins的简单使用/109_指定执行构建后的操作_v20220323.png" alt="109_指定执行构建后的操作_v20220323" style="zoom:50%;" />





​				**构建后操作**







## 不足之处

1. mac系统下通过brew 没有卸载的操作
2. 























