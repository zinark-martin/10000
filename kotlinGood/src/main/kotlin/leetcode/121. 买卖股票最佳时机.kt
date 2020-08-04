package leetcode
/**
 * 因为收益只能是后面的值减去前面的值
 * 思路:
 * 边找最大值, 边找最大差值
 * 如果值掉到最小以下就换最小值
 * */
fun maxProfit(prices: IntArray): Int {
    var minValue = Int.MAX_VALUE
    var moneyMax = 0
    for (i in prices) {
        if (i < minValue) {
            minValue = i
        } else if (i - minValue > moneyMax) {
            moneyMax = i - minValue
        }
    }
    return moneyMax
}