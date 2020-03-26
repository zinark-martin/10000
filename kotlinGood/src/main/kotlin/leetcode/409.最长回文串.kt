package leetcode


/**
 * title: 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串
 *要点: 除了要熟练map的操作以外, 需要注意, 只要是偶数就全加, 基数就退一位变成偶数再全加
 * 这样同时筛选了所有出现一次的字符, 所以最后的ans长度不等于给的s
 * 而结果可以选一个各位字符作为核心的字母, 所以ans再加上一就好了s
 * */
fun longestPalindrome(s: String): Int {
    val map:MutableMap<Char,Int> = mutableMapOf()
    var ans = 0
    for (i in s) {
        if (map.containsKey(i)) {
            map[i] = map[i]!! + 1
        } else {
            map[i] = 1

        }
    }
    map.values.forEach { ans += it / 2 * 2 }
    return if (ans == s.length) ans else ans + 1
}

fun main(args: Array<String>) {
    println(longestPalindrome("vocal"))
}