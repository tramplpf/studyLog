# CUUG 系列-PG 数据库调优（一）

## 目标
* 如何获得慢查询的SQL语句
* 常见参数设置因子与应用案例
* pg_stat_statements部署与使用


### 如何获得慢查询的SQL语句
慢查询sql语句的特征
* 无用的去重（union）
* 无效的条件
* 不必要的子查询
* 无效的索引
* 函数的使用

1. 在postgres.conf中设置（基本）日志参数
```
log_destination='csvlog'
logging_collector=on
log_directory='pg_log'
log_filename='postgresql-%Y-%m-%d'

... 
```

2. 设置（慢查询）日志参数
```
shared_preload_libraries='auto_explain'
# 超过3秒，就认为是慢查询
auto_explain.log_min_duration=3s
```

3. 执行语句并且查看日志信息



### PG参数优化调整
* shared_buffers
  * 建议值为总机器RAM的25% 。这是一个初始值，后续需要根据缓冲区的命中率来进行调整
* wal_buffers
  * PostgreSQL 将WAL（预写日志）记录写入缓冲区，然后将这些缓冲区刷新到磁盘。缓冲区默认大小，由wal_buffers定义为16MB，但如果您有大量并发连接，则较高的值可以提供更好的性能。 
* effective_cache_size
  * 提供了可以用于磁盘缓存存储器的估计。
  * 影响执行计划的生成。设置较大的值总是有益的
* work_memo
  * 指定ORDER_BY ， DISTINCT， JOIN 和哈希表的内部操作将使用的内存量
  * 此配置用于复杂排序，如果必须进行复杂排序，则增加work_mem的值以获得良好结果。内存中的排序闭溢出到磁盘的排序快得多。 
* maintenance_work_mem
  * 用于维护任务的内存设置，默认值是64M。
  * 设置较大的值有助于执行VACUUM， RESTORE，CREATEINDEX，ADD FOREIGN KEY 和 ALTER TABLE 等任务
  * 较大的配置可以提高CREATE INDEX， VACUUM 和数据库还原的性能。 
  * 设置的时候，并不是内存越大越好，该参数设置的过大，性能反而会降低
  
* SYNC
  * 如果启用了fsync， PostgreSQL 将尝试确保将更新写入到物理磁盘
  * 这可确保在操作系统或硬件崩溃后可以将数据库集群恢复到一致状态
  * 禁用fsync通常可以提高性能，但在发生电源，硬件崩溃，会导致数据丢失
* synchronous_commit 
  * 指定在命令向客户端返回成功指示之前，事务提及哦啊是否将等待WAL记录写入磁盘。 这是性能与可靠性之间的权衡。默认设置是“on”
* checkpoint_timeout， checkpoint_completion_target
  * 检查点相关的参数
* max_connections
  * 确定与数据库同时连接的最大数量
  * 每个客户端都可以配置内存资源，因此客户机的最大数量表明使用的内存的最大数量
  * PG目前还没有像Oracle共享服务器的连接方式，因此太多
  * superuser_reserved_conncetions
    * 保留指定的连接数给超级用户
* temp_buffers 
  * 设置每个会话使用的最大临时缓冲区数
* default_statistics_target
  * OistgreSQL从数据库中的每个表职工手机统计信息，以决定如何在他们上执行查询。 
* pg_stat_statements
  * pg_stat_statements 模块提供了一种方法，用于跟踪所有由服务器执行的sql语句的统计
  * 例如
    * 语句总调用次数
    * 总执行时间
    * 逻辑读次数
    * 物理读次数
  * pg_stat_statements扩展的安装








重要的sql
查询shared_buffers命中率查询
方法一：查询pg的统计视图（表）
```
    select blks_hit::float/(blks_read + blks_hit) as cache_hit_ratio from pg_stat_database where datname = current_database();
```
方法二： 从sql语句执行计划查看缓冲区命中情况
```sql
    explain (analyze, buffers)  执行的sql语句
```



