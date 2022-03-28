# Kubectl的安装



## Linux环境下kubectl的安装



查看kubeclt 当前最新的稳定版本的版本号： 

通过浏览器访问来确定

```bash
https://dl.k8s.io/release/stable.txt
```

截止到2022-03-25 当前的最新版本号是： **v1.23.5**



执行如下命令，下载kubectl的安装包(kubectl)：

```shell
$> curl -LO "https://dl.k8s.io/release/v1.23.5/bin/linux/amd64/kubectl"
```

执行如下的命令，下载kubectl的校验文件（kubectl.SHA256） (**一定要有安全意识**)

```shell
$> curl -LO "https://dl.k8s.io/v1.23.5/bin/linux/amd64/kubectl.sha256"
```



将kubectl软件和校验码文件放在同一个目录下，并执行如下命令进行校验

```shell
$> echo "$(<kubectl.sha256) kubectl" | sha256sum --check
```

输出： kubectl: OK  

表示下载的kubectl 没有被篡改。 



执行如下的命令，安装kubeclt客户端

```shell
$> sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

执行完之后，通过 which kubectl  可以知道kubectl 的安装路径

在centos7中，通过普通用户，安装路径是： /usr/local/bin/kubectl



**验证kubectl的版本**

```shell
$> kubectl version --client
```



## 验证kubectl配置

要验证kubectl的配置，需要保证安装好了kubernetes集群，否则会有问题。 



为了让kubectl 能发现并访问kubernetes集群，你需要一个kubeconfig文件，该文件在kube-up.sh 创建集群时或成功部署一个Minikube集群时，均会自动生成。通常kubectl 的配置信息存放在文件 ~/.kube/config 中



```shell
$> kubectl cluster-info
```



如果返回一个 URL，则意味着 kubectl 成功的访问到了你的集群。







 



