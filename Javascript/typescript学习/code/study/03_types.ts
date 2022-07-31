// 可以直接使用字面量进行类型声明, 字面量，其值只能是声明时的值。 不能给他重新赋其他值
let m:10;
m = 10;
// m = 11;

// 可以使用 ｜ 来连接多个值，或者多个类型
let  b: "male"  | "female"
b = "male"
b = "female"

let d : boolean | string;
c = true;
// 视频中说一个变量可以设置两种类型，这里不知道为什么不能
// c = 'hello';

// any 就是可以是任何类型。
// 一个变量设置类型为any后，相当于对改变量关闭了TS的类型检测，所以在使用TS的时候，不建议使用any类型
let n:any;
n = 1;
n = "abc";
n = false

// 声明变量，如果不指定类型，则TS解析器会自动判断变量的类型为any（隐式any）
let n1;

// 当变量的类型不确定时候，类型可以使用 unknown,表示类型安全的any
let e : unknown;
e = 10;
e = "hello"
e = false

let s :string;
// n 的类型是any，可以赋值给任意类型
s = n;
// e的类型是unknown，不可以赋值给其他非unknown的类型
// s = e;
// unknown 类型的值，不能智能赋值给其他变量，可以通过typeof 进行类型判断来赋值
if (typeof e === "string"){
  s = e;
}


let s1:unknown
s1 = e



// 类型断言： 可以用来告诉解释器 变量的类型就是某种类型，
/**
 * 语法一： 变量名 as 类型名
 * 语法二： <类型名> 变量名
 */
s = e as string;
s = <string>e ;



// 这里函数fn的返回值类型是 boolean｜123 。
function fn(num:number){
  if(num > 0){
    return true;
  }else{
    return 123;
  }
}

// never 永远不会有返回值，场景比较少
function fn2():never{
  // 抛出错误的时候，是不会有返回值的，
  throw new Error("error mgs")
}