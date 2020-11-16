package leetcode.字节跳动题库

fun maxProfit(prices: IntArray): Int {
    if (prices.isEmpty()) return 0
    val dp = Array(prices.size){ 0 }
    // 初始收益为零
    // 因为下面直接从下标为1的地方开始,所以mutableListOf无法直接定义长度
    // 初始化也只能添加第一个数字,所以我们使用定长数组
    var minPrice = prices[0]
    // 默认最小值为第一个值
    for (i in 1 until prices.size) {
        minPrice = minPrice.coerceAtMost(prices[i])
        // 是否更新最小值
        dp[i] = dp[i - 1].coerceAtLeast(prices[i] - minPrice)
        // 这一次和已知最小值的差值是否比上一次的大
        println(dp.toList())
    }
    return dp.last()
}

/**
 * * 数组使用的额外空间其实可以避免
 * 我们使用一个变量缓存
 * 最小利益初始为0 最小价格初始为第一天价格*/
fun maxProfit1(prices: IntArray): Int {
    if (prices.isEmpty()) return 0
    var max = 0
    var minPrice = prices[0]
    for (i in prices.indices) {
        minPrice = minPrice.coerceAtMost(prices[i])
        max = max.coerceAtLeast(prices[i] - minPrice)
    }
    return max
}