import java.lang.StringBuilder
import kotlin.reflect.KProperty

fun main(args: Array<String>) {
    println("abc".myMultiply(10))//添加工具
    println("bca"*3);println("bca".times(3))//重载了操作符方法(前后一样)
    println(" ".abc)
    val delegates  = Delegates()
    println()
}
//添加扩展工具给String类型

fun String.myMultiply(int:Int):String {
    val stringBuffer = StringBuilder()
    for (i in 0 until int) {
        //"this"指调用它的对象, 也就是String
        stringBuffer.append(this)
    }
    return stringBuffer.toString()
}
//重载了操作符方法
operator fun String.times(int: Int): String {
    val stringBuffer = StringBuilder("就不输出你想要的")
    for (i in 0 until int) { //"this"指调用它的对象, 也就是String
        stringBuffer.append("c:")
    }
    return stringBuffer.toString()
}
//也可定义一个值, 但是不能初始化必须用getter 类似接口
val String.abc:String
    get() = "秘密abc"

//代理Delegates 对于val代理的代理对象, 必须有getValue方一样的法
class Delegates{
    val hello by lazy {
        "HelloNMBのKitty"
    }
    val world by X()
}
class X{
    operator fun getValue(thisRef:Any?, property:KProperty<*>): String {
        return "world"
    }
}