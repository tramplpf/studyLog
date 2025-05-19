# 通过Jenkins部署Django项目到Linux系统



scp django_demo.zip devops@192.168.0.200:/opt/app/djangodemo



在Linux系统编写相关的shell脚本来启动Djaong项目

```shell
#/bin/bash
# 
# 在目标Linux上执行，这种通过python manage.py runserver 的启动方式不好，后续会进行优化
echo '关闭原有的Djaong项目并启动新的Djaong项目'
rm -rf /opt/app/server/django_demo/*
if [ $? == "0" ]
then
	unzip django_demo.zip  -d /opt/app/server/django_demo
	cd /opt/app/server/django_demo
	python manage.py runserver 127.0.0.1:8085
else
	echo "创建文件夹失败"
fi

```

