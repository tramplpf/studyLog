# Centos7 的防火墙

Centos7 默认使用firewall作为防火墙



查看防火墙的状态

```shell
$> firewall-cmd --state
```



关闭防火墙

```SHELL
$> systemctl stop firewalld.service
```

禁止firewall开机启动

```shell
$> systemctl disable firewalld.service
```

