# Docker的使用







## Docker常用的命令

### Docker 镜像文件和容器命令

* docker images 
  * 查看所有的镜像
* docker rmi [image_id]
  * 根据imageid删除一个镜像
* sudo docker rmi  $(docker images -q)
  * 删除所有的镜像
* docker ps -a
  * 查看所有容器状态
  * docker container ls -all
* docker rm $(sudo docker ps -a -q)
  * 删除所有容器