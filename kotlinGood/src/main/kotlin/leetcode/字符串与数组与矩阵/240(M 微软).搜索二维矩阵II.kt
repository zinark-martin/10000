package leetcode.字符串与数组与矩阵
//解法一:暴力破解 双重for循环一个一个遍历,O(nm)
//解法二:二分搜索
//解法三:类排序二叉树,对于每个数来说,左下一定小于它,右下一定大于它,这样一大一小,就能确定每次查找的方向是固定的
/**
 * 利用条件:每行每列元素都是用小到大排列的
 * 其实就是一颗二叉查找树,即一边比当前数字更大,一边更小,以此题干能看出来,从左下角开始是这样的结构
 * 即左下角是二叉查找树的根节点,所以从左下角开始,每次找更小的就向上,找更大的就向右
 * */
//TODO(使用二分做一次 有人面试被要求过用二分查找)
fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    if (matrix.isEmpty()) return false
    var c = 0
    var r = matrix.size - 1
    // row 和 column
    while (r >= 0 && c < matrix[0].size) {
        when {
            (matrix[r][c] > target) -> r--
            // 因为上列更小,所以找更小的数,行向上
            (matrix[r][c] < target) -> c++
            // 因为右边更大,所以找更大的数,列向右
            else -> return true
            // 找到了
        }
    }
    return false
}
fun main() {
    val testData = arrayOf(
            intArrayOf(1, 4, 7, 11, 15),
            intArrayOf(2, 5, 8, 12, 19),
            intArrayOf(3, 6, 9, 16, 22),
            intArrayOf(10, 13, 14, 17, 24),
            intArrayOf(18, 21, 23, 26, 30)
    )
    println(searchMatrix(testData,99))
}