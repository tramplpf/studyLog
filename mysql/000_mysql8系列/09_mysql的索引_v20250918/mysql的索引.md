# mysql的索引

1、mysql索引与二分查找法

2、剖析b+tree索引原理

3、从逻辑角度来看索引

4、相辅相成的聚集索引和辅助索引

5、索引组织表与回表查询

6、生产中小数据量表的索引管理

7、生产中大数据量的索引管理

8、mysql执行计划

9、那些无法使用索引的情况

10、关于索引对于源数据库的应用案例

11、Online DDL影响数据库的性能和并发

12、pt-online-scheam-change原理与应用

13、生产中的索引管理

14、mysql执行计划

15、那些无法使用索引的情况

16、关于索引对于元数据库应用案例



## 语法

CREATE INDEX idx_user_email ON users(email) COMMENT '用于登录页快速查询';





## 生产环境的索引管理

```mysql
创建一个索引
mysql> create index i_name on t3(name);
Query OK, 0 rows affected (0.02 sec)
Records: 0  Duplicates: 0  Warnings: 0


删除索引
alter table t3 drop 

添加主键索引
alter table t3 modify id bigint auto_increment primary key;

```



**建表时创建索引**

* 主键索引

```mysql

方法一：
create table t4(id int auto_increment primary key);

mysql> show create table t4;
+-------+-------------------------------------------------------------------------------------------------------------------------------------------------+
| Table | Create Table                                                                                                                                    |
+-------+-------------------------------------------------------------------------------------------------------------------------------------------------+
| t4    | CREATE TABLE `t4` (
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci |
+-------+-------------------------------------------------------------------------------------------------------------------------------------------------+
1 row in set (0.00 sec)

方法二：
create table t5(id int auto_increment, primary key(id));

```

* 唯一索引

  ```mysql
  create table t6(id bigint auto_increment primary key, name varchar(10) not null unique);
  或者：
  create table t7(id bigint auto_increment primary key, name varchar(10) not null, unique key ui_name(name));
  ```

* 前缀索引

  ```mysql
  mysql> create table t8(id bigint auto_increment primary key, name varchar(10) not null, key i_name(name(5)));
  
  create table t9(id bigint auto_increment primary key, name varchar(10), key i_name(name(3)));
  创建前缀索引，是针对varchar类型的字段创建的，并且对应的字段可以为空
  ```

  

* 联合索引

```mysql
mysql> create table hq_level2 (tid bigint auto_increment primary key, id int, stock_code varchar(16), trade_date varchar(10), key i_stock_trade (stock_code, trade_date));
Query OK, 0 rows affected (0.05 sec)

mysql> show create table hq_level2;
+-----------+---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
| Table     | Create Table                                                                                                                                                                                                                                                                                                              |
+-----------+---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
| hq_level2 | CREATE TABLE `hq_level2` (
  `tid` bigint NOT NULL AUTO_INCREMENT,
  `id` int DEFAULT NULL,
  `stock_code` varchar(16) DEFAULT NULL,
  `trade_date` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`tid`),
  KEY `i_stock_trade` (`stock_code`,`trade_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci |
+-----------+---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
1 row in set (0.01 sec)

```

* 普通索引

```mysql
create table t10(name varchar(10) not null, key i_name(name));
```

### **建表后创建索引**

* 主键索引

```mysql
mysql> alter table t1 add primary key(id);
主键不一定非得自增
mysql> show create table t11;
+-------+-----------+
| Table | Create Table                                      
+-------+----------+
| t11   | CREATE TABLE `t11` (
  `id` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci |
+-------+-----------------------------------------------------------------------------------------------------------------------------------+
1 row in set (0.00 sec)




或者 （设置主键自增）
mysql> alter table t1 modify id bigint auto_increment;
mysql> alter table t1 add primary key(id);


```

* 唯一索引

```mysql
mysql> alter table t1 add unique index i_name(name);
```

* 前缀索引

```mysql
mysql> alter table t1 add index i_title(name(3));
```

* 联合索引

```mysql
mysql> alter table t1 add index i_stock_trade(stock_code, trade_date);
```

* 普通索引

```mysql
mysql> alter table t1 add index i_name(name);
```

**查看索引情况**

```mysql
mysql> show create table t1;
```

```mysql
mysql> show index from 表名;

mysql> show index from t10\G
*************************** 1. row ***************************
        Table: t10
   Non_unique: 1
     Key_name: i_name
 Seq_in_index: 1
  Column_name: name
    Collation: A
  Cardinality: 0
     Sub_part: NULL
       Packed: NULL
         Null: 
   Index_type: BTREE
      Comment: 
Index_comment: 
      Visible: YES
   Expression: NULL

```



查看索引的扩展信息

```mysql
mysql> show extended index from app_hq_level2_dtl\G
*************************** 1. row ***************************
        Table: app_hq_level2_dtl
   Non_unique: 0
     Key_name: PRIMARY
 Seq_in_index: 1
  Column_name: tid
    Collation: A
  Cardinality: 364089
     Sub_part: NULL
       Packed: NULL
         Null: 
   Index_type: BTREE
      Comment: 
Index_comment: 
      Visible: YES
   Expression: NULL
*************************** 2. row ***************************
        Table: app_hq_level2_dtl
   Non_unique: 0
     Key_name: PRIMARY
 Seq_in_index: 2
  Column_name: DB_TRX_ID
    Collation: A
  Cardinality: NULL
     Sub_part: NULL
       Packed: NULL
         Null: 
   Index_type: BTREE
      Comment: 
Index_comment: 
      Visible: YES
   Expression: NULL
```





**删除索引**

```mysql
mysql> alter table 表名 drop index 索引名称;
```





## Online DDL影响数据库的性能和并发

表结构变更包含的范围： 添加字段，删除字段，修改字段类型，修改字符集， 添加索引，删除索引。 

**mysql 5.6版本之前**：

​		执行表结构变更，由于不支持online ddl， 对操作的表加锁，阻塞DML语句，性能和并发就会非常差

**mysql 5.6版本，5.7、8.0** 

​		执行表结构变更，5.6 版本及5.7版本，8.0 版本支持online ddl， 解决对表加锁的问题，可以并行执行dml语句，性能和并发能力得到提升。 



**总结**

online ddl 可以并行执行ddl语句和dml语句。 

online ddl 语法：

```mysql
简化版
alter table t3 add address varchar(10) not null;

完全版
mysql> alter table t3 add address2 varchar(10) not null, lock=default, algorithm=default;
Query OK, 0 rows affected (0.05 sec)
Records: 0  Duplicates: 0  Warnings: 0

```

lock子句： 用于设置ddl语句操作时加锁的方式

* lock=default
* lock=none       表示不加锁
* lock=shared    表示对表添加共享锁
* lock=exclusive 表示对表添加排他锁

algorithm子句：

* algorithm=default 默认的，受 old_alter_table | OFF 参数的影响， 不会拷贝数据
* algorithm=inplace 不会拷贝数据，操作元数据，性能最高
* algorithm=copy 拷贝数据



| innodb_online_alter_log_max_size | 134217728 |  默认参数值是128M

参考innodb_online_alter_log_max_size=128M，用于存放在执行ddl语句期间，如果有dml语句操作，就会放到该日志文件中，如果dml语句的操作 大于128M，就会报错。



**online ddl存在的问题**

* 会造成主从复制延迟
* 





```mysql
创建一个索引只有主键的表
mysql> create table t3(
    -> id bigint auto_increment primary key,
    -> name varchar(10),
    -> age int,
    -> birthday varchar(10));
    
添加一列，性别列
mmysql> alter table t3 add sex varchar(2);

```











## pt-online-scheam-change原理与应用

pt-osc是 pt-online-schema-change的缩写，它支持在线ddl，可以并行执行dml语句，而且主从复制延迟的时间非常少



### Percona ToolKit 的下载

下载地址： https://www.percona.com/downloads

Command-line tools that are engineered to perform a variety of MySQL, PostgreSQL, and MongoDB administration tasks that are too difficult or complex to perform manually.

Percona工具集，支持对mysql，postgreSQL 以及MongoDB数据库的操作

选择正确的版本号和操作系统平台信息来下载对应的

这里选择的平台是： Linux-GENERIC



**CentOS7系统安装percona tookit**

在安装percona-toolkit之前或之后，需要安装必要的依赖



```
安装pt工具依赖
# yum -y install perl-Digest-MD5
# yum -y install perl-DBI
# yum -y install perl-DBD-MySQL
# yum -y install perl-Time-HiRes
# yum -y install perl-IO-Socket-SSL
```



### pt-osc语法

```shell
$> pt-online-schema-change --user=root -password=123456 --socket=/opt/data/mysql/socket/my3306.sock D=db,t=t3 --alter "name varchar(15) not null" --execute 
```

--user 指定用户

--password=指定密码

--socket 指定socket文件

D 指定操作的数据库

t 指定操作的表



双引号中的语句是从 alter语句中拆解得到的(将关键字alter， 数据库名称，表名移除后的内容)

alter table t1 add name varchar(15) not null;



### 样例

```shell
添加索引
$> pt-online-schema-change --user=root --password=123456 --socket=/opt/data/mysql/socket/my3306.sock D=db, t=t3 --alter "add index i_name(name)" --execute

mysql新增索引完整的命令
mysql> alter table t1 add index i_name(name);

修改字段类型：
$> pt-online-schema-change --user=root --password=123456 --socket=/opt/data/mysql/socket/my3306.sock D=dt,t=t3 --alter "modify name varchar(30) not null" --execute

mysql修改字段完整命令：
mysql> alter table t3 modify name varchar(30) not null; 

```

### pt-osc的原理

* 创建一个和原表结构一致的新表(t3_new)
* 在原表上添加 insert，update， delete 三个触发器
* 从原表拷贝数据到新表
* 拷贝完数据后，将t3改名为t3_old, 将新表改名为t3
* 删除t3_old

通过这种方式类支持并发

**todo：** 需要动手看看，看看在执行过程中，能不能正确的查询出数据。











## 好的实践

* 索引名应该以i_ 开头，表示索引。
* 



## 参考资料

[mysql8的online ddl](https://dev.mysql.com/doc/refman/8.0/en/innodb-online-ddl-operations.html)

[Percona Toolkit 下载](https://www.percona.com/downloads)















