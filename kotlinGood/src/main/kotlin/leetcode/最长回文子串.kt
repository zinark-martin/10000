package leetcode
class Solution {
    fun longestPalindrome(s: String): String {
        if (s == "") return ""
        val reverse = s.reversed()
        val length = s.length
        val arr = Array(length) { IntArray(length) }
        var max = 0
        var end = 0

        for (i in s.indices)
            for (j in reverse.indices) {
                if (s[i] == reverse[j]) {
                    //找到疑似匹配字符
                    if (i == 0 || j == 0) {
                        //是任何一方的首字符的话
                        arr[i][j] = 1
                    }
                    //某时刻的长度就是上一个时刻长度加一
                    else {
                        arr[i][j] = arr[i - 1][j - 1] + 1
                    }
                }
                if (max < arr[i][j]) {
                    /** 为了防止"abc1223cba"这种反转也可以匹配的情况需要判断reverse末尾的字母下标
                     * 也就是j指的点的字母在原String是不是和original一个下标
                     * */
                    val was = length - 1 - j
                    //不等于就说明是另一处的字符
                    if (was == i + 1 - arr[i][j]) {
                        max = arr[i][j]
                        end = i
                    }
                }
            }
        return s.substring(end - max + 1, end + 1)
    }
}
