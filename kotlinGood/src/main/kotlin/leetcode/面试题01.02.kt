package leetcode

import java.util.*

fun CheckPermutation(s1: String, s2: String): Boolean {
    return (s1.toSortedSet() == s2.toSortedSet())
}
fun main() {
    println(CheckPermutation("abc","bca"))
}
