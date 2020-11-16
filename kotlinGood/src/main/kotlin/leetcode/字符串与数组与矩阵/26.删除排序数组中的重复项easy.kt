package leetcode.字符串与数组与矩阵
/**
 * 注意一个问题, 为什么返回值是Int, 但输出答案是数组
 * 以为这里采用值引用,即只改变对象引用的值而不改变对象本身引用哪里,所以这里做的修改对于调用方可见
 * */
fun removeDuplicates(nums: IntArray): Int {
    var back = 0
    for(front in nums.indices) {
        if(nums[front] != nums[back]) {
            back++
            nums[back] = nums[front]
        }
        //前指针保持前驱,直到遇见不一样的,这时后指针的下一位一定是重复的数字
        // (或者不是重复数字,但这时两指针指向同一个位置)
        //将其修改为前驱到的非重复数字
    }
    return back + 1
}