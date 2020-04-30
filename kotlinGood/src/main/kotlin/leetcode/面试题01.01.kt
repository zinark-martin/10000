package leetcode

import java.util.*

fun main(args: Array<String>) {
    println(isUnique("false"))
}

fun isUnique(astr: String) : Boolean {
    val stack = Stack<Char>()
    for (c in astr) {
        if (stack.contains(c))
            return false
        stack.push(c)
    }
    return true
}
