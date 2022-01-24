// 定义一个函数的类型
type FooFnType = (a:number,b:string) => void
// 实现一个符合函数类型的函数
const messFn:FooFnType = (len:number, message:string) => {
    console.log("test")
}

// 接收一个指定类型的函数作为参数
function c (runFN:FooFnType) {
    runFN(123,"456");
}
export {}