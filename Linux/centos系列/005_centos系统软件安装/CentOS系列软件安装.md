# CentOS系列软件安装



## 方式一：通过yum从远程安装

查看某一个命令在哪个软件包中。 下面查看ifconfig命令在哪个软件包中

```yum
$> yum search all ifconfig
```



## 方式二：通过rpm安装本地的rpm软件包

```shell
1. 安装
$> rpm -ivh  rpm安装包的名称

2. 卸载
$> rpm -e rpm的名称
$> rpm -e rpm的名字 --nodeps （强制卸载）

3. 查看哪些软件是rpm安装的
rpm -qa 
这个命令可以查询到所有的，使用rpm安装包安装过的软件的名字，如果想删除的话，直接使用这个名字删除即可

4. 查看某个服务是否安装
$> rpm -qa | grep jdk
```

