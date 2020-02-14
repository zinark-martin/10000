import com.kotlin.sum

val sum = { arg1: Int, arg2:Int -> arg1 + arg2
    println("$arg1 $arg2")} //regard the function as a variable

fun main(args: Array<String>) {
    args.forEach(::print)
    args.forEach ForEach@{
        if (it == "34") return@ForEach
        println(it)
    }
    println(sum(2,8))
    println(sum.invoke(2,3))//invoke() is unnecessary
}
class gs {
    private var a: Int = 4
    get() = field 
}