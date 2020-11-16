package leetcode.字节跳动题库

//https://leetcode-cn.com/problems/trapping-rain-water/
//https://zhuanlan.zhihu.com/p/125074613 (题解)
/**
 * 暴力法 时间复杂度O(n2) O(1)
 * 针对每个柱子,它能盛水的量相当于在它左方最高的柱子,和右方的最高的柱子中较短的那个
 * 减去当前高度,然后遍历每一个柱子,累加每个柱子的最大存水量
 * 注意: 遍历查找左右区间时要包含当前柱子,这是因为可能会出现拿到的最高柱子比当前柱子低
 * 导致差值也就是存水量变成负值,所以要保证最低不能低于当前柱子,即闭区间地遍历
 * */
fun trap(height: IntArray): Int {
    var res = 0
    val n = height.size
    if (n == 0) return 0
    // 跳过第一个和最后一个柱子
    for (i in 1 until n - 1) {
        var maxLeft = 0
        var maxRight = 0
        for (l in 1 .. i) maxLeft = maxLeft.coerceAtLeast(height[l])
        for (r in i until n) maxRight = maxRight.coerceAtLeast(height[r])
        res += maxLeft.coerceAtMost(maxRight) - height[i]
    }
    return res
}
/**
 * DP O(n) O(n): 在暴力法上进行记忆化
 * 分被从左和从右遍历每个柱子,将每个柱子左方最大的和右方最大的保存进二维数组的[0]和[1]*
 * 在历一遍,这次直接可以获取当前柱子左右最大的柱子,取最短的减去当前柱子高度就是存水量
 * */
fun  trap1(height: IntArray): Int {
    val n = height.size
    var res = 0
    if (n == 0) return 0
    val dp = Array(n) { IntArray(2)}
    // 一维下标表示柱子 0,1分别表示左右
    // 即dp[i][0]表示i这个柱子左方最大的长度
    dp[0][0] = height[0]
    dp[n - 1][1] = height[n - 1]
    // 初始左右
    for (i in 1 until n - 1) { // 从左边过来
        dp[i][0] = dp[i - 1][0].coerceAtLeast(height[i])
    }
    for (i in n - 2 downTo 1) { // 从右边过来
        dp[i][1] = dp[i + 1][1].coerceAtLeast(height[i])
    }
    // 每个有效柱都包含了其左右最大柱高的信息
    for (i in 1 until n - 1) {
        res += dp[i][0].coerceAtMost(dp[i][1]) - height[i]
    }
    return res
}
/**
 * 双指针 O(n) O(1): 在动态规划基础上缩减空间
 * 每个柱子的数组保留的信息只被使用了一次，那么我们尝试不使用数组
 * 逻辑：对于任意某柱子，比方说它是被左指针遍历到的，即此刻最大左边小于最大右边，那么就意味着它和
 * 它左边最大高的柱子是已知的，那么先判断完它是不是新的最大左柱，然后最大左柱减去它就是这个柱子最大存水量
 * 对于res操作时，比方说 右MAX的柱子 > 左MAX的柱子 >  大于当前柱子(左指针的)
 * 因为指针的遍历是从一边依次过来的，所以对于当前指针指向的柱子，可以确保它的max左/右
 * 就是左/右边最大的柱子，这一依据就是“单边依次遍历”
 * 所以这时左Max-当前柱子就是储水量。 ps： 如果当前柱子是单边最大，那么最大的更新为当前柱子
 * res = 当前柱子减去最大柱子 = 0
 * */
fun trap3(height: IntArray): Int {
    var left = 0; var right = height.size - 1;
    var maxLeft = 0; var maxRight = 0
    var res = 0
    while (left <= right) {
        // 以为是在每次操作完后进位,所以下一位还没来得及处理
        // 所以边界闭区间: 两指针共同相交指到的这个柱子需要一次操作
        if (maxLeft >= maxRight) {
            maxRight = maxRight.coerceAtLeast(height[right])
            res += maxRight - height[right--]
            // 向中间递进
        } else {
            maxLeft = maxLeft.coerceAtLeast(height[left])
            res += maxLeft - height[left++]
        }
    }
    return res
}
fun main() {
    trap3(intArrayOf(0,1,0,2,1,0,1,3,2,1,2,1))
}