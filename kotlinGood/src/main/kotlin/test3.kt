
fun main() {
    while (true) {
        val read = readLine()
        if (read.toString() == "123") {
            break
        }else {
            println(read?.toInt())
        }
    }
    /**
     * 错误写法
     * println里面输出的是新的readLine的内容
     * 等同nextInt两遍
     * */
    while (true) {
        if (readLine().toString() == "123") {
            break
        } else {
            println(readLine()?.toInt())
        }
    }

    val (x, y) = readLine()!!.split("x").map{
        key -> key.toInt()
    }
    //kotlin高阶函数, 函数类型的参数, 可以自定义函数写进去也可以使用lambda当场编写逻辑
    //但是要注意看看源码让参数类型匹配, 为了防止混淆有时要再左边加限定符
    //上下两行表达式相等
    val (a, b) = readLine()!!.split(' ').map(String::toInt)
    println(x + y);println(a + b)
     fun <T, R> T.run(f: T.() -> R): R = f()
    "testRun".run {
        println("this = $this")
    }.let { println(it) }

    var list = mutableListOf<Int>()

    fun function(S: Int) = S % 2 != 0
    val 匿名函数对象 = fun(_:Int) = x<3
    //1.函数类型的对象传参数
    println(list.filter(::function))
    //2.lambda表达式
    println(list.filter { it % 2 != 0 })
    //3.匿名函数对象传参数
    println(匿名函数对象)

}