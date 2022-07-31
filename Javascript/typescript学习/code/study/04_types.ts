// object 表示一个js对象, 
// ts中object可以表示任何类型，如果将类型设置为object，意义不大，比较好的做法是，将类型设置为 {}
let a1: object;
a1 = {}
a1 = function(){}

// {} 用来指定对象中可以包含哪些属性
// 语法： {属性名: 属性值，属性名：属性值}  
// 语法： {属性名: 属性值，属性名？：属性值} 属性名后面加一个？ ，表示属性是可选的
// 语法： {属性名1: 属性值，[propName:string]:any}   表示属性名1 必须有，其他属性可有可无。，有什么属性都可以
let b1 :{name1:string}
b1 = {name1:"lpf"}
// 定义好属性名和属性值之后，不能有多余的属性名和属性值
//b1 = {name1:"lpf",age:11}



/**
 * 设置函数结构的类型声明：
 *    语法：（形参：类型，形参：类型 ...） => 返回值
 *    
 */
let d1 :(a:number, b:number) => number;
d1 = function(a:number,b:number):number{
  return a + b;
}

/**
 * 数组的类型声明
 *        类型[]
 *        Array<类型>
 */
// 数组array
// string[] 表示字符串类型的数组
let e1 : string[]
e1 = ['a','b','c']

// number[] 表示数值类型的数组
let f1 :number[]
f1 = [1,2,3,]

let f2:Array<number>
f2 = [3,4,5]

let f3 : Array<any>
f3 = [1,2,"aa"]


// tuple ，元组合，是ts中新增的类型，
// 元组就是固定长度的数组
//    语法： [类型，类型，类型]
let h: [string,string]
h = ["hello","world"]

let h2 :[string,number]
h2 = ["hello",123]

/**
 * enum： 枚举
 * 
 */

