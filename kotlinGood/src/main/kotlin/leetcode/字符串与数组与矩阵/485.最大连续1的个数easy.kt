package leetcode.字符串与数组与矩阵

/**
 * 数组只有1和0两种元素
 * 求连续的1最多有几个
 * 思路, 开关模式, 若遇见0将开关关掉, 记录开关开的次数
 * 最后返回最长的一次
 * */
/**
 * 刚开始用数组记录每组的值然后返回最大的
 * 最后同209题,发现直接给ans赋初始值最小然后每次更新为更大的值就可以啦
 * 循环结束后再一次更新,不要漏了最后一组"1"
 * */
fun findMaxConsecutiveOnes(nums: IntArray) : Int? {
    var isOne = false
    var count = 0
    var ans = Int.MIN_VALUE
    for (i in nums.indices) {
        if (nums[i] == 1) {
            isOne = true
            count++
        } else if (isOne){
            isOne = false
            ans = ans.coerceAtLeast(count)
            count = 0
        }//如果是0且上一个也是0,忽略掉
    }
    ans = ans.coerceAtLeast(count)//别忘了把最后一组也处理了!
    return if (ans == Int.MIN_VALUE) 0 else ans
}
fun main() {
    println(findMaxConsecutiveOnes(intArrayOf(1,1,0,1,1,1,1)))
}