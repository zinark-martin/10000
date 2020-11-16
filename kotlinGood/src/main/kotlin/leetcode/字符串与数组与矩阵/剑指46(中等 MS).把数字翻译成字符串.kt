package leetcode.字符串与数组与矩阵

/**
 * 首先字母有26个,范围是0~25
 * 也就是说在个位数和十位数中考虑,其中十位数又可以拆分为两个个位数
 * 对于一个十位数,它的最大值应该是25,最小应该是10,因为如果小于10意味着这个两位数字十位为零,
 * 不合法:09 02
 * 动态规划:
 * dp[i]代表前i个数字有集中组合,我们将dp[0] = 1 也就是0个数字时的结果设置为1
 * 为了方便处理边界,比如最小满足循环条件的两位数字12: dp[2] = dp[2-1] + dp[2-2] 的计算
 * 动态规划的逻辑在于
 * 1.如果i和i-1组成的两位数字无法满足条件,就说明不能形成一个两位数的组合
 *  那么相当于又前驱了一个数字,所以组合数量并没有改变,如: 543到5432是一个组合
 * 2.如果i和i-1组成的两位数组满足区间条件,那么除了本来这一个组合(dp[i-1])外,
 *  又多了不算这两个数字时的组合,因为这两个数字看作了一个新的整体,相当于dp[i-(1+1)]即dp[i-2]
 *  两个相加就是dp[i]的组合数
 * */
/*
 * 注意: 在kt中 >= <= < >等符号可以直接使用,都相当于compareTo*/
fun translateNum(num: Int): Int {
    val s = num.toString()
    // pre,back 分别表示当前遍历的数字i,的上一位和i与它上一位数字的组合的上一位
    var right = 1
    // 这个初始代表的是第1个数字
    var left = 1
    // 这个初始代表的是第0个数字
    for (i in 2..s.length) {
        val double = s.substring(i - 2, i)
        val curr = if (double >= "10" && double <= "25") right + left else right
        left = right
        right = curr
    }
    return right
}
fun main() {
    println(translateNum(2))
}