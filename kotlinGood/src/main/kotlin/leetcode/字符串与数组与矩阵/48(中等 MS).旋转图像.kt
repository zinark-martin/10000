//https://leetcode-cn.com/problems/rotate-image/
//同 面试题 01.07. 旋转矩阵
//https://leetcode-cn.com/problems/rotate-matrix-lcci/submissions/
/**
 * 将一个正方形矩阵旋转顺时针九十度
 * 逻辑:每一层旋转时都符合一样的逻辑,先处理四个角,再把四个位置都顺时针偏移一个旋转量(每次操作后自增一)
 * 当旋转量达到边界时结束这一层,收紧两个位置进入下一层
 * */
/*注意边界条件:层数和行数不需要利用n进行计算然后设置在for循环中,使用如下的while循环就可以
* 层数边界:每层操作一次收紧两个位置,当两者碰撞时说明层数用尽
* 每层边界:每次旋转一次都增加偏移量,当偏移量不再小于两位置差值时,说明这一圈已经操作完毕*/
fun rotate(matrix: Array<IntArray>) {
    var 旋转量: Int
    var tmp: Int
    // 初始第一层: 即第一行和最后一行,第一列和最后一列
    var pos1 = 0
    var pos2 = matrix[0].size - 1
    while (pos1 < pos2) {
        // 上下层/左右列 碰撞的时候就是所有层都处理完毕了
        旋转量 = 0
        while (旋转量 < pos2 - pos1) {
            // 例如这一层的n为3,那么差值 = 2 - 0 = 2,但是0 + 2已经到了被操作过的位置,所以偏转量须小于差值
            tmp = matrix[pos1][pos1 + 旋转量]                          // 缓存左上
            matrix[pos1][pos1 + 旋转量] = matrix[pos2 - 旋转量][pos1]// 左下至左上
            matrix[pos2 - 旋转量][pos1] = matrix[pos2][pos2 - 旋转量]// 右下至左下
            matrix[pos2][pos2 - 旋转量] = matrix[pos1 + 旋转量][pos2]// 右上至右下
            matrix[pos1 + 旋转量][pos2] = tmp                          // 左上到右上
            旋转量++                                                   // 偏转量+1
        }
        // 每一层操作完毕后 处理下一层
        pos1++
        pos2--
    }
    /*如果想返回矩阵:
    return mutableListOf<List<Int>>().apply {
        matrix.forEach {
            add(it.toList())
        }
        // 即使apply包着forEach,其调用规则依然不变,可以不用加this
    }*/
}
fun main() {
    println(rotate(arrayOf(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(5, 6, 7, 8),
            intArrayOf(9, 10, 11, 12),
            intArrayOf(13, 14, 15, 16)
    )))
}