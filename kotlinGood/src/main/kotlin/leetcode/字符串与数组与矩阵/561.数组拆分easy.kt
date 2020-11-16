package leetcode.字符串与数组与矩阵
/**
 * 分成两个一组的n/2组, 取每个组中最小的, 使它们相加变得最大
 * 首先, 如果使相加结果变得最小, 那么应该使一个大的数字和一个小的数字配对,使得大的数字不会被相加
 * 这样每组被相加的都是小的那个数字. 所以先排序, 然后一分为二, 两组从左至右依次组合
 * 而如果是求每组最小的加和成最大的值, 就应该使得每组的两者大小差不多, 这样"不浪费"*/
fun arrayPairSum(nums: IntArray): Int {
    nums.sort()
    var sum = 0
    var i = 0
    while (i < nums.size) {
        sum += nums[i]
        i += 2
    }
    return sum
}