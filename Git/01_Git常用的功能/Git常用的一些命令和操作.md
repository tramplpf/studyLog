# Git常用的一些操作

[TOC]



## 常用的命令

## 常做的一些操作

### 合并多个commit为一个commit

```shell
$> git rebase -i commitId
```

上面的命令可以压缩合并多次提交。 

格式：

```shell
$> rebase -i [startpoint] [endpoint]
```

这里的-i 的意思是 --interactive，即弹出交互式的界面让用户编辑完成合并操作。 [startpoint] [endpoint]指定了一个编辑区间，如果不指定[endpoint],则该区间的终点默认是当前分支HEAD所指向的commit （注意：这里的区间是一个前开后闭的区间）。 



```
// 合并从当前head到15f745b(commit id)
git rebase -i 15f745b
或:
// 合并最近的两次提交
git rebase -i HEAD~2
```



执行这个命令后会跳到一个vi编辑器
里面的提示有：
pick：保留该commit（缩写:p）
reword：保留该commit，但我需要修改该commit的注释（缩写:r）
edit：保留该commit, 但我要停下来修改该提交(不仅仅修改注释)（缩写:e）
squash：将该commit和前一个commit合并（缩写:s）
fixup：将该commit和前一个commit合并，但我不要保留该提交的注释信息（缩写:f）
exec：执行shell命令（缩写:x）
drop：我要丢弃该commit（缩写:d）



**git rebase -i HEAD~2** 这里的 HEAD~2 表示合并最近两次的提交, 如果想合并最近三次的提交修改为: **git rebase -i HEAD~3**



需要做的是，**将第二行的 pick 改为 s**, “s” 为 “squash” 的缩写,“squash” 的意思是将这个提交压缩为最后一次提交



**操作**：

通过git log  --pretty=oneline 来查看提交记录，显示效果如下

<img src="pic\001_多个commit合并为一个commit\01_将多个commit合并为一个commit.png">

这里要将前三个commit 合并为一个commit，并且修改提交信息。 

执行如下的命令

```shell
$> git rebase -i HEAD~3
```

该命令会将最新的三个commit合并为一个commit

执行后弹出如下交互界面：

<img src="./pic/001_多个commit合并为一个commit/002_gitRebase命令合并多个commit.png">

接下来，输入i，使得vim进入编辑模式，将第三个pick 修改为s ,然后按ESC， 之后输入:wq 来保存自己的修改。



之后会再次弹出一个交互界面，在该交互界面中，输入你要修改的comit 信息



执行完之后，效果如下

<img src="./pic/001_多个commit合并为一个commit/05_合并后的效果.png">



如果在执行合并策略的时候，编辑错误的话，可以通过git rebase --abord 来撤销自己的操作。 

<img src="./pic/001_多个commit合并为一个commit/003_撤销合并commit的操作.png">