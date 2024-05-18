# MAC系统安装postgres数据库

## 使用brew安装postgresql

```shell
base > brew install postgres 
```

<img src="./pic/01_mac系统安装postgres.png">

通过日志可以知道postgresql安装后默认在 /opt/homebrew/var/postgresql@14 初始化了一个数据库集群

启动postgresql数据库之后，执行oid2name，可以知道默认有一个postgresql

<img src="./pic/05_oid2name查看数据库有哪些.png"/>

默认用户是操作用户的用户名。 这里是lpf，因此使用如下命令可以登录到pg数据库

```shell
shell> psql -Ulpf  -d postgres
```

<img src="./pic/06_使用psql登录pg数据库成功的效果_V20240423.png"/>

## 查看brew安装的服务运行状态

```shell
$> brew services list
```

<img src="./pic/02_mac系统查看postgres是否启动成功_V2024042.png"/>



## 使用brew命令启动postgres

<img src="./pic/03_mac系统启动postgresql数据库_V20240423.png"/>



## 使用brew命令停止postgresql数据库



<img src="./pic/04_mac系统停止postgresql数据库.png"/>

