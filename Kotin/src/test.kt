package com.kotlin

/*区间
* 各种区间都是CloseRange的子类, IntRange 最常用
* 基本使用for(i in Range), 0..10, 0 until 100, i in 0..100*/
fun main() {
    val emptyRange:IntRange = 0..-8//倒着放就是零
    val emptyRange2:IntProgression = 0 downTo 9//把本来的正数倒着放也是零
    val nagativeNumbers:IntProgression = 0 downTo -21

    val testRange: IntRange = -9 until 0
    val range:IntRange = 3..5
    for (i in nagativeNumbers) {
        println(i)
        println(nagativeNumbers.toString().length)
    }
    println(emptyRange.isEmpty())
    println(emptyRange2.isEmpty())
    println(range.toString().length)//长度很迷
}