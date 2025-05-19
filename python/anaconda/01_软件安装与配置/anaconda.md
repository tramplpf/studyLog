# anaconda的安装与配置

## 下载安装
方式一： 登录anaconda官网下载相关的软件

方式二： 访问镜像仓库
https://mirrors.tuna.tsinghua.edu.cn/anaconda/miniconda/?C=M&O=D
根据自己电脑的架构下载对应软件的版本，建议下载最新版

## 配置

### 配置文件的保存路径

```
$> conda config --all envs_dirs  /opt/env/condaEnv
```

### 配置channels
配置国内软件源
语法： conda config --add xxx
添加后的软件源会维护到当前用户目录下的 .condarc 文件中

```shell
# 配置添加清华源
conda config --add channels https://mirrors.tuna.tsinghua.edu.cn/anaconda/pkgs/free/
conda config --add channels https://mirrors.tuna.tsinghua.edu.cn/anaconda/pkgs/main/
conda config --add channels https://mirrors.tuna.tsinghua.edu.cn/anaconda/cloud/conda-forge/

# 配置中科大镜像源
conda config --add channels https://mirrors.ustc.edu.cn/anaconda/pkgs/main/
conda config --add channels https://mirrors.ustc.edu.cn/anaconda/pkgs/free/
conda config --add channels https://mirrors.ustc.edu.cn/anaconda/cloud/conda-forge/
conda config --add channels https://mirrors.ustc.edu.cn/anaconda/cloud/msys2/
conda config --add channels https://mirrors.ustc.edu.cn/anaconda/cloud/bioconda/
conda config --add channels https://mirrors.ustc.edu.cn/anaconda/cloud/menpo/

# 配置上海交通大学镜像源
conda config --add channels https://mirrors.sjtug.sjtu.edu.cn/anaconda/pkgs/main/
conda config --add channels https://mirrors.sjtug.sjtu.edu.cn/anaconda/pkgs/free/
conda config --add channels https://mirrors.sjtug.sjtu.edu.cn/anaconda/cloud/conda-forge/

#设置搜索时显示通道地址
conda config --set show_channel_urls yes
```

## conda相关命令
查看环境中已经安装的包
```shell
$> conda list
```

更新conda
```shell
$> conda update conda
```

更新Anaconda环境中的所有包
```shell
$> conda update anaconda
```

更新所有包
```
$> conda update --all
```

conda报错后的处理
```shell
$> conda update --all
$> conda clean --all
$> conda update conda
```

## 疑惑
（一）conda info执行报错
自己多次安装conda。可能没有删除彻底
```text
(base) lpf@lpfdeMacBook-Pro ~ % conda info
__conda_exe:1: no such file or directory: /Users/lpf/anaconda3/bin/conda

```


