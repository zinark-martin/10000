
class OperateTest(private var argOne:Int, private var argTwo:Int) {
    operator fun plus(classArgs:OperateTest): OperateTest {
        //因为类的主构造器内的变量是被修饰的成员变量, 所以可以相当于类的成员变量作为参数传给fun的参数
        return OperateTest(argOne + classArgs.argOne, argTwo + classArgs.argTwo)
    }

    override fun toString(): String {
        return "$argTwo + $argOne = " + (argOne + argTwo)
    }
}

fun main() {
    //因为返回值的类型是类的类型!
    val testPlus1 = OperateTest(3,7)
    val testPlus2 = OperateTest(5,6)
    println(testPlus1 + testPlus2)
    println(1+2)
    val password = readLine()

    val ruguo:Unit = if (password!!.isNotEmpty()){
        println("你好")
    } else{
        println("假的")
    }
    println(ruguo.javaClass.simpleName)

    val x = readLine()?.toInt()
    if (x!=0) return println(x) else return
}