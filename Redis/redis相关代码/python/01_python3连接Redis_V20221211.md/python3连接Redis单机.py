import redis
# pip3 安装redis ，来操作Redis的单机版以及哨兵集群
# pip3 install redis
# date: 2022-12-11 星期日 14:03

res_conn = redis.StrictRedis(
    host='127.0.0.1', port='6379', db=0, password='methyI@2022')
res_conn.set('test', '123')
res_conn.get('test')
