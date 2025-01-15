# git想要将一个之前提交到远程的文件添加到.gitignore

如果你想要将一个已经提交到远程仓库的文件添加到 .gitignore 并且从远程仓库中删除，

你需要执行以下步骤：

1.  将文件添加到 .gitignore 文件中
2. 从本地仓库中删除文件，但保留其在工作目录中的副本
3. 提交 .gitignore 的更改并推送到远程仓库。



下面是相应的命令：

```shell
echo 'your_file_name' >> .gitignore  # 将文件名添加到 .gitignore 文件中
git rm --cached your_file_name       # 从本地仓库中删除文件但保留文件副本
git commit -m "Remove file from remote repository"  # 提交更改
git push origin master  # 推送更改到远程仓库，这里假设你推送到 master 分支
```

请将 your_file_name 替换为你想要忽略并从远程仓库中删除的文件名





@author lipf

@date 2025年1月15日16:42:17