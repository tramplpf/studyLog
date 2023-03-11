# MySQL8中对性能影响最多的几十个参数.md


MySQL8中一共有6百多个系统参数，其中对系统性能有较大影响的只有几十个。 
查看所有的系统参数：https://dev.mysql.com/doc/refman/8.0/en/server-system-variable-reference.html

max_join_size
max_connections





代码的这几个参数可能很重要（通过这些参数值查询MySQL在负载高峰占用的总内存）
key_buffer_size ：设置MyISAM索引的大小。 
innodb_buffer_pool_size
innodb_log_buffer_size
binlog_cache_size
max_connections
read_buffer_size
read_rnd_buffer_size
sort_buffer_size
join_buffer_size
thread_stack
tmp_table_size


磁盘读写参数
磁盘的读写通常是对数据库性能最大的因素之一。
* innodb_flush_log_trx_commit;
* sync_binlog
* innodb_flush_method
* innodb_io_capacity 和 innodb_io_capacity_max

