package leetcode

/**
* 判断一个字符串能不能组成一个回文string
* 回文串的特点, 除了最中间一个可以是单个字符, 以外的位置都有以中心字符对称的双数重复字符
* */
fun canPermutePalindrome(s: String): Boolean {
    val res = HashSet<Char>()
    s.forEach {
        if (res.contains(it)) {
            res.remove(it)
        } else {
            res.add(it)
        }
    }
    return res.size <= 1
}
