# UML 之活动图(Activity)



## UML活动图中涉及到的图标

![001_EA中活动图相关的图标(Activity)](D:\04github\tramplpf\studyLog\20UML\01UML图\01Activity(活动图)\01UML之活动图(Activity Diagram)\001_EA中活动图相关的图标(Activity).png)



![002_EA中活动图相关的图标(Object)](D:\04github\tramplpf\studyLog\20UML\01UML图\01Activity(活动图)\01UML之活动图(Activity Diagram)\002_EA中活动图相关的图标(Object).png)![003_EA中活动图相关的图标(Control Nodes)](D:\04github\tramplpf\studyLog\20UML\01UML图\01Activity(活动图)\01UML之活动图(Activity Diagram)\003_EA中活动图相关的图标(Control Nodes).png)



![004_EA中活动图相关的图标(其它)](D:\04github\tramplpf\studyLog\20UML\01UML图\01Activity(活动图)\01UML之活动图(Activity Diagram)\004_EA中活动图相关的图标(其它).png)

其中

#### Activity 表示活动状态

活动状态用于表达状态机中的非原子的运行。

​		状态图可以分解成其他子活动或者动作状态

#### Action 表示动作状态

 动作状态是指原子的， 不可中断的动作，并在此动作完成后通过转换转向另一个状态。 

​		有如下特点：

* 动作状态是原子的， 它是构造活动图的最小单位
* 动作状态是不可中断的
* 动作状态是瞬时的行为
* 动作状态可以有如转换，入转换可以是动作流，也可以是对象流。 动作状态至少有一条出转换， 这条转换以内部的完成为起点，与外部事件无关。 

#### Partition 表示泳道

​			泳道将活动图中的活动划分为若干组，并把每一组指定给负责这组的业务组织，即对象。 在活动图中，泳道区分了负责活动的对象，它明确地表示了哪些互动是由哪些对象进行的。 在包含泳道的活动图中，每个活动智能明确地属于一个泳道。 

​		泳道没有顺序，不同泳道中的活动既可以顺序进行，也可以并发进行。  



#### Control Flow 动作流

动作之间的转换称之为动作流**活动图**的转换 。 用带箭头的直线表示，箭头的方向直行转入的方向



#### Constraints 约束

用来约束动作状态



#### Initial Node 开始节点

实心黑色圆点

#### Final Node 终止节点

终止节点分为活动终止节点(activity final nodes) 和流程终止节点(flow final nodes)

活动终止节点： 表示整个活动的结束。  【图形】 圆圈 + 内部实心黑色圆点

流程终止节点：表示子流程的结束 【图形】圆圈 + 内部十字叉

#### Objects 对象

【图形】：矩形方框



#### DataStore 数据存储

使用关键字《datastore》

【图形】：矩形方框，内含关键字



#### Object Flow 对象流

对象流是动作状态或活动状态与对象之间的依赖关系，表示动作适用对象或动作对对象的影响



#### Decision and Merge Nodes 分支与合并

【图形】分支与合并用菱形表示，它有一个进入转换（箭头从外指向分支符号），一个或多个离开转换（箭头从分支符号指向外）。而**每个离开转换上都会有一个监护条件**，用来表示满足什么条件的时候执行该转换。



#### Fork and Join Nodes 分叉与汇合

分叉用于将动作流分为两个或多个**并发运行的分支**，而**汇合则用于同步这些并发分支**，以达到共同完成一项事务的目的



#### 时间信息



#### 发送信息



#### 接收信号





## 比较好的资料

# [UML建模——活动图（Activity Diagram）](https://www.cnblogs.com/xiaolongbao-lzh/p/4591953.html)









