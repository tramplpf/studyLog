# Git图形界面工具的安装和使用

Git 我推荐使用的图形界面工具是  tortoisegit， 可以从它的官方 https://tortoisegit.org/ 下载最新的版本。 

使用这个图形界面的原因是因为git图形界面，进行图形界面操作的时候，会提示相关的底层命令，这样有助于自己对Git的深入学习。 



软件

* TortoiseGit-2.14.0.1-64bit.msi



## 安装

###  规划

安装在 D:\01software\Git\tortoisegit  目录下，和Git基本软件安装在一起。  

 其中 D:\01software\Git\GIT下安装的是git的基本软件。 



### 安装

**安装 TortoiseGit，必须先安装完成 git并将其配置好。**



软件的信息

<img src="./pic/04_Git图形界面软件的相关证书_20230702144138.jpg"/>



#### 1. 配置信息的配置

1. 双击软件安装包

<img src="./pic/01_双击软件包_20230702134838.png" align="left"/>

阅读软件使用协议来了解大概的约束信息。 

<img src="./pic/02_软件协议的核心内容_20230702135140.png" align="left" />



选择一种ssh客户端软件

<img src="./pic/03_选择一种ssh客户端_20230702135328.png" align="left"/>

选择好ssh客户端之后，依然可以在安装好之后，进行调整。 如下图(安装好后可配置)

选择项目--右键--settings： 

<img src="./pic/30_指定ssh的客户端_20230702153139.png" width="80%" align="left"/>





修改软件的安装路径，和上面规划的安装路径保持一致

<img src="./pic/05_修改软件安装默认路径的路口_Browse_20230702135627.png" align="left"/>



<img src="./pic/04_修改git的客户端软件_20230702135525.png" align="left"/>



#### 2. 准备安装

<img src="./pic/06_准备安装_20230702135727.png" align="left" />





<img src="./pic/07_开始安装_20230702135902.png" align="left"/>





<img src="./pic/08_安装完成_20230702140019.png" align="left"/>

​     已经将相关的changelog保存到该文档的同级目录下。 相关的changelog 也可以在软件安装后的目录下找到。 



#### 3. 初次使用时的配置

<img src="./pic/09_初次使用TortoiseGit进行配置_20230702140232.png" align="left"/>

 



<img src="./pic/10_初次使用给我们提供的帮助文档_20230702141541.png" align="left"/>

通过这个页面我们在tortoise官网找到了一些官方文档(PDF版本)，放在该文档的同级目录下。 



<img src="./pic/11_验证和git是否匹配_20230702141646.png" align="left"/>





<img src="./pic/12_配置用户名和密码来完善commit信息_20230702141900.png" align="left"/>



<img src="./pic/13_两种登录凭证的配置_20230702142117.png" align="left" />





<img src="./pic/14_配置ssh登录时的凭证_20230702142153.png" align="left"/>



<img src="./pic/15_01_开始生成ssh登录的凭证_20230702142219.png" align="left"/>



**注意：** 使用的时候，需要在空白区域移动鼠标，否则会卡主不动



<img src="./pic/16_生成一个秘钥对_20230702142404.png" align="left"/>





### 验证

验证软件是否安装成功。 

在桌面 右键 查看，如果出现如下效果，则说明安装成功。 

<img src="./pic/20_验证软件是否安装成功_20230702144415.jpg" width="50%" height="50%" align="left"/>

如果出现了 Git Clone ，Git Create repository here， TortoiseGit 则说明安装成功。 



更新代码

<img src="./pic/17_验证_拉取代码_20230702144704.png" align="left"/>



## 配置

如果希望使用putty的ssh客户端，则需要配置对应的ppk秘钥，使用puttygen来进行配置。

<img src="./pic/20_使用putty来生成ppk登录凭证_20230702145204.png" align="left"/>



如果直接使用git自带的ssh客户端，则直接使用ssh-keygen 来生成秘钥就可以。 



## 帮助文档

tortossegit 官方提供的帮助连接  https://tortoisegit.org/support/

