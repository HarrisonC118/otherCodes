class Person {

}
class Student extends Person {
    studying() {

    }
}

function learnSometing(per: Person) {
    // 类型“Person”上不存在属性“studying”。
    //per.studying();
    (per as Student).studying();
}
export {}