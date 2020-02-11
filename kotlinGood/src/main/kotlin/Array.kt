private val intArray: IntArray = intArrayOf(1,2,3)
private val array: Array<Int> = arrayOf(1,2,3)
private val charArray: CharArray = charArrayOf('h','e','l','l','o')
//尽量用具体类型的数组, 这样可以避免装箱和开箱的开销

fun main() {
    println(charArray)
    println(charArray.joinToString("|"))
    println(charArray.joinToString())//默认是","

    println(charArray.slice(1 until 3))
    println(charArray.slice(1..3))
}
