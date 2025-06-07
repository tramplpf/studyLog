# Linux系统的history命令深入学习

history命令用于查看执行成功过的Linux命令。

 历史执行成功过的history命令会保存到特定的文件中，如果使用的shell是bash则保存到  ~/.bash_history文件中，如果使用的是zsh ，则保存到 ~/.zsh_history文件中

.bash_history 并不是实时更新的，只有退出时才会写入


## linux常用的命令
```shell
# 将内存中操作成功的shell命令写回到相关的xxx_history文件中
$> history -a 

# 查看最后执行的10个linux命令
$> history n
$> history 10


$> history -d  history文件中的编号

$> # !history文件中命令的编号
$> history -s ""

# 清空命令历史
$> history -c 

# 删除历史中指定的第0ffset个命令
$> history -d offset


```

## history命令相关环境变量
HISTSIZE  命令历史记录的条数
HISFILE   指定历史文件，默认为~/.bash_history
HISTFILESIZE    命令历史文件记录历史的条数
HISTTIMEFORMAT="%F %T" 显示时间
HISTIGORE="str1:str2*..." 忽略str1命令，str2开头的历史
HISTCONTROL: 控制命令历史的记录方式
        ignoredups是默认值，可忽略重复的命令，连续且相同为重复
        ignorespace 忽略所有以空白开头的命令
        ignoreboth 相当于ignoredups，ignorespace 的组合
        erasedups 删除重复命令

## 其它
如果想要禁用history，可以设置HISTSIZE=0

