package leetcode

import java.util.*


/**
 * Author 昭和男神
 * Date 2020 03 08
 * keys 使用最少硬币
 * tips
 * */
class Solution322 {
    var ans = Int.MAX_VALUE

    fun coinChange(coins: IntArray, amount: Int): Int {
        Arrays.sort(coins)
        coinChange(coins.size - 1, coins, 0, amount)
        return if (ans == Int.MAX_VALUE) -1 else ans
    }

    private fun coinChange(index: Int, coins: IntArray, count: Int, needAmount: Int) {
        if (needAmount == 0) {
            ans = Math.min(count, ans)
            return
        }
        if (index < 0) {
            return
        }
        val i = needAmount / coins[index]
        var k = i
        while (k >= 0 && count + k < ans) {
            coinChange(index - 1, coins, count + k, needAmount - k * coins[index])
            k--
        }
    }

}

