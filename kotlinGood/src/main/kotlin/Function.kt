package com.kotlin

fun main(args: Array<String>):Unit{ //Unit可以省略 就相当于Java的Void，“记住当函数什么都不返回的时候就是返回了Unit”
    println("hello ${args[0]}") //“已经不是简单的变量了， 要用大括号”
/*
    里面的值在头顶的Edit Configuration “程序声明” program argument 编辑
    注意大括号和参数的类型转换!
*/
    var arg1 = args[0].toInt()
    var arg2 = args[1].toInt()
    println("$arg1 + $arg2 = ${sum(arg1, arg2)}") //大括号你不加人家自己也会给你加上
    println(FunCastTest(2))
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

