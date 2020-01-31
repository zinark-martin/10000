package com.kotlin

val FINAL_YO: String = "YO! 外星人"
val FINAL_HI = "HI! 地球人"
var hi = "hi"
var array0:IntArray = IntArray(5)
var array00 = IntArray(5)
var array:IntArray = intArrayOf(1,2,3,4)
var test = array
/*以上是val类型*和Kotlin的类型推导**
*val*就相当于Java的Final类型
*类型推导** 只要是编译器能猜到的类型都可以不用写类型*/

fun main() {
    println(hi)
    println(FINAL_YO)
    println(FINAL_HI )
    println(array.toString())
}