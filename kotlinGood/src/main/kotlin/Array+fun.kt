
private val intArray: IntArray = intArrayOf(1,2,3)
//尽量用具体类型的数组, 这样可以避免装箱和开箱的开销
private val charArray: CharArray = charArrayOf('h','e','l','l','o')
private val array: Array<Int> = arrayOf(1,2,3)

fun main(args: Array<String>) {
    println(charArray)
    println(charArray.joinToString("|"))
    println(charArray.joinToString())//默认是","

    println(charArray.joinToString("").slice(0 until 3))
    println(charArray.slice(1..3))
    //two 和 one 的值都是一个匿名函数, 需要写上参数
    println(two(3,5))
    println(one.invoke(2+5))
}
//将匿名函数赋值给一个变量
//函数体是表达式的话返回值是Unit类型, 相当于执行里面的表达式
var two = fun (x: Int, y: Int) = println("$x + $y = 哈哈哈哈" )
//返回值为Int类型
var one = fun (z: Int) = z * 10

