# Mac系统安装mysql数据库

访问 https://dev.mysql.com/downloads/mysql/  地址，进入到mysql数据库的下载地址。 



在下载页面中根据Mac系统的硬件架构选择合适的安装包：

<img src="./pic/001_适合mac系统的mysql数据库.png" alt="001_适合mac系统的mysql数据库" style="zoom: 33%;" />



自己选择下载 DMG Archive 

点击上面的download，然后选择。No thansk，just start my download 来直接下载mysql 安装包

<img src="./pic/002_直接下载mysql安装包.png" alt="002_直接下载mysql安装包" style="zoom:33%;" />



![003_同意下载mysql安装包](./pic/003_同意下载mysql安装包.png)



点击***允许***

下载的文件名为  mysql-8.0.26-macos11-arm64.dmg





### mac系统安装mysql 

#### dmg格式文件安装



双击 pkg 安装包

<img src="./pic/101_双击pkg安装包.png" alt="101_双击pkg安装包" style="zoom:50%;" />





<img src="./pic/102_pkg软件安装包安装.png" alt="102_pkg软件安装包安装" style="zoom:50%;" />



<img src="./pic/103_修改安装路径png.png" alt="103_修改安装路径png" style="zoom:50%;" />



<img src="./pic/104_自定义安装的mysql组件.png" alt="104_自定义安装的mysql组件" style="zoom:50%;" />





<img src="./pic/105_选择要安装的mysql组件.png" alt="105_选择要安装的mysql组件" style="zoom:50%;" />



<img src="./pic/106_mysql数据库安装.png" alt="106_mysql数据库安装" style="zoom:50%;" />



<img src="./pic/107_mysql8的强认证方式SHA256.png" alt="107_mysql8的强认证方式SHA256" style="zoom:50%;" />



<img src="./pic/108_设置mysql的登陆密码.png" alt="108_设置mysql的登陆密码" style="zoom:50%;" />

​							密码设置为：lpf123456!@#



<img src="./pic/109_mysql数据库安装过程.png" alt="109_mysql数据库安装过程" style="zoom:50%;" />



<img src="./pic/110_mysql数据库安装成功.png" alt="110_mysql数据库安装成功" style="zoom:50%;" />





### Mac 系统安装mysql数据库后对数据库进行配置



<img src="./pic/201_mysql数据库安装成功后在系统偏好设置中查看.png" alt="201_mysql数据库安装成功后在系统偏好设置中查看" style="zoom:50%;" />



<img src="./pic/202_mac系统安装mysql后配置.png" alt="202_mac系统安装mysql后配置" style="zoom:50%;" />



<img src="./pic/202_mysql数据库的某些文件的默认配置.png" alt="202_mysql数据库的某些文件的默认配置" style="zoom:50%;" />

在 /e t c/profile 文件中配置PATH 环境变量，让我们在任何位置都可以找到mysql相关的命令

<img src="./pic/203_配置mysql的访问路径.png" alt="203_配置mysql的访问路径" />

<img src="./pic/301_mysql安装路径的bin目录下可执行命令.png" alt="301_mysql安装路径的bin目录下可执行命令"  />





### Mysql 数据库的使用

登陆mysql数据库

$ mysql -u root -p 

密码是： lpf123456!@#





# 电脑配置



<img src="./pic/901_mac电脑配置.png" alt="901_mac电脑配置" style="zoom:50%;" />



