package leetcode.字符串与数组与矩阵

fun removeElement(nums: IntArray, `val`: Int): Int {
    var i = 0
    for (j in nums.indices) {
        if (nums[j] != `val`) {
            nums[i] = nums[j]
            i++
        }
    }
    return i
}
/**
 * 同向双指针会出现最后一个是Val侧无法有机会处理的情况
 * 采用前后双向指针就可以避免这个问题*/
fun removeElement双指针(nums: IntArray, `val`: Int): Int {
    var i = 0
    var n = nums.size
    while (i < n) {
        if (nums[i] == `val`) {
            nums[i] = nums[n - 1]
            n--
        } else {
            i++
        }
    }
    return n
}
fun main() {
    println(removeElement双指针(intArrayOf(1,222,3,222,4,222,222,5), 222))
}