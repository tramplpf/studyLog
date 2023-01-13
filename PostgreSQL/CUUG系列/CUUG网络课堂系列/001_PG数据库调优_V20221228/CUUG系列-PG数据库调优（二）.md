# CUUG 系列-PG 数据库调优（一）

## 目标
* PostgreSQL新一代日志分析器pgBadger简介
* pgBagder部署
* 如何产生类似于AWR报告
  * 基于一小时，一天，一周，一月的报告
* 如何分析pgBadger


## pgBadger报告模式
* 一小时一报告
* 每天一个报告
* 每周一个累积报告的增量报告
* 每月一个报告
* 多个进程处理一个日志
* 多个进程处理多个日志

## pgBadger部署
1. 源码安装

2. postgresql.conf 配置
```
  logging_collector=on
  log_directory='pg_log'
  log_checkpoints = on
  log_connections = on
  log_disconnections = on
  log_lock_waits = on
  log_temp_files = on
  其他

```

