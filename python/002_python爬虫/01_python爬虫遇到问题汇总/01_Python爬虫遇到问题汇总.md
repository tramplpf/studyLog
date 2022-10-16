# Python爬虫学习过程中遇到的问题汇总



* AttributeError: 'set' object has no attribute 'items' 问题

​				出现AttributeError: ‘set’ object has no attribute 'items’这个问题一般就是写爬虫时headers 定义有问题

​				错误格式：

```python
headers = {
    'User-Agent : Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.149 Safari/537.36'
    }
```

​				正确格式：

```python
headers = {
    'User-Agent' : 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.149 Safari/537.36'
    }

```

​		headers= {‘User-Agent’ : ‘value’ }
​		而不是
​		headers= {‘User-Agent : value’ }

* 