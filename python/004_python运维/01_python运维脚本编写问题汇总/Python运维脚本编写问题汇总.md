# Python运维脚本编写问题汇总



subprocess.run() 运行包含｜的脚本。 需要设置shell的值为True，将整个command作为一个shell脚本来运行。 

```python
command = 'ps -ef | grep java | awk  \'{print $8}\''
print(command)
subprocess.run(command, shell=True)

```

