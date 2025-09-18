# mysql数据库使用XtraBackup进行物理备份

## xtrabackup优缺点

XtraBackup的优点：

（1）备份速度快，物理备份可靠
（2）备份过程不会打断正在执行的事务（无需锁表）
（3）能够基于压缩等功能节约磁盘空间和流量
（4）自动备份校验
（5）还原速度快
（6）可以流传将备份传输到另外一台机器上
（7）在不增加服务器负载的情况备份数据

  (8)  可以针对某个特定的数据库进行备份

XtraBackup的缺点：
（1）文件大

（2）不总是可以跨平台、操作系统和MySQL版本







## XtraBackup的下载

下载地址：https://www.percona.com/downloads

根据mysql的版本选择对应的XtraBackup 进行下载，xtrabackup兼容性较差，对版本要求比较高

Percona XtraBackup 8.0 只支持MySQL 8.0的版本
Percona XtraBackup 2.4 支持MySQL 5.11 , 5.5, 5.6 和5.7的版本

XtraBackup 8.0下载地址：https://www.percona.com/downloads/Percona-XtraBackup-LATEST/
XtraBackup 2.4下载地址：https://www.percona.com/downloads/Percona-XtraBackup-2.4/LATEST/ 





## 安装

```shell
$> yum install -y libev libgcrypt openssl zlib libaio
$> yum localinstall -y percona-xtrabackup-80-8.0.35-31.1.el7.x86_64.rpm
$> xtrabackup --version
```





## 相关参数说明

```text
--user：指定连接数据库的用户名。
--password：指定连接数据库的密码。
--backup：执行备份操作。
--prepare：执行备份准备操作。
--copy-back：将备份恢复到原来的数据目录。
--datadir：指定数据目录的路径。
--target-dir：指定备份文件存储目录。
--incremental：执行增量备份操作。
--incremental-lsn：指定增量备份的LSN号。
--tables：仅备份特定的表。
--databases：仅备份特定的数据库。
--compress：压缩备份文件。#开启备份压缩，根据数据内容不同，压缩比可以在50%～60%
--stream=xbstream #开启流式备份，备份出来的数据输出到stdout
--remote-host=user@ip DST_DIR #备份到远程主机
```



## 备份

* 全量备份

```shell
$> innobackupex --defaults-file=/etc/my.cnf --user=backup --password = 111111 --socket=/tmp/my3306.sock
```

* 增量备份

```shell
备份二进制文件到 /tmp 目录下，保存的路径是以时间戳命名的文件夹
$> innobackupex --defaults-file=/data/mysql/mysql3306/mysql3306.cnf --user=root --password=123456 --socket=/data/mysql/mysql3306/mysql.sock /tmp
```

### 第二次增量备份

```shell
#incremental-basedir指定第一次增量备份生成的文件

$> innobackupex --defaults-file=/etc/my.cnf --user=backup --password=yayun --socket=/tmp/mysql.sock --incremental /data/backup/inc2 --incremental-basedir=/data/backup/inc1/2022-04-18_19-56-38








## 
```





## 恢复







## 最佳实践







## 参考资料

[Percona XtraBackup 官方参考文档](https://docs.percona.com/percona-distribution-for-mysql/8.0/) 

[Mysql之xtrabackup工具的使用]( https://www.cnblogs.com/cjzzz/p/16166341.html) 





## 变更记录

| 日期              | 类型 | 操作内容                                           | 备注 | 接下来验证的内容                                             | 操作用户 |
| ----------------- | ---- | -------------------------------------------------- | ---- | ------------------------------------------------------------ | -------- |
| 2025-08-31 星期日 | C    | 初始化文档                                         |      |                                                              | lipf     |
| 2025-09-01 星期一 | A    | 从网上找了一些XtraBackup的扩展知识，比如，增量备份 |      | 可不可以针对某个数据库进行备份？ 不知道该下载哪个板块的XtraBackup | lipf     |
|                   |      |                                                    |      |                                                              |          |
|                   |      |                                                    |      |                                                              |          |

类型说明： C：创建    A： 最近内容    U：修改内容     R：解决疑惑点
