package leetcode
/**
 * 注意两点
 * 1. "保证先后顺序" 所以不能从两端开始
 * 2. 本着只要不是零默认交换, 因为指向同一下标交换后结果不变, 直到前驱遇见零把两指针分开
 * */
fun moveZeroes(nums: IntArray): Unit {
    var back = 0
    for (front in nums.indices) {
        if (nums[front] != 0) {
            var temp = nums[back]
            nums[back++] = nums[front]
            nums[front] = temp
        }
    }
}
fun main() {
    var ints = intArrayOf(0,1,0,3,12)
    moveZeroes(ints)
    println(ints.contentToString())
}