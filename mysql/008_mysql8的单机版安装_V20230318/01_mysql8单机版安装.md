# mysql8单机版安装


## 系统环境检查
安装之前，需要将系统自带的mysql或者mariadb数据库删除掉。并且删除/etc/my.cnf （/etc/my.cnf.rpmsave）文件

执行如下命令查看相关的mysql或者mariadb的rpm包
```shell
   # 这里grep的-i 选项忽略大小写
   $> rpm -qa | grep -i mysql
   $> rpm -qa | grep -i mariadb 
```
如果上面查询出来有数据显示，通过rpm -e 将相关的rpm包进行删除
```shell
   $> rpm -e xxx 
```

卸载相关软件之后，还需要将/etc/my.cnf 文件删除(该文件可能在mysql或mariadb删除过程中被重命名)


## 软件包下载
先通过如下命令下载lrzsz软件包来进行文件上传和下载(也可以不借助该工具，通过其他方式进行上传或下载)

```shell
  yum install lrzsz 
```
mysql8安装包下载地址： https://dev.mysql.com/downloads/mysql/
下载mysql8的tar包： mysql-8.0.32-el7-x86_64.tar.gz
*  将mysql安装包解压   
      tar -xzvf mysql-8.0.32-el7-x86_64.tar.gz -C ../
*  创建mysql用户
```shell
   $> useradd mysql8
   $> passwd mysql8
```
   通过如上的命令创建的mysql8用户所属的用户组也是mysql8。 而不需要手动创建mysql8用户组。 

* 创建数据目录(通过mysql用户)
  mkdir -p /opt/mysql8/data/mysql8 

* 编辑 ～/.bash_profile 文件
   export MYSQL_HOME=/opt/mysql8/mysql-8.0.32
   export PATH=$MYSQL_HOME/bin:$PATH
* 编辑/etc/my.cnf（使用root用户进行编辑）
   /etc/my.cnf 文件的内容如下：
   ```text
      [mysqld]
      user=mysql8
      basedir=/opt/mysql8/mysql-8.0.32
      datadir=/opt/mysql8/data/mysql8
      socket=/opt/mysql8/data/mysql8/mysql.sock
      character-set-server=utf8mb4
      lower_case_table_names=1

      [client]
      socket=/opt/mysql8/data/mysql8/mysql.sock
   ```
* 数据库初始化 
```shell
   $> mysqld --user=mysql8 --basedir=/opt/mysql8/mysql-8.0.32 --datadir=/opt mysql8/data/mysql8 --socket=/opt/mysql8/data/mysql8/mysql.sock  --initialize
```

* 启动mysql服务器
```shell
   $> mysqld_safe & 
```
   启动之后会有两个进程一个是mysqld_safe 进程，另一个是mysqld 进程，并且mysqld_safe 进程是mysqld进程的父进程。 



## 遇到的问题
1. 使用rz命令上传安装包的时候，上传失败。
   1. 定位到原因是磁盘空间比较小，后来新增了磁盘，并且进行分区，和挂载之后就可以解决问题


## 其他
安装后mysql的root用户的密码是123456


## TODO
* 修改mysql的配置，让指定的主机可以访问。
* 修改mysql的配置，让指定网段的主机可以远程访问
* 修改mysql的配置，让某几个ip可以远程访问



## 变更记录

| 日期              | 操作类型 | 修改内容                                               | 备注 |
| ----------------- | -------- | ------------------------------------------------------ | ---- |
| 2023-03-18 星期六 | A        | 在 centos7 上安装mysql8数据库                   |      |
| 2023-03-19 星期日 | A        | 在centos7上安装mysql8数据库整体流程梳理                   |      |
