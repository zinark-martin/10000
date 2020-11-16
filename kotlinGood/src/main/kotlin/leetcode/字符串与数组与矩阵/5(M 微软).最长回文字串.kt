package leetcode.字符串与数组与矩阵
/**
 * 动态规划
 * 思路:对于每个字串,它是否是回文串取决于两端是否相等 + 去掉两端后中间这个字串是否回文
 * 那么我们需要一个二位数组,记录以两个Int作为下标的字串是否是回文的
 * 先来一个O(n)遍历将所有的两个指针指向相同的位置设为true,也就是所有单一字符
 * 再来一个O(n2)的遍历判断每个矩阵中的位置,也就是S的每一段字串
 * 若两端不相同一定不是回文,否则且若字串只由两端构成则一定是回文,再否则就由这个字串包裹的最大字串决定它是不是回文
 * 每次更新最大长度的同时更新起始位置,这样最后返回从起始位置截取max长度的字串就🆗*/
fun longestPalindrome(s: String): String {
    val n = s.length
    if (n < 2)
        return s
    var max = 1
    var begin = 0
    val dp = Array(n) { BooleanArray(n)}
    // 记录某两个下标之间的子串是否是回文的二维布尔类型数组
    for (idx in 0 until n)
        dp[idx][idx] = true
        // 所有对角线都是[idx][idx]即这个数字本身,所以都是true
    for (i in 1 until n) {
        for (j in 0 until i) {
            //i作为前驱指针,j作为后指针在当前位置与前驱指针i之间前驱
            when {
                s[i] != s[j] -> {
                    dp[i][j] = false
                    //两头不一样,那么以i,j为下标的这个字串就是非回文
                }
                i - j <= 2 -> {
                    dp[i][j] = true
                }
                else -> {
                    dp[i][j] = dp[i - 1][j + 1]
                    //双向分别向内收紧一位下标
                }
            }
            //只有出现最大长度时才同时更新max和起始位置
            if (dp[i][j] && i - j + 1 > max) {
                max = i - j + 1
                begin = j
                //更新长度和最长回文字串的起始位置
            }
        }
    }
    // 截取从起始位置往前最大长度的字串
    return s.substring(begin, begin + max)
}
fun main(args: Array<String>) {
    println(longestPalindrome("aaaaaaaaaa"))
}