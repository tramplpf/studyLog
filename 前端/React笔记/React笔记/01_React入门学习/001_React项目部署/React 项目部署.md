# React 项目部署

React 项目部署的方式有多种，下面将逐步介绍自己熟知的几种部署方式

第一篇React系列就介绍React的部署，主要是因为简单，容易操作。 



## 

为了让代码可操作性。 这里部署的React项目使用最简单的一个React项目来部署。 

## 创建React项目

安装之前，相关环境的搭建就不详细介绍了，网上资料很多

通过如下命令创建一个React 项目。 

```shell
$ npm create-react-app helloreact
```

效果如下：



<img src="/Users/lpf/github/studyLog/React笔记/React笔记/01_React入门学习/001_React项目部署/002_npx命令创建react项目.png" alt="002_npx命令创建react项目" style="zoom:50%;" />

<img src="/Users/lpf/github/studyLog/React笔记/React笔记/01_React入门学习/001_React项目部署/003_react项目创建成功的标志.png" alt="react项目创建成功的标志" style="zoom:40%;" />



之后，按照提示信息，切换到 helloreact目录下，并且执行 npm start 

为了保证我们部署如果出错不是react项目本身的问题，我们先按照图中显示先启动一下React项目，效果如下，则说明react项目可以正常访问。我们也就可以将该项目用户部署。 

<img src="/Users/lpf/github/studyLog/React笔记/React笔记/01_React入门学习/001_React项目部署/004_验证创建的React项目是否可以正常访问.png" alt="验证react项目可以正常访问" style="zoom:30%;" />

项目已经创建好了，接下来我们可以将创建好，且可以正常运行的React项目进行部署了。 

部署方式有多种，这里将一一介绍。

## 通过node的静态服务来部署

通过如下命令来安装静态服务器

```shell
$ > npm install -g serve
```

这里的-g 说明是全局安装，这样之后部署其他React项目的时候，就不在需要重新下载安装了。 



005_通过npm安装serve服务器.png

通过如下命令来打包react 项目部署包

```shell
$> npm run build
```

<img src="/Users/lpf/github/studyLog/React笔记/React笔记/01_React入门学习/001_React项目部署/006_打包React项目.png" alt="打包React项目" style="zoom:40%;" />



打包之后，通过如下命令运行server 服务

```shell
$ serve -s build  -l 8080  007_通过serve命令来运行react项目.png
```

这里要注意，需要通过-l 来指定端口号，如果不指定，访问的端口号默认是3000

效果如下

<img src="/Users/lpf/github/studyLog/React笔记/React笔记/01_React入门学习/001_React项目部署/007_通过serve命令来运行react项目.png" alt="通过serve命令来运行react项目" style="zoom:50%;" />

我们也可以通过 serve -s 来指定build 目录的绝对路径的方式来启动react项目。

相关命令如下

```shell
$> serve -s /opt/program/react/study/helloreact/build -l 8080
```

<img src="./008_通过指定build绝对路径的方式来启动react项目.png" alt="通过指定build绝对路径的方式来启动react项目" style="zoom:42%;" />

#### 在Ubuntu系统中通过serve部署React项目

先通过zip 命令将react项目中的build文件夹打包，相关命令如下

```shell
$> zip build.zip build
```

这里之所以要通过zip命令打包成zip 包，主要是因为在centos或者ubuntu系统中zip 软件默认是安装好的。

接下来将build.zip 包上传到linux系统。这里选择的是ubuntu系统。我这里通过scp 命令来在两个系统之间传输文件。 相关命令如下







## 修改记录

| 类型 | 时间                   | 内容                                    |
| ---- | ---------------------- | --------------------------------------- |
| 创建 | 2021年11月25日20:09:31 | 使用node的静态服务器来静态部署React项目 |
|      |                        |                                         |
|      |                        |                                         |