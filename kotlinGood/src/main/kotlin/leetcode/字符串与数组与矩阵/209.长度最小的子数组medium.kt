package leetcode.字符串与数组与矩阵

/**
 * 双指针
 * 有一个问题,用什么标记最小值呢?
 * 一开始我是用一个list保存每一次的值然后返回最小的,如果是null说明没有一次匹配,故返回0
 * 但是一般题解使用一种更轻量的方法: 如果要找最小值就给ans初始值赋MAV_VAlUE
 * 这样每次都更新一次最小值,最后判断要是ans依旧是MAX_VALUE说明一次变化都没有,即返回0
 * */
fun minSubArrayLen(s: Int, nums: IntArray): Int? {
    if (nums.isEmpty()) return 0
    var front: Int = 0
    var back: Int = 0
    var ans = Int.MAX_VALUE
    while (front < nums.size) {
        if (isBigger(s, front, back, nums)) {
            ans = ans.coerceAtMost(front - back + 1)
            if (front - back == 0) return 1
            back++
        } else {
            front++
        }
    }
    return if (ans == Int.MAX_VALUE) 0 else ans
}
fun isBigger(s: Int, front: Int, back: Int, nums: IntArray): Boolean {
    var sum = 0
    for (i in back..front) {
        sum += nums[i]
    }
    if (sum >= s) {
        return true
    }
    return false
}
//官方题解把累加循环写在内部, 同时要对sum减去back跳过的值
fun minSubArrayLen官方(s: Int, nums: IntArray): Int {
    val n = nums.size
    if (n == 0) return 0
    var ans = Int.MAX_VALUE
    var back = 0
    var front = 0
    var sum = 0
    while (front < n) {
        sum += nums[front]
        while (sum >= s) {
            ans = ans.coerceAtMost(front - back + 1)
            sum -= nums[back]
            back++
        }
        front++
    }
    return if (ans == Int.MAX_VALUE) 0 else ans
}

fun main() {
    println(minSubArrayLen(9, intArrayOf(2,-1,33,33,0,33,9)))
}