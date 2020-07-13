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
                //相当于自定义抛出异常信息, 在E.message中
                throw IllegalArgumentException("数位不够. 没有使用空格分割?")
            }
            val arg1 = splits[0].toDouble()
            val arg2 = splits[2].toDouble()
            val op = splits[1]
            //println("$arg1 $op $arg2 = ${Calculator(op).opFun(arg1, arg2)}") 相当于调用并输出opFun的值
            //重新定义class的操作符"invoke"后:
            println("$arg1 $op $arg2 = ${Calculator(op)(arg1, arg2)}")
            //println(Calculator(op).opFun(arg1, arg2)) //这是原始写法
            val cal = Calculator(op) //创建对象的写法
            println(cal(arg1,arg2))
            
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
    val opFun : (left: Double, right: Double) -> Double
    private val opFun2: (int:Int) -> Int
    init {
        opFun = when(op){
            "+" -> {x,y -> x + y}//你填什么都可以
            "-" -> {l,r -> l - r}
            "*" -> {l,r -> l * r}
            "/" -> {l,r -> l / r}
            "%" -> {l,r -> l % r}
            else -> throw UnsupportedOperationException("符号 $op 超出运算支持范围")
        }
        opFun2 = if (true) {
            {x -> x + 2}
        } else {
            {7}
        }
    }
    //println("$arg1 $op $arg2 = ${Calculator(op).opFun(arg1, arg2)}") 使用".opFun"时可以不用以下内容
    //重写 Class 中的操作符"invoke"
    operator fun invoke(left: Double, right: Double): Double {
        return opFun(left,right)
    }
}
