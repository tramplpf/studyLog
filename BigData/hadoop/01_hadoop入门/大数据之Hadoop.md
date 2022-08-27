# 大数据之Hadoop



随着Hadoop的发展，Hadoop的功能逐渐得到完善，最终成了一款成熟的软件。各Hadoop版本支持不同的特性，高版本Hadoop不一定兼容低版本Hadoop。因此在实际使用过程中，考虑到Hadoop各组件的兼容性及实际需求，Hadoop版本的选择至关重要



## Hadoop不同版本之间的差异

Hadoop1.0 由一个分布式文件系统HDFS和一个离线计算框架MapReduce组成。

Hadoop2.0 包含了一个支持NameNode横向扩展的HDFS，一个资源管理系统YARN和一个运行在YARN上的离线计算框架MapReduce。 



## Hadoop的三种运行模式

* 单机模式
  * 用于对MapReduce程序的逻辑进行调试，确保程序的正确性
  * 单机模式为Hadoop运行的默认模式，无须进行其他配置即可运行，Hadoop运行在一个独立的Java进程下，便于调试
* 伪分布式模式
  * hadoop可以在单节点上以伪分布式的方式运行，Hadoop进程以分离的Java进程来运行，节点既作为NameNode，也作为DataNode，同时读取的是HDFS中的文件
* 完全分布式模式

