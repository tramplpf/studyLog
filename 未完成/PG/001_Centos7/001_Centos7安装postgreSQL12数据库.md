# centOS7安装PostgreSQL数据库12

执行如下的几个命令通过命令行的方式安装PostgreSQL数据库

```shell
# # Install the repository RPM:
sudo yum install -y https://download.postgresql.org/pub/repos/yum/reporpms/EL-7-x86_64/pgdg-redhat-repo-latest.noarch.rpm
# Install PostgreSQL:
sudo yum install -y postgresql12-server
# 设置开机自启
sudo /usr/pgsql-12/bin/postgresql-12-setup initdb
sudo systemctl enable postgresql-12
sudo systemctl start postgresql-12
```

通过如下命令安装好的PostgreSQL 默认安装到了 /usr/pgsql-12 目录下。 



安装好之后，为了在linux的任务位置都可以很方便的调用postgreSQL数据库的命令，需要在 /etc/profile 文件中添加如下配··

```shell
export PATH=$PATH:/usr/pgsql-12/bin
```

此时，可以切换到home 目录下，执行如下命令查看配置是否生效

```shell
$> initdb --version
# 显示效果
initdb (PostgreSQL) 12.9
```





## 疑惑

1. 通过上面的命令开机自启postgreSQL数据库的用户是哪个用户？
2. 