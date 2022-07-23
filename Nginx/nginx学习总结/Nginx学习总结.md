# Nginx学习总结



1. 任何一个问题在不同的数量级下处理方案时不同的。



nginx进程个数设置为和cpu的核数一样，同时也会配置将nginx的worker进程和具体的cpu核进行绑定，提高缓存利用率。 



Nginx 的父子进程是通过信号进行管理的。 



kill -SIGHUP  进程号， 效果和nginx -s reload 命令的效果一样。 



23 使用





nginx 优雅的关闭是只针对http协议，对应websocket等协议是无法做到优雅关闭的。 





