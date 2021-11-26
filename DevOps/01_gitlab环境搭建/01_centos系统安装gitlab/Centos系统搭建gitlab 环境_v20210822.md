# Centos系统搭建gitlab 环境



## 前期准备

### 升级Centos系统

如果搭建gitlab的centos系统之前没有安装 过其他的软件，则可以大胆的对centos系统进行升级

如果之前安装过其他的环境，则需要经过认真的评估来决定是否进行升级

yum update 



### 升级Git 

centos系统默认安装的GIt 版本比较低，所以需要安装最新版本的git 

通过在如下网站找到最小的git 安装软件源码包

https://git-scm.com/download/linux



![image-20210822181857472](C:\Users\lpf\AppData\Roaming\Typora\typora-user-images\image-20210822181857472.png)





点进去之后，找到最新的git的版本号，并且通过右键获取其在网上的位置

https://mirrors.edge.kernel.org/pub/software/scm/git/git-manpages-2.9.5.tar.xz 

https://mirrors.edge.kernel.org/pub/software/scm/git/git-2.9.5.tar.xz

https://mirrors.edge.kernel.org/pub/software/scm/git/git-htmldocs-2.9.5.tar.xz



这里可以获取到git源码的安装包，以及html帮助文档的安装包，以及man 帮助文档的安装包



之后在centos系统通过wget 下载最新的git的源码  

git-manpages-2.9.5.tar.xz  





#### 卸载老版本的git

git version 查看centos 系统默认安装的版本如下：

<img src="D:\04github\tramplpf\studyLog\02DevOps\01_gitlab环境搭建\01_centos系统安装gitlab\pic\002_查看git的版本_20210822.png" alt="&quot;查看git的版本号&quot;" style="zoom:50%;" />

####  

yum remove git  删除老版本的git

![](D:\04github\tramplpf\studyLog\02DevOps\01_gitlab环境搭建\01_centos系统安装gitlab\pic\004_通过yum_remove移除老版本的git_v20210822.png)







#### 通过源码安装最新版本的git 

安装依赖包

yum install curl-devel expat-devel gettext-devel openssl-devel zlib-devel asciidoc

yum install gcc perl-ExtUtils-MakeMaker



解压缩   git-manpages-2.9.5.tar.xz 

切换到git-2.9.5  目录下

1> 执行如下的命令，设置全局安装路径

make prefix=/usr/local/git all



2> 执行如下命安装git 

make prefix=/usr/local/git install 

3> 配置PATH 环境变量

echo "export PATH=$PATH:/usr/local/git/bin" >> /etc/profile

4> 刷新profile 让配置生效

source /etc/profile 





## 安装Gitlab 

1》 安装相关的依赖

yum install -y curl openssh-server openssh-clients postfix cronie policycoreutils-python patch 



2》启动postfix ，并设置为开机启动

systemctl start postfix

systemctl enable postfix 



#### 下载最新版本的gitlab-ce 软件

访问 https://packages.gitlab.com/gitlab/gitlab-ce 

查看当前可以访问的最新版本的软件

通过如下命令下载最新版本的git 



通过如下命令下载最新的gitlab 

``` 
curl -s https://packages.gitlab.com/install/repositories/gitlab/gitlab-ce/script.rpm.sh | sudo bash
```



之后通过

yum install gitlab-ce 来安装最新的gitlab-ce 版本



#### 修改gitlab 的配置文件

编辑文件  /etc/gitlab/gitlab.rb  

修改  external_url 的值，修改为自己的机器地址

external_url="http://192.168.64.129"



#### 加载配置 

gitlab-ctl reconfigure 

这个过程会比较耗时，如果执行报错，那么重启即可。 



上面的命令执行结束之后，需要关闭centos系统的防火墙

systemctl stop firewalld 





#### gitlab 初始化root 账号的密码



gitlab-rails console production 







在linux 系统上，新建立一个gitlab 用户，后续对gitlab的维护都通过这个用户来维护，而不是root用户。

useradd gitlab 

passwd gitlab 





## GItlab 还需要深入了解的内容

* GItlab 使用QQ邮箱来发送邮件
* 



## GItlab 的使用

权限等级分三种：

- Private 私有的，只有你自己或者组内的成员能访问
- Internal 所有登录的用户
- Public 公开的，所有人都可以访问
- 





GItlab 还需要解决的问题

* gitlab 通过登录页面注册了的用户，无法登陆到gitlab 
* 





## 出现的问题



 

yum install readline* 

yum install ruby





执行gitlab-rails console production 命令重置root密码报错







gitlab 安装好之后，相关的日志信息会记录在 /var/log/gitlab 目录下。 







## 参考

gitlab 的帮助文档

https://docs.gitlab.com/ee/administration/index.html  

社区版本的帮助文档

https://docs.gitlab.com/ce/administration/index.html









