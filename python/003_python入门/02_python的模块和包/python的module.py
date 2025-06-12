# Python的module功能

## 模块

### 模块导入的语法

```python
import 模块名
import 模块名 as 别名
from 模块名 import 功能名
from 模块名 import *
from 模块名 import 功能名 as 别名
```

### 制作模块
在Python中，每个python文件都可以作为一个模块，模块的名字就是文件的名字。也就是说自定义模块名必须要符合标识符命名规则

#### 定义模块
新建一个Python文件，命名为my_module1.py, 并定义testA函数

```python
def testA(a, b):
    print(a+b)

#### 测试模块
当开发人员编写完成一个模块后，为了让模块能够在项目中达到想要的效果，这个开发人员会自行在py文件中添加一些测试 信息。 

```python
def testA(a,b):
    print(a+b)


# 只在当前文件中调用该函数，其它导入的文件内不符合该条件，则不执行testA函数调用
if __name__ =='__main__':
    testA(1,3)

```

### 模块的定位顺序

当导入一个模块，Python解释器对模块位置的搜索顺序是：
1. 当前目录
2. 如果不在当前目录，Python则搜索在shell变量PYTHONPATH下的每个目录
3. 如果找不到，Python会察看默认路径。 UNIX下，默认路径一般是/usr/local/lib/python/

模块搜索路径存储在system模块的sys.path变量中。 变量里包含当前目录。 PYTHONPATH和由安装过程决定的默认目录

* 注意
    * 自己的文件名不要和已有的模块名重复，否则导致模块功能无法使用
    * 使用 from 模块名 import 功能的时候，如果功能名重复，调用到的是最后定义或导入的功能


### __all__
如果一个模块文件中有__all__变量，当使用 from xxx import * 导入时，只能导入这个列表中的元素,因为无法通过 from xxx import * 的方式导入，因此不在__all__ 中的变量无法直接使用，但是可以通过模块名.方法名的方式进行调用


## 包
包将有联系的模块组织在一起，即放到同一个文件夹下，并且在这个文件夹创建一个名字为__init__.py 文件，那么这个文件夹就称之为包。 

### 制作包
注意： 新建包后，包内部会自动创建__init__.py 文件，这个文件控制着包的导入行为。 


### 导入包
方法一：
```python
import 包名.模块名

包名.模块名.目标
```

方法二：
注意： 必须在__init__.py 文件中添加__all__ = [], 控制运行导入的模块列表


## 模块和包的总结
* 导入模块方法

```python
import 模块名
from 模块名 import 目标
from 模块名 import * 
```

* 导入包
```python
import 包名.模块名
from 包名 import *
```

* __all__ = []： 允许导入的模块或功能列表


## 思考
模块定义时如何和类很好的整合

个人理解： 模块中定义的方法，可以使用类进行封装。
