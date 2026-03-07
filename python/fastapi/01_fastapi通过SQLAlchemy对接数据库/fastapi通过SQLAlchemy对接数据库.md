# fastapi通过SQLAlchemy对接数据库

因为SQLite已经内置于Python中，因此我们学习阶段使用SQLAlchemy连接SQLite数据库。 这样做的话，我们是无需安装驱动程序。





## 添加依赖

```shell
uv add sqlalchemy
```





## 整合步骤

* 定义数据库存储内容的SQLAlchemy 类
* 定义Pydantic模式层
* 新建database.py文件，这个文件存放所有数据库配置代码
* 使用SQLAlchemy ORM 定义数据库表
* 









## SQLModel

SqlModel 是FastAPI的创建者将SQLAlchemy和Pydantic整合到单一模型定义中。 

有的人不采用它，有如下几个原因：

* SQLAlchemy基本是Python操作数据库的行业标准
* 大多数生产级FastAPI应用都是用独立的SQLAlchemy模型和Pydantic模式
* SQLModel构建在SQLAlchemy和Pydantic两个库之上，所以分别了解两个库会让SQLModel在后续学习时更容易掌握
* 分离方法能给你更多的控制权，开发者经常需要为创建和返回数据设置不同字段

数据库模型包含ORM特有功能，例如，关联关系和数据库列类型

Pydantic模式则定义API契约--我们接收什么返回什么

保持数据库模型和Pydantic模式分裂，意味着我们可以单独修改某一层而不影响其他层。



## 数据流的运作方式

* 首先，请求进来后，Pydantic会先进行验证
* 随后，SQLAlchemy负责存储或检索数据
* 接着，Pydantic格式化响应
* 最后响应返回