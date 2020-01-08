安装环境介绍：
	宿主机： CentOS Linux release 7.6.1810 (Core)  (可以通过 cat /etc/redhat-release命令来查看当前centos的版本号)
	mongodb的版本： mongodb4.0.10 


1. 登录linux系统，执行
wget https://fastdl.mongodb.org/linux/mongodb-linux-x86_64-rhel70-4.0.10.tgz  命令
下载mongoDB数据库的安装包。

2. 创建mongoDB数据库的安装路径
mkdir -p /usr/local/software/mongoDB

3. 将下载下的安装包解压缩到/usr/local/software/mongoDB 目录下。
tar -xzvf ****.tgz -C /usr/local/software/mongoDB

4. 为了方便后续操作为mongoDB安装目录创建软连接
ln mongoDB**** -s mongoDB

5. 切换到root用户，切换到mongoDB安装目录，执行
$ pwd >> /etc/profile
然后，使用vi编辑 /etc/profile 设置monogoDB的路径
export PATH=$PATH:/usr/local/software/mongoDB/mongoDB/bin



mongodb安装好之后可以通过  $ > mongod --dbpath /opt/data/mongodb  命令来启动，
注意：
	这里的 /opt/data/mongodb 路径，必须存在，且当前用户具有对该目录的读写权限。 

启动后，显示效果如下：
./pic/0001_mongodb单机启动的提示信息.png

提示：
	
	mongodb 默认的端口号是27017。 

测试mongodb是否安装成功：
方式一： 
	$ > telnet localhost 27017 
	如果通过telnet 命令，无法访问，mongodb肯定没有安装好。 

方式二：
	$ > 通过mongo命令或者mongodb客户端来连接。 


mongodb数据库的连接：
方式一： 通过mongo 命令进行连接。 
	$ > mongo    当没有为mongo修改默认端口的时候，可以通过mongo命令来进行简单的连接。 

方式二： 通过mongo客户端来连接
	mongodb的客户端，主要有robot3T 和studio3T，其中studio3T 是一款收费软件。 
	当mongodb安装在linux上的时候，在window上的客户端通过网络访问mongodb的时候，需要知道centos的ip地址。 
	通过ip addr 命令可以指定centos的ip 地址。 
	在连接之前，可以通过 telnet ip地址 27017 查看服务器的端口号是否开启。 如果没有开启，设置防火墙(设置防火墙，目前不会，是通过关闭防火墙来实现该功能的)
	
	

