# React 相关的笔记

0001_JSX的特点

元素是构成React 应用的最小单位。 
	与浏览器的DOM 元素不同，React 当中的元素事实上是普通的对象，React DOM 可以确保浏览器DOM 的数据内容与React 元素保持一致。 
元素事实上只是构成组件的一个部分。

要将React 元素渲染到根DOM 节点中，我们通过把它们都传递给 ReactDOM.render() 的方法来将其渲染到页面上。 

React 元素都是不可变的。 当元素被创建之后，你是无法改变其内容或属性的。 一个元素就好像是动画里的一帧，它代表应用界面在某一时间点的样子。 

目前，更新界面的唯一办法是创建一个新的元素，然后将它传入ReactDOM.render() 方法。 

组件可以将UI分成一些独立的，可复用的部分，这样，你就只需专注于构建每一个单独的部件。 
组件从概念上看就像是函数，它可以接收任意的输入值(称之为props),并返回一个需要在页面上展示的React 元素。 

定义一个组件最简单的方式就是使用JavaScript 函数。 
	
	function welcome(props){
			return <h1>Hello, {props.name}</h1>
	}

	这个函数就是一个有效的React 组件，它接收一个单一的props 对象并返回一个React元素。 我们之所以称这种类型的组件为函数定义组件，是因为从字面上看，它就是一个javascript 函数。 

也可以使用 ES6 class 来定义一个组件：
	
	class Welcome extends React.Component {
		render(){
			return <h1>Hello , {this.props.name}</h1>
		}
	}

React 元素可以是DOM 元素，也可以是用户自定义的组件
	const element = <Welcome name="Sara" />;

当React 遇到的元素是用户自定义的组件，它会将JSXs属性作为单个对象传递给该组件，这个对象称之为"props". 
