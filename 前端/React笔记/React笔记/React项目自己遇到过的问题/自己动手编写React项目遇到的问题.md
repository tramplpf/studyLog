# 自己动手编写React项目遇到的问题

* 模块没有默认导出

  <img src="/Users/lpf/Library/Application Support/typora-user-images/image-20211127174137111.png" alt="image-20211127174137111" style="zoom:50%;" />

自己编写函数式组件Robot没有通过export 导出，只需要在Robot.tsx 中添加如下代码即可

```tsx
export default Robot
```



* react 函数中this的指向问题。

  将button的onClick中的实现逻辑提取到类组件中的时候，代码如下

  ```tsx
  handleClick(e){
  	this.setState({isOpening: !this.state.isOpen})
  }
  ```

  在上面的代码中，this表示handleClick 函数，而不是表示类组件。 为了让这里的this表示类组件， 有两种方式：

  方式一：通过箭头函数

  handleClick = (e) => {

  ​	this.setState({isOpen: !this.state.isOpen})

  }

  

  方式二：通过javascript的原生实现，bind 

  在类组件的构造方法中，添加如下代码

  this.handleClick = this.handleClick.bind(this)
  
* ![image-20211201231341733](/Users/lpf/github/studyLog/前端/React笔记/React笔记/React项目自己遇到过的问题/pic/003_useEffect遇到的问题.png)

解决方式

![image-20211201231532988](/Users/lpf/github/studyLog/前端/React笔记/React笔记/React项目自己遇到过的问题/pic/004_useEffect的解决方式.png)