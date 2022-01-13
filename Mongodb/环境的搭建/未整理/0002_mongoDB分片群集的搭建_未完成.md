# mongoDB分片群集的设置(未完成)

相关的环境配置：
操作系统： Centos7 
mongodb的版本  db version v4.0.10

需要完成的测试
* 设置一个分片群集
* 创建一个数据库和集合，并且在集合上启用分片
* 使用导入命令在分片集合中加载数据
* 在分片之间分发数据
* 从群集添加和移除分片，并且检查数据是如何自动分发的


相关的环境配置：
			类型		端口		数据文件的路径
分片控制器	Mongos	27021	
配置服务器	Mongod  27022 	/opt/data/db1/config/data
Shard0		Mongod  27023    /opt/data/db1/shard1/data
shard1  	Mongod  27024    /opt/data/db1/shard2/data							

## 设置分片群集
为了设置群集，首先要设置配置服务器。
$> mongod --port 27022 -dbpath /opt/data/db1/config/data --configsvr

## 开启分片控制器(mongos)
$> mongos --configdb localhost:27022 --port 27021 --chunkSize 1  (这个命令有点问题)


