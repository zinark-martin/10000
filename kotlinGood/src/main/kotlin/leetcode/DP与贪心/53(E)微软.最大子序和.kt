package leetcode.DP与贪心
//https://leetcode-cn.com/problems/maximum-subarray/
/**
 * 使用动态规划
 * 思想: 首先"叠加",我们把最目标段的数组想象成每一个元素都叠加到最后一个元素上面
 * 这时叠加状态是最大的,也就是和最大,那么叠加的过程是从第二个元素开始,如果它前面的
 * 元素为正,就叠加到当前元素上,以此类推,每次叠加后记录此时的叠加值
 * 如果前一个元素不是正数就不叠加,舍弃这个"叠加数"即前面一段数组
 * 证明:因为每一个叠加数都体现了前面一段长度的和,如果这个数字为负数
 * 就表示前面一段数字总和是负,应该舍弃,遍历下一位
 * 注意: 因为元素可以为负,所以max的初始值不能随便设0
 * */

fun maxSubArray(nums: IntArray): Int {
    var max = nums[0]
    for(i in 1 until nums.size) {
        if(nums[i-1] > 0) {
            nums[i] += nums[i-1]
        }
        max = max.coerceAtLeast(nums[i])
        //如果叠加则更新和值
        //如果舍弃则更新默认最大值
    }
    return max
}
//非动态规划, 思路和上述很相似, 只是没有"叠加"思想
fun maxSubArray1(nums: IntArray): Int {
    var max = Int.MIN_VALUE
    var curr = 0
    for (i in nums.indices) {
        if (curr > 0) {
            curr += nums[i]
        } else {
            curr = nums[i]
        }
        max = max.coerceAtLeast(curr)
    }
    return max
}
