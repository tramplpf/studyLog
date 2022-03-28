# kubernetes的交互式教程

https://kubernetes.io/zh/docs/tutorials/kubernetes-basics/create-cluster/cluster-interactive/



## 课程一





## 课程二：部署第一个Deployment





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

***A Pod is a group of one or more application containers (such as Docker) and includes shared storage (volumes), IP address and information about how to run them.***

常用命令：

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