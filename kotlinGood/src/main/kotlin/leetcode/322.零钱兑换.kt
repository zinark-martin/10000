package leetcode

import kotlin.math.min

/**
 * Author 昭和男神
 * Date 2020 03 08
 * keys 使用最少硬币
 * method 剪枝递归
 * 从贪心算法出发, 每一层递归都换下一位最大面额币并把剩余的钱当作新的amount
 * 防止贪心不是最优解需要有回退的余地, 每次递归前记录使用了几次最大币, 然后利用循环一个大币一个大币地加
 * 本轮递归地次数就是本轮使用大币的数量, 递归出口就是amount为零时
 * 因为有可能出现循环的递归里不只有一条支线结果可行, 所以我们在每一支递归结束时选择最小的币使用次数
 *
 * kotlin写的会超时, Java不会, 大概得用动态规划从后往前推了, 这样的递归每一步都会又尝试好几步,
 * 尽管已经做了剪枝操作还是会超时
 * */
class Solution322 {
    var ans = Int.MAX_VALUE

    fun coinChange(coins: IntArray, amount: Int): Int {
        coins.sort()
        coinChange(coins.size - 1, coins, 0, amount)
        return if (ans == Int.MAX_VALUE) -1 else ans
        //只有至少一次"剩余金额"为零才会改变ans

    }

    private fun coinChange(index: Int, coins: IntArray, count: Int, LeftAmount: Int) {
        if (count >= ans) {
            return
        }
        if (LeftAmount == 0 ) {
            ans = count.coerceAtMost(ans)
            //全局变量ans记录每个可行支线最小的次数
            return
            //exit the recursive when amount == 0
        }
        if (index < 0) {
            return
            //币用完了也返回
        }
        val i = LeftAmount / coins[index]
       // allow back 'k' times steps
        for (k in i downTo 0) {
            if (count + k < ans) {
                coinChange(index - 1, coins, count + k, LeftAmount - k * coins[index])
            }
        }
    }
}

fun main(args: Array<String>) {
    var coins: IntArray = intArrayOf(1,2,5)
    println(Solution322().coinChange(coins,11))
}
