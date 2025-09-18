#  mysql8的安装和启动

## 互联网工时安装MySQL规范

mysql的安装方式： 二进制安装

mysql运行用户： 

```text
mysql:mysql 注意该用户是虚拟用户，只是用户mysql进程运行使用，不允许登录，不允许创建家目录

useradd -s /sbin/nologin -M mysql
```



mysql的目录规范：

```text
下载目录： /Server/tools
系统目录： /opt/mysql/mysql-xx.XX
软连接：  ln -s /opt/mysql/mysql-xx.x /usr/local/mysql
数据目录： /data/mysql/mysql+port/{data,logs}
配置文件:  /data/mysql/mysql+port/my+port.cnf
```



## 二进制安装mysql5.7

mysql5.7 的安装

```shell
创建mysql虚拟用户
$> useradd -s /sbin/nologin -M mysql

创建目录
$> mkdir -p /server/tools
$> mkdir -p /opt/mysql
$> mkdir -p /opt/mysql/mysql3306/{data,logs}



删除系统自带的mariadb
rpm -e --nodeps mariadb-libs




```



mysql配置文件整理 my3306.cnf

```conf
[mysqld]
user=mysql
basedir=/usr/local/mysql
datadir=/data/mysql/mysql3306/data
socket=/data/mysql/mysql3306/mysql.sock
server_id = 1
port = 3306
log_error=/data/mysql/mysql3306/logs/error.log
log_bin=/data/mysql/mysql3306/logs/mysql-bin
binlog_format=row
gtid_mod=on
enforce_gtid_consistency=true
log_slave_updates=1
max_connections=1024
wait_timeout=60
sort_buffer_size=2M
max_allowed_packet=32M
join_buffer_size=2M
innodb_buffer_pool_size=128M
innodb_flush_log_aat_trx_commit=1
innodb_log_buffer_size=32M
innodb_log_file_size=12M
innodb_log_files_in_group=2
binlog_cache_size=2M
max_binlog_cache_size=8M
max_binlog_size=512M
expire_logs_days=7
slow_query_log=on
slow_query_log_file=/data/mysql/mysql3306/logs/slow.log
long_query_time=0.5
long_queries_not_using_indexes=1
```



```shell
安装mysql依赖包
# yum install libaio-devel -y
# yum install numactl -y

更改mysql相关目录的用户组
# chown -R mysql:mysql /usr/local/mysql/*
# chown -R mysql:mysql /data/*

初始化数据库
/usr/local/mysql/bin/mysqld --defaults-file=/data/mysql/mysql3306/my3306.cnf --initialize-insecure --user=mysql --basedir=/usr/local/mysql --datadir=/data/mysql/mysql3306/data

加入环境变量
vim /etc/profile
export PATH="/usr/local/mysql/bin:$PATH"
source /etc/profile

启动MySQL
$> mysqld --defaults-file=/data/mysql/mysql3306/my3306.cnf &

查看mysql的启动情况 (如果启动的时候，没有让mysql指定端口，则这里查不出来)
$> netstat -lntup


通过套接字sock链接mysql数据库 
$> mysql -S /data/mysql/mysql3306/mysql.sock

```



## 二进制安装mysql8.0



## 什么是mysql实例

mysql实例由： 进程 + 线程 + 预分配内存组成

* 进程： 
  * 正在运行的mysql程序，主要是mysqld 进程
  * 查看mysql进程 ps -ef | grep mysql
  * 杀死mysql进程： kill 进程号， 或者  pkill 进程名称

* 线程
  * Master thread
  * purge thread
  * page cleaner thread
  * io thread
* 预分配内存
  * buffer pool
  * insert buffer
  * change buffer
  * double write



在一台机器上由多个实例构成，部署多个mysql实例。 

## 生产中为什么要用mysql多实例

* 单机各种资源有余量
* 主从结果中，从库比较清闲
* 业务高峰期不同



## mysql多实例安装部署

公用系统部分，实例直接具备不同的datadir，server_id， port， 日志文件，socket文件

查看不同实例的server_id 

mysql> select @@server_id



## mysql多实例安装部署注意事项

实例之间具有不同的datadir，server_id， port，日志文件，socket文件

innodb_buffer_pool_size 分配的总量要小于物理内存的80% 





## MySQL启动关闭时遇到的那些坑

```
1. 生产中使用哪种MySQL启动关闭方式
2、mysql启动顺序
3、常见MySQL启动失败案例
	* 目录权限问题导致启动失败
	* 参数问题导致启动失败
	* 配置文件加载错误导致启动失败
	* 端口被占用导致启动失败
	* 初始化失败导致启动失败
	* 手工删除二进制文件导致mysql启动失败
	* 修改共享表空间导致mysql启动失败
4、MySQL启动失败排查方法
5、 mysql链接数据库的方式
6、为什么不建议使用mysql自启动

```



### 生产中使用哪种myslq启动方式

* service
  * 查看support-files 目录下指定文件的有效配置信息： cat  mysql.server  | grep -v '#'
  * cp  support-files/mysql.server  /etc/init.d/mysqld3306
  * vim /etc/init.d/mysqld3306 
    * datadir=/data/mysql/mysql3306/data
  * 启动命令： service mysqld3306 start
  * 关闭命令： service mysqld3306 stop
* systemctl
  * 需要手动编写 /etc/systemd/system/mysqld3306.service
  * 启动命令： systemctl  start mysqld3306.service 
* mysqld_safe
  * mysqld_safe --defaults-file=xxxx/xxx/my.cnf
  * mysqldadmin -S /data/mysql/mysql3306/mysql.sock shutdown 
* mysqld

mysql的二进制安装包中，提供了一些编写好的模板，便于快速配置mysql的不同启动方式，模板文件位于： mysql/support-files



### MySQL启动顺序

service--> mysqld_safe --> mysqld --> 启动mysql

systemctl --> mysqld --> 启动mysql

mysqld_safe --> mysqld --> 启动mysql

mysqld--> 启动mysql



最终都需要通过mysqld来启动，因此最开始验证配置的时候，都应该直接通过mysqld来启动，这样，如果有启动报错，都可以记录到日志中。 如果启动过程没有走到mysqld这一步，是不会记录到mysql的错误日志文件中的



技巧：  查看mysqld命令的详细参数：

```shell
$> mysqld --verbose --help
$> mysqld --verbose --help | grep defaults 

```

查看mysql默认读取配置文件的位置：

```SHELL
$> mysql --help  | grep my.cnf
```







## 遇到的问题

