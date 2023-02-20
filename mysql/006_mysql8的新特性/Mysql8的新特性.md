# Mysql8 的新特性.md

* 参数修改吃就好


## 参数修改持久化
MySQL 8.0 版本支持在线修改全局参数并持久化，通过加上PERSIST 关键字，可以讲修改的参数持久化到新的配置文件（mysqld-auto.cnf）中，重启MySQL时，可以从该配置文件获取到最新的配置参数。 
set global 设置的变量参数在mysql重启之后会失效. 
mysql> set persist innodb_lock_wait_timeout=25

