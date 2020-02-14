fun main(args: Array<String>) {
    val list = arrayListOf(1,2,3,4,5,6,7,8)
    val intArray = intArrayOf(8, 7, 6, 5, 4, 3, 2, 1)
    //使用(只能)展开数组的符号*
    strength(3.0 ,1,1,intArray[2],*intArray,string = "not yet", string2 = "end")
}

//变长参数 vararg关键字, 可以放在参数列的任何位置
//但是注意后面的参数在输入时要写上参数名=value 否则会被认为还是变长参数的一部分
fun strength (double: Double = 3.0, vararg ints:Int, string: String, string2: String) {
    ints.forEach(::println)
    println(string + "$double"); println(string2)
}