package leetcode
/**如果不相等, x进一位指向和y同一个元素, 下一次循环y再接着往前走
 *如果相等即出现重复的, x不动, y接着循环
 * 直到遇到和x针对元素不相等的元素时, x加一位并把这个位置的换成y指的新元素
 * 所以保证y前驱而x所在之前的数组都是积累的无重复元素
 * */
fun removeDuplicates(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    //双指针, 一前一后
    var x = 0
    for (y in 1 until nums.size) {
        if (nums[x] != nums[y]) {
            x++
            nums[x] = nums[y]
        }
    }
    return x + 1
}