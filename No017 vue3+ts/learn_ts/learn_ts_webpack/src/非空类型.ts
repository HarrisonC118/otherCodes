function say(message?:string) {
    // 编译时报错，因为可选类型有可能为空
    //console.log(message.length)
    
    // 使用 ! 告诉ts编译器这个值一定不为空
    console.log(message!.length)
}

say("123")
export {}