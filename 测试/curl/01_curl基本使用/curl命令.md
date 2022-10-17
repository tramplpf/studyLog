# curl命令


1. 发送一个POST类型的请求 
这里要注意， -X 指定请求方式，需要大写，小写不支持
```shell
curl 'http://127.0.0.1:8081/redisdemo/redis/saveMsg2Redis?key=abc&value=abcd' -X POST
```

2. 