# kubernetes的交互式教程

https://kubernetes.io/zh/docs/tutorials/kubernetes-basics/create-cluster/cluster-interactive/



## 课程一: 创建一个kubernetes集群

Step 1:  创建一个k8s 集群

```shell
# 查看minikube的版本
$> minikube version
# 启动minikube
$> minikube start
# 查看minikube的集群环境
$> minikube cluster-info
# 查看kubectl客户端和服务端的版本
$> kubectl version
# 查看集群中可用的节点信息
$> kubectl get nodes
```



## 课程二：部署第一个Deployment

目标：

* 学习了解应用的部署
* 使用kubectl在kubernetes上部署第一个应用



Deployment 指挥 Kubernetes 如何创建和更新应用程序的实例。



执行如下命令创建一个Deployment

```shell
$> kubectl create deployment kubernetes-bootcamp-demo --image=gcr.io/google-samples/kubernetes-bootcamp:v1
```





查看当前集群中有哪些Deployment

```shell
$> kubectl get Deployments 
```



设置当前执行Pod的变量

```shell
$> export POD_NAME=$(kubectl get pods -o go-template --template '{{range .items}}{{.metadata.name}}{{"\n"}}{{end}}')
echo Name of the Pod: $POD_NAME
```



查看指定Pod的相关信息

```shell
$> curl http://localhost:8001/api/v1/namespaces/default/pods/$POD_NAME/
   
```





## 课程三 查看Pod和工作节点

**目标**

* 了解kubernetes中的Pod
* 了解kubernetes中的工作节点
* 对已部署的应用排除故障



***A Pod is a group of one or more application containers (such as Docker) and includes shared storage (volumes), IP address and information about how to run them.***



一个 pod 总是运行在 **工作节点**。工作节点是 Kubernetes 中的参与计算的机器，可以是虚拟机或物理计算机，具体取决于集群。



**常用命令：**

kubectl get   列出资源

kubectl description   显示有关资源的详细信息

kubectl logs    打印pod和其中容器的日志

kubectl  exec 在Pod中的容器上执行命令



上面这些命令后面，都需要添加相关的资源名称。 





## 课程四：使用Service 暴露你的应用

目标：

* 了解kubernetes中的Service
* 了解标签(Label) 和标签选择器(Label Selector) 对象如何与Service关联
* 在kubernetes集群 外用Service暴露应用



查看当前集群中运行的Pods有哪些

```shell
$> kubectl get pods
```

查看当前集群中有哪些Services

```shell
$> kubectl get services
```

将服务暴露出来

```shell
$> kubectl expose deployment/kubernetes-bootcamp --type="NodePort" --port 8080
```



再次查看我们可以访问的服务有哪些

```SHELL
$> kubectl get services
```

此时，我们发现，我们创建的service是可见的。 

查看某个服务的详细信息

```shell
$> kubectl describe services/kubernetes-bootcamp 
```

显示结果如下：



我们可以通过 

NodePort:                 <unset>  30125/TCP

知道，暴露出来 30125 端口， 我们通过  telnet localhost 30125 可以知道该端口确实被暴露出来了。 



通过如下的命令将Service 暴露出来的端口号设置为环境变量，之后可以通过该环境变量快速访问该服务

```shell
export NODE_PORT=$(kubectl get services/kubernetes-bootcamp -o go-template='{{(index .spec.ports 0).nodePort}}')
echo NODE_PORT=$NODE_PORT
```



验证kubernetes 暴露是否成功

```shell
$> curl $(minikube ip):$NODE_PORT
```

如果有响应，并且不是报错信息，则说明暴露成功。 



**Step 2： Using labels**

Deployment 自动为我们的Pod创建了标签，我们可以通过 如下命令来查看标签

```SHEL
$> kubectl describe deployment
```

如下图：



通过标签，我们可以查看满足条件的Pods

```shell
$> kubectl get pods -l app=kubernetes-bootcamp
```

效果如下：



通过标签查看，满足条件的Services 有哪些

```shell
$> kubectl get services -l app=kubernetes-bootcamp
```



将Pod的名字设置为环境变量 

```shell
export POD_NAME=$(kubectl get pods -o go-template --template '{{range .items}}{{.metadata.name}}{{"\n"}}{{end}}')
echo Name of the Pod: $POD_NAME
```



**Step 3： 删除标签**

通过如下命令来删除满足条件的某个标签

```SHELL
$> kubectl delete service -l app=kubernetes-bootcamp
```

删除之后，再次通过 kubectl get  service 来查看现存的Services

效果如下：



上面的命令只是将Service 删除了，但是相关的pod依然还在运行，可以通过如下命令来验证

```shell
$> kubectl exec -ti $POD_NAME -- curl localhost:8080
```

之所以会这样，是因为是Deployment 管理着应用，而不是Service。 所有，如果我们只有删除Deployment 才算

真正的删除某个应用。 



## 课程五： 运行应用程序的多个实例

https://kubernetes.io/zh/docs/tutorials/kubernetes-basics/scale/scale-intro/

**目标：**

* 使用kubernetes扩缩应用程序



扩缩是通过改变Deployment中副本数量来实现的 

运行应用程序的多个实例需要在它们之间分配流量。 服务（S revise）有

一种负载均衡器类型，可以将网络流量均衡分配到外部可以访问的Pods上。

服务会一直通过端点来监视Pods的运行，保证流量只分配到可用的Pods上。 



## 课程六：执行滚动更新

**目标：**

* 使用kubectl执行滚动更新

滚动更新允许通过使用新的实例逐步更新Pod实例，零停机进行Deployment更新。新的Pod将在具有可用资源的节点傻姑上进行调度。 

在Kubernetes中，更新是经过版本控制的，任何Deployment更新都可以恢复到一起的（稳定）版本。 

滚动更新允许以下操作：

1. 将应用程序从一个环境提升到另一个环境（通过容器镜像更新）
2. 回滚到以前的版本
3. 持续集成和持续交付应用程序，无需停机。 











