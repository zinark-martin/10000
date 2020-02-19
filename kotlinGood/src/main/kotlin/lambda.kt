
val sum = { arg1: Int, arg2:Int -> arg1 + arg2
    println("$arg1 $arg2")} //regard the function as a variable

fun main(args: Array<String>) {
    args.forEach(::print)
    args.forEach ForEach@{
        if (it == "34") return@ForEach //注意标签变到了前面, 而且和return是一体的
        println(it)
    }
    println(sum(2, 8))
    println(sum.invoke(2, 3))//invoke() is unnecessary
}
class gs {
    private val a: Int = 0
        get() {
            return field
        }
}