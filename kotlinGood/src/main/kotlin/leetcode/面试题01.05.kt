package leetcode

import kotlin.math.absoluteValue

/**
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。
 * 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 */
fun oneEditAway(first: String, second: String): Boolean {
    if ((first.length - second.length).absoluteValue > 1) {
        return false
    }
    var count = 0
    for (i in 0 until  first.length.coerceAtMost(second.length)) {
       if (first[i] == second[i])  {
           count++
       } else {
           //跳过前面一致的部分
           //因为只有一次不一样的机会, 一旦出现不一致就判断性返回
           return first.substring(count, first.length) == second.substring(count+1, second.length)
                   || first.substring(count+1, first.length) == second.substring(count, second.length)
                   || first.substring(count+1, first.length) == second.substring(count+1, second.length)

       }
    }
    return true
}
fun main() {
    println(oneEditAway("islander", "slander"))
}

