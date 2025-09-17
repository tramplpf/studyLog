# sql高级编程

## limit子句





## 聚合函数

* max()
* Min()
* Avg()
* count()
  * Count(*), count(1), count(字段名) 的区别
* 



```sql
mysql> select min(sal), max(sal) froom emp;   # todo 在sal有索引的时候，这种写法会不会走索引？
```



## 合并查询

union 和union all 

* union          结果会去重
* union all    结果不会去重

## 多表查询

* 内连接查询

  ```sql
  select 字段 from 表1 inner join 表2 on 连接条件;
  select 字段 from 表1 join 表2 on 连接条件;
  select 字段 from 表1，表2 where 连接条件;
  ```

* 外连接查询

  优化器会把外连接转化为内连接，性能会差些， 有的公司会禁用外连接

  * 左外连接

    

  * 右外连接

  







```sql
mysql> select ename, sal, dname from employee, dept where emp.deptno = dept.deptno;


```

