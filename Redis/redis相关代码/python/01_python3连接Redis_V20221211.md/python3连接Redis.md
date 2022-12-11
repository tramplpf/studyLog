# python3连接Redis


## Python3 连接Redis单机以及哨兵集群
安装依赖
```shell
pip3 install redis
```

操作Redis单机的代码：
```python
import redis
res_conn = redis.StrictRedis(
    host='127.0.0.1', port='6379', db=0, password='methyI@2022')
res_conn.set('test', '123')
res_conn.get('test')
```

## Python连接Redis Cluster集群
安装依赖
```shell
pip3 install redis-py-cluster
```




## 参考

https://blog.51cto.com/u_7961702/5329009

