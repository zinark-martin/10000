package leetcode.字节跳动题库

/**
 * 在上一道题的dp思想上,将max变为一个累加对象
 * 先判断当前价格是否比最低更低
 * 如果当前价格比最小的大就利润累加,并更新当前价格为新的候选买入点(最小价格)*/
fun maxProfitII(prices: IntArray): Int {
    var max = 0
    var minPrice = prices[0]
    prices.forEach {
        minPrice = minPrice.coerceAtMost(it)
        if (it - minPrice > 0) {
            max += it - minPrice
            minPrice = it
        }
    }
    return max
}
fun main() {
    println(maxProfitII(intArrayOf(1,2,3,4,5,6)))
}