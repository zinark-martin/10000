package leetcode.字符串与数组与矩阵
// 遇到非零就交换, 一次遍历效率更高
// 如果一直没零的话,就不会交换,只是连个指针一起指向同一个位置并前驱,如果有一次零,
// 操作后back指针就会前驱一位指向零然后以此类推一直指向零,再往后的操作中
fun moveZeroes(nums: IntArray): IntArray {
    var back = 0
    for (front in nums.indices) {
        if (nums[front] != 0) {
            if (front == back) {
                // 没遇到过零之前跳过非零数字
                back++
                continue
            }
            val temp = nums[back]
            nums[back++] = nums[front]
            nums[front] = temp
        }
    }
    return nums
}

//先把做一次整体替换,再记录零的个数然后在末尾替换为零
//这样时间复杂度为O(2n)
fun moveZeroes2(nums: IntArray) {
    var back = 0
    var count = 0
    for (front in nums.indices) {
        if (nums[front] != 0) {
            nums[back] = nums[front]
            count++
            back++
        }
    }//第二次循环为了补零
    for (i in back until nums.size) {
        nums[i] = 0
    }
}
fun main() {
    println(moveZeroes(intArrayOf(2,3,4,5)).toList())
}
