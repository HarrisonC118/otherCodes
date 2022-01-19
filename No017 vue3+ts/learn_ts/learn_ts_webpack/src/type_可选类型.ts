// 在参数名后面加个'?'就证明是可选的
function hello(message: {title: string, time?: string}) {}
hello({title:"你好",time:"啊这"})
hello({title:"你好"})
export {}