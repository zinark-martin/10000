import java.lang.NumberFormatException
import java.lang.UnsupportedOperationException
import kotlin.String as String1

fun main(args: Array<String1>) {
    while (true) {
        try {
            println("请输入二元算式, 用空格分割")
            //若是NULL则直接break循环
            val input = readLine() ?: break
            val splits = input.trim().split(" ")
            if (splits.size < 3) {
                throw IllegalArgumentException("数位不够. 没有使用空格分割?")
            }
            val arg1 = splits[0].toDouble()
            val arg2 = splits[2].toDouble()
            val op = splits[1]
            //println("$arg1 $op $arg2 = ${Calculator(op).opFun(arg1, arg2)}") 相当于调用并输出opFun的值
            //重新定义class的操作符"invoke"后:
            println("$arg1 $op $arg2 = ${Calculator(op)(arg1, arg2)}")
            println("是否继续运算?[Y]")
            val cmd = readLine()
            if (cmd != "y" || cmd.toLowerCase() != "y") {
                break
            }
        } catch (E: NumberFormatException) {
            println("! 确定是正确格式数字吗?")
        } catch (E:IllegalArgumentException) {
            //println("! 请输入使用空格分割的三个参数")
            //这里的内容会覆盖掉throw的内容, 若想现实throw的内容就输出E.message
            println(E.message)
        } catch (E:Exception) {
            println("! 程序出现异常 ${E.message}")
        }
    }
    println("Thanks for using!")
}
//先传经来op
class Calculator(op: String1) {
    //属性先不动 没有初始化
    val opFun: (left: Double, right: Double) -> Double
    //根据类的参数op和opFun的参数初始化opFun属性, lambda表达式里面的字母只是代表第1,2个参数, 所以填什么都一样
    init {
        opFun = when(op){
            "+" -> {a,b -> a + b}//你填什么都可以
            "-" -> {l,r -> l - r}
            "*" -> {l,r -> l * r}
            "/" -> {l,r -> l / r}
            "%" -> {l,r -> l % r}
            else -> throw UnsupportedOperationException("符号 $op 超出运算支持范围")
        }
    }
    //println("$arg1 $op $arg2 = ${Calculator(op).opFun(arg1, arg2)}") 使用".opFun"时可以不用以下内容
    //重写 Class 中的操作符"invoke"
    operator fun invoke(left: Double, right: Double): Double {
        return opFun(left,right)
    }
}
