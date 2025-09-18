# centOS7 安装mysql8

## 环境说明

操作系统版本： CentOS Linux release 7.9.2009 (Core)

内核信息： Linux node03 3.10.0-1160.59.1.el7.x86_64 #1 SMP Wed Feb 23 16:47:03 UTC 2022 x86_64 x86_64 x86_64 GNU/Linux



## 安装包





## 安装

特殊之处： 创建一个mysql组和mysql用户，但是mysql用户不能登录系统，且没有home目录。 

```shell
$> useradd -r -g mysql -s /bin/false  mysql
```



初始化数据库：

```shell
$> mysqld --defaults-file=/opt/data/mysql/conf/my3306.cnf  --initialize &
```

正常初始化后，在配置的日志文件里面，可以看到root@'localhost' 用户的初始化密码。 



启动数据库

```shell
$> mysqld --defaults-file=/opt/data/mysql/conf/my3306.cnf &
```













安装完成后，先使用mysqld --initialize 参数初始化数据库，

之后通过在error日志中找到初始化的密码。 

通过如下命令登录

```SHELL
$> mysql -S /opt/data/mysql/socket/my3306.socket -uroot -p

## 使用初始化密码登录后，用户不能做任何操作，必须先手动修改密码 
mysql>alter user() identified by '123456'

```





## 创建用户

```
## root 用户的权限太大，一般不适用root来直接操作数据库，因此按照下面的命令创建对应的mysql用户

mysql> create user lipf@'%' identified by '123456';
Query OK, 0 rows affected (0.02 sec)

mysql> grant all on *.* to lipf@'%';
Query OK, 0 rows affected (0.01 sec)

## 执行如下的命令，查看创建的用户是否成功
mysql> select User, Host  from mysql.user;
+------------------+-----------+
| User             | Host      |
+------------------+-----------+
| lipf             | %         |
| mysql.infoschema | localhost |
| mysql.session    | localhost |
| mysql.sys        | localhost |
| root             | localhost |
+------------------+-----------+

```

后续操作，都通过新创建的普通用户登录后，进行操作

```
 mysql -S /opt/data/mysql/socket/mysql3306.sock -ulipf -p
```



## 关闭mysql数据库

```shell
$> mysqladmin -S /opt/data/mysql/socket/mysql3306.sock -uroot -p123456 shutdown
```







## 遇到的问题

mysql8和centos版本不兼容

```shell
$> yum update -y
$> yum install -y libstdc++-devel
```

上面的操作没有解决问题，正确的操作是，选择合适的mysql的版本



2、 

2025-09-07T10:45:28.051980+08:00 0 [ERROR] [MY-010338] [Server] Can't find error-message file '/usr/local/mysql/share/errmsg.sys'. Check error-message file location and 'lc-messages-dir' configuration directive.





## 经验

1、通用版的linux下mysql的安装包，在某些环境下可能存在版本不兼容的情况，因此选择版本的时候，最好是根据服务器的版本选择对应的mysql安装包的版本

mysql-8.4.6-linux-glibc2.28-x86_64.tar.xz 在centOS7.9 中运行mysqld就有问题，有版本兼容的问题

mysql-8.4.6-linux-glibc2.28-x86_64-minimal.tar.xz 安装也有问题， 后续安装注意一下。 看看有没有



2、通过--defaults-file指定的配置文件中，配置的内容，必须正确，否则数据库初始化和数据库启动会有各种奇怪的问题。 

3、在练习过程中，应该将常用的mysql命令整理成脚本，避免遗忘，便于后续操作。
