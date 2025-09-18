# binlog备份



**开始备份**

```shell
$> mysqlbinlog -h 192.168.23.132 -P 3306 -uroot -R --raw --stop-never mysql-bin.000001 &
```

异步备份：在主从环境中，推荐连接到主库备份主库的binlog

**参数解释**

* -u -p -h -P 连接指定的数据库

* -R --read-from-remote-server  从远程服务器读取
* --raw   需要和-R一起使用，output raw binlog data instead of SQL。 被拷贝过来的binlog保存方式是二进制方式
* --stop-never  持续从指定节点上拉取binlog
* mysql-bin.000001:  从那个binlog开始备份





**停止备份**

```shell
$> ps -ef | grep mysqlbinlog 
$> kill 进程号
```





**相关命令**

* 查看mysqlbinlog 命令的

  ```shell
  $> mysqlbinlog --help 
  ```

  

* 查看mysql数据库中存在的binlog文件

  ```
  mysql> show binary logs;
  ```

* dd

  ```sql
  mysql> flush logs;
  ```

  