// 声明一个变量a，同时指定它的类型为number 
var a;
a = 1;
console.info(a);
a = 3;
// 注意，在默认情况下，tsc对ts文件进行编译，即使不满足类型，也好是会生成js文件的
//a = 'hello'  // 在ts中，不能将字符串赋值给number类型的变量a，所以这里会有报错信息
// 声明完变量后直接进行赋值
//let c : boolean  = false
// 如果变量的声明和赋值是同时进行的，TS可以自动对变量进行类型检测
var c = false;
c = true;
// js风格的函数定义
function sum(a, b) {
    return a + b;
}
console.info(sum(123, 321));
console.info(sum(123, "321"));
function sumall(a, b) {
    return a + b;
}
console.info(sumall(123, 321));
// 因为sumall 函数采用ts的语法，在编译阶段，就会提示类型错误，帮我我们提前进行修改
//console.info(sumall(123,"321"))
