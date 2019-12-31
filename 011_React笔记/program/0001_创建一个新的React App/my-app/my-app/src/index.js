import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import * as serviceWorker from './serviceWorker';

//ReactDOM.render(<App />, document.getElementById('root'));

//ReactDOM.render(
//	<h1>Hello, World! </h1>,
//	document.getElementById('root')
//);

function formatName(user) {
    return user.firstName + ' ' + user.lastName;
}

// 在if 或者for 语句里面使用JSX,将它赋值给变量，当作参数传入，作为返回值也可以。 
function getGreeting(user) {
    if (user) {
        return <h1>Hello , {formatName(user)}</h1>
    }
    return <h1>Hello, Stranger.</h1>;
}

//const user = {
//	firstName:'L_',
//	lastName:'PF'
//};

const user = {};

const element0 = (
<h1> 
		Hello, {formatName(user)}
	</h1>
);

const element = (
<h1>
		{getGreeting()}!
	</h1>
);



// ReactDOM.render(
//     element,
//     document.getElementById('root')
// );


function Welcome(props){
	return <h1>Hello, {props.name}</h1>
}
const element3 = <Welcome name="Sara"/>
// ReactDOM.render(
// 	element3,
// 	document.getElementById('root')
// );

function App2(){
	return(
		<div>
			<Welcome name="Sara"/>
			<Welcome name="Cahal"/>
			<Welcome name="Edite"/>
		</div>
	);
}

// ReactDOM.render(
// 	<App2/>,
// 	document.getElementById('root')
// );


// 提取组件 

function Avatar(props){
	return (
		<img className="Avatar"
			src={props.user.avatarUrl}
			alt={props.user.name}
		/>
	);
}

function Comment(props){
	return(
		<div className="Comment">
			<div className="UserInfo">
				<Avatar user={props.author} />
				<div className="UserInfo-name">
					{props.author.name}
				</div>
			</div>
			<div className="Comment-text">
				{props.text}
			</div>
		</div>
	);
}

const user2 = {
	author:{
		name:'lpf'
	},
	text:'test text '
}

const element4 = (
	<div>
		Hello, {Comment(user2)}
	</div>
)

ReactDOM.render(
	element4,
	document.getElementById('root')
);

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
//serviceWorker.unregister();
serviceWorker.register();
