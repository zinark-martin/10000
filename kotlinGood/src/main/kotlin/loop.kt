fun main(args: Array<String>) {
    for ((index, value) in args.withIndex()){
        println("$index -> $value")
    }
    var x = 5
    while (x > 0) {
        println(x)
        x--
    }
    do {
        println()
        x--
    }while (x > 0)

    //for的三个不同的写法或方法
    args.forEach { println(it) }
    args.forEach (::println)
    args.forEach FE@{
        //相识C语言的goto关键字
        if (it == "4") return@FE
        println(it)
    }
    var loop = 10
    //也可以在选择结束那一层循环的地方使用标签
    outer@ while(loop != 0) {
        loop--
        inner@ while (loop!=0) {
            loop--
            println(loop)
            if (loop == 5) break@outer
        }
    }

}