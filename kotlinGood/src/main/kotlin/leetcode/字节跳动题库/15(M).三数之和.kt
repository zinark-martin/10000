@file:Suppress("NAME_SHADOWING")

package leetcode.字节跳动题库
//https://leetcode-cn.com/problems/3sum/
/**能否找到三个数字和等于0*/

fun threeSum(nums: IntArray): List<List<Int>> {
    val ans = arrayListOf<List<Int>>()
    if (nums.size < 3) return ans
    val nums = nums.apply {
        sort()
    } //从小到大排序

    for (i in nums.indices) {
        if (i > 0 && nums[i] == nums[i - 1]) continue// 和尚以为一样 就去重
        if (nums[i] > 0) return ans // 那后面更大 就结束返回

        var l = i + 1
        var r = nums.size - 1
        while (l < r) {
            // l r 分别是最大和最小的数字
            // l r 碰撞后这一趟循环结束
            val sum = nums[i] + nums[l] + nums[r]
            when {
                sum == 0 -> {
                    ans.add(listOf(nums[i], nums[l], nums[r]))
                    // 先让l和r分别跳过重复的数字
                    while (l < r && nums[l] == nums[l+1]) l++
                    while (l < r && nums[r] == nums[r-1]) r--
                    l++
                    r--
                }
                sum < 0 ->
                    l++ // l太小
                sum > 0 ->
                    r-- // r太大
            }
        }
    }
    return ans
}
