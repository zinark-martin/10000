package leetcode.字符串与数组与矩阵

//https://leetcode-cn.com/problems/longest-increasing-subsequence/
/**
 * 动态规划
 * 为了解决下面错误思想的取舍问题,使用动态方程,将状态量定义为每个数字前面有
 * "几个"上升子序列,默认每个数字都是新的起点,即为1
 * 这样遇到了需要取舍的数字时,只需要找到最近一个比它小的数字,查看其状态量,知道了以
 * 这个数字为结尾的上升子序列长度后,回来给当前遇到的这个数字的状态量加一,表示一个新的以它为
 * 结尾的子序列产生,结束O(n2)的处理后,查找状态量数组中最大的长度就行了*/
 /* 注意! 当向后查找时,可以存在有几个子序都可以满足条件,
 * 这样的话要求我们必须全部遍历前面的数字对应的状态量来跟新为最大的值
 * 无论这个数字是否大于前面一个数字,都去要找遍前面的最大的子序结尾数,所以双重for循环,不需要判断
 * */
fun lengthOfLIS(nums: IntArray): Int? {
    if (nums.size == 1) return 1
    if (nums.isEmpty()) return 0
    val dp = IntArray(nums.size).apply {
        fill(1, 0, nums.size)
    }
    for (i in 1 until nums.size) {
        // 遍历数组
        for (j in i - 1 downTo 0) {
            // 回头看,到找到比它小的
            if (nums[j] < nums[i]) {
                // 其子序长度相对于比它小的这个数的子序长度增加一位
                dp[i] = dp[i].coerceAtLeast(dp[j] + 1)
            }
        }
    }
    return dp.max()
}
/**
 * 使用动态规划 + 二分查找
 * 思想: 多一个数字,记录每个下标长度对应的最长子序的末尾数字
 * 即,把数组下标作为每个不同的子序的长度,值就是对应长度的子序的末尾值
 * 当发现一个新的值时,可以查找到数组中比当前数字还小的数字,然后换掉这个数字
 * 替换的逻辑是: 对于同一个长度的子序列,更小的末尾数字再往后能延续子序列的概率最大
 * 所以我们要保证每个序列的末尾数字都是同样可行的数字里,最小的
 * 如果遇到的数字更大,就说明不用替换可以延续子序,直接将它加到下一位,即新下标长度子序的末尾数字是它
 * 因为状态数组是从小到大的已排列数组,所以搜索使用手写/库函数的二分查找降低时间复杂度
 * */
fun lengthOfLIS2(nums: IntArray): Int {
    if (nums.isEmpty()|| nums.size == 1) return 0
    var res = 0
    // res代表状态数组最右下标
    // 注意: res始终指向的是数组中最末有效数字的下一位,返回时也是直接返回
    val dp = IntArray(nums.size).apply {
        fill(1,0,nums.size)
    }
    for (num in nums) {
        // 双指针
        var i = 0;
        var j = res
        while (i < j) {
            // 二分查找在这里的目的不是找到相同的目标数字
            // 而是找到刚刚小于前面一个数的位置,所以循环条件是双指针碰撞时
            // 因为这里判定"太大"的条件包括"等于",即若查到的数字等于被查数字
            // 我们认为过大,需要更新右边界为这个等于目标的数字,再在其左边区域查找
            // 所以双指针碰撞时的数字就是刚比被查找数字小一位的数字
            val m = (i + j) / 2
            if (dp[m] < num) i = m + 1 // 太小了
            else j = m // 太大了
        }
        dp[i] = num
        // 如果j还是等于res说明新的数字被添加到了最前端
        if (j == res) res++
    }
    return res
}

fun main() {
    println(lengthOfLIS(intArrayOf(100,4,200,1,3,2)))
}
//这写的时候是按照连续写的
fun lengthOfLCIS(nums: IntArray): Int {
    /**边界条件一定要设置 因为我们是从第二位开始遍历的*/
    if (nums.isEmpty()) return 0
    if (nums.size == 1) return 1
    var max = 1
    var curr = 1
    for (i in 1 until nums.size)
        if (nums[i] > nums[i - 1])
            max = max.coerceAtLeast(++curr)
            // 先将位数自增再更新result
        else curr = 1
    return max
}