# RocketMQ5.x的安装和使用.md


## 集群环境的搭建



### 修改/etc/hosts 配置文件，配置集群的ip地址和主机名的映射关系
### 配置免密登录 
    ssh-copy-id  主机名

### 关闭防火墙
     
    firewall-cmd status   查看防火墙状态
    systemctl stop firewalld      停止防火墙
    systemctl disable firewalld   禁用防火墙
    yum remove firewalld          卸载防火墙


### 配置RocketMQ的主从集群

配置文件，需要找视频中主人要一下。 


集群中，不同节点启动命令是有差异的。 

```shell
  $> nohup ./mqnamesrv &  

  $ nohup ./mqbroker -c ../conf/2m-2s-async/broker-a.properties & 

```

## 安装RocketMQ dashboard 
只需要在一个机器上面安装就可以。 

借助maven来通过源码进行安装。 
1. 安装配置maven

2. 解压 rocketma-dashboard-rocketmq-dashborard 软件包

dashboard是一个springboot项目 


## 
