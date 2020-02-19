import java.lang.NumberFormatException
import kotlin.math.max

//Unit可以省略 就相当于Java的Void，“记住当函数什么都不返回的时候就是返回了Unit”
fun main(args: Array<String>):Unit {
    try {
        println("hello ${args[0]}")
        val arg1 = args[0].toInt()
        val arg2 = args[1].toInt()
        println("$arg1 + $arg2 = ${sum(arg1, arg2)}") //大括号你不加人家自己也会给你加上
        println(FunCastTest)
    } catch (E: NumberFormatException) {
        println("${E.message} 错误❌ program argument 的参数要写成数字哦")
    }
}
fun sum(arg1: Int, arg2: Int): Int {
    return arg1 + arg2
}
//需要终止程序运行：System.exit(0) ，括号里的数字以二进制补码 可以是其他的数字， 比如你填-1就是255
val FunCastTest = fun(x:Int): Long {
    return x.toLong()
    //注意它只有变量名，没有函数名，输出格式 println(FunCastTest(2))
    //所以函数也是一个类型， 可以被传递复制， 不过它本身就是代码块，引出了Lambda
}

