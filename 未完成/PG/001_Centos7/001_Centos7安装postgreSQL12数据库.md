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

