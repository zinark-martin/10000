package leetcode

/**
 * title:给定一个数组, 求它的最大连续子数组的和
 * keys:每次遇到一个负数,若当前的和足够够遇到的负数消耗,就在考虑更新后加上负数,否则考虑后把当前值清零
 * notice:是"+"负数不是"-"
 * 这种算法需要单独给出全是负数的处理情况, 即直接返回最小的元素
 * 数组只有一个元素的话直接返回
 * DP:使用动态规划完成
 * keys:默认第一个为最大值开始从第二位元素遍历, 上限为size所以如果只有一个元素就不会进入循环
 * */
fun maxSubArray(nums: IntArray): Int {
    if (nums.size==1) return nums[0]//考虑只有一个元素的情况
    var sign = 0
    for (i in nums) {//考虑全是负数的情况直接返回其中最小的就行
        if (i >= 0) sign = 1
    }
    if (sign == 0) return nums.max()!!.toInt()
    var ans = Int.MIN_VALUE
    var current = 0
    for (i in nums) {
        when {
            i >= 0 -> {
                current += i
                ans = current.coerceAtLeast(ans)
            }
            current + i >= 0 -> {
                ans = current.coerceAtLeast(ans)
                current += i
            }
            else -> {
                ans = current.coerceAtLeast(ans)
                current = 0
            }
        }
    }
    return ans
}
fun maxSubArray2(nums: IntArray): Int {
    var max = nums[0]
    for (i in 1 until nums.size) {//如果size是1,即上界就是1所以不会走循环直接返回max
        if (nums[i-1]>=0) nums[i] += nums[i - 1]
        max = nums[i].coerceAtLeast(max)
        println(nums[i])
    }
    return max
}
fun main(args: Array<String>) {
    maxSubArray2(intArrayOf(-1,3))
}