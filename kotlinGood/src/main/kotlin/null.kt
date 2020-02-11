@file:Suppress("CAST_NEVER_SUCCEEDS")

fun getName():String? {
    return null;
}
fun main(args: Array<String>) {
    val testVal: String? = "测试"
    println(testVal!!.length) //断言安全符


    val string:String? = "智能转换"
    if (string is String)
        println(string.length)//Smart cast to kotlin.String

    val person:Person = Person("name")
    val woman:Woman? = person as? Woman //如果person是woman的子类就会指向person, 如果不是, 就会赋值null, 避免异常
    println(woman)

    println(getName()!!.length)//把空值断言为非空才会抛异常
    val name: String = getName()?: return //赋值, 如果空就返回
    println(name.length)
}