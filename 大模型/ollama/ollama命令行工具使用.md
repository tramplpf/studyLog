;; This buffer is for text that is not saved, and for Lisp evaluation.
;; To create a file, visit it with ‘C-x C-f’ and enter text in its buffer.

# Ollama的命令行工具使用

ollama pull
对于不需要运行的模型就需要单独进行拉取，而不是通过ollama run 先拉取，接着运行


### ollama create
ollama 的 github仓库里面 /docs/modelfile.md 文件中，记录了创建model的模型文件

查看指定模型的modelfile文件
ollama show --modelfile  llama3.2:3b



##
>>> /show modelfile





## 疑惑
* ollama 后台启动后，相关的日志保存在哪里？

