// 如果有人修改了源码中的联合类型，但是代码中没有对应的处理
// 就会执行defalut，但是never的值是不能赋值的，所以就会报错
function foo(message: string | number){
    switch(typeof message) {
        case 'string':
            console.log("string类型")
            break;
        case 'number':
            console.log("number类型")
            break;
        default:
            const check: never = message
    }
}
export {}