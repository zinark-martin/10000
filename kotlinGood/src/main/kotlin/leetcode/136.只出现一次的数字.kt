package leetcode

fun main(args: Array<String>) {
    fun singleNumber(nums: IntArray): Int {
        var res = 0
        for (number in nums) {
            res = res xor number
        }
        return res
    }
}