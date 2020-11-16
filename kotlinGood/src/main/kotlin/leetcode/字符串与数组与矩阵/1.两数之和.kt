package leetcode.字符串与数组与矩阵

fun twoSum1(nums: IntArray, target: Int): IntArray? {
    if (nums.isEmpty()) return null
    val map = HashMap<Int, Int>()
    //使用哈希表检查有无插值存在,为了使这一操作的时间复杂度为o(1)
    //我们将数字作为key,将数字的下标作为value,先根据下标找key在将其结果放入数组
    for (i in nums.indices) {
        val index = map[target - nums[i]]
        if (index != null) return intArrayOf(index, i)
        map[nums[i]] = i//先判断后添加,否则会把当期结点重复添加
    }
    return null
}
fun main() {
    println(twoSum1(intArrayOf(3,2,4),6)?.toList())
}