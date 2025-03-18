# Centos 安装 Python3

默认Centos7中只有Python2，没有Python3，需要进行编译安装

## 相关命令如下

```shell
   安装gcc，用于后续安装Python时编译源码 
$> yum install gcc -y 

  安装Python3相关依赖
yum install zlib zlib-devel -y
yum install bzip2 bzip2-devel -y
yum install ncurses ncurses-devel
yum install readline readline-devel
yum install openssl openssl-devel
yum install xz lzma xz-devel -y
yum install sqlite sqlite-devel -y
yum install gdbm-devel -y
yum install tk tk tk-devel -y
yum install mysql-devel -y
yum install python-devel -y
yum install libffi-devel -y

通过wget获取源码 https://www.python.org/ftp/python/
$> wget xxx.tgz

解压

$> tar -xvf Python-xxx.tgz

计入目录并编译安装
$> cd Python-xxx
$> ./configure --prefix=/usr/local/python3 --enable-optimizations
$> make all && make install

测试
$> /usr/local/python3/bin/python3 --version
$> /usr/local/python3/bin/pip3 --version

配置源（腾讯源）
pip3 config set global.index-url https://mirrors.cloud.tencent.com/pypi/simple/

```



## 遇到的问题

Could not import runpy module

解决方法，configure配置的时候，不要指定 --enable-optimizations， 如果之前指定后报错了，需要将Python解压后的文件夹删除，之后在重新解压，然后执行configure，make，make install 等命令。 



## 参考资料



