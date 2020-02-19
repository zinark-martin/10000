package leetcode
/**
 * 和上一题相似, xy从遇到目标数字后分开
 * y负责前驱依次把不等于目标的数字赋值给x之前的数组
 * x将收集的数列的长度返回
* */
fun removeElement(nums: IntArray, target: Int): Int {
    if (nums.isEmpty()) return 0
    var x = 0
    for (y in nums.indices) {
        if (nums[y] != target) {
            nums[x] = nums[y]
            x++
        }
    }
    return x
}