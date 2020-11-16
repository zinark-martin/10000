package leetcode.字符串与数组与矩阵

/* 矩阵是m*n */
/**
 * 边界擦除法
 * 在死循环中,每次遍历一行或列就擦除这一行或列,直到上下或左右边界碰撞*/
fun spiralOrder(matrix: Array<IntArray>): List<Int> {
    var res = mutableListOf<Int>()
    if (matrix.isEmpty()) return res
    var shallow = 0
    var deep = matrix.size - 1
    var left = 0
    var right = matrix[0].size - 1
    while (true) {
        for (i in left .. right) res.add(matrix[shallow][i])
        shallow++
        if (shallow > deep) break
        for (i in shallow .. deep) res.add(matrix[i][right])
        right--
        if (left > right) break
        for (i in right downTo left) res.add(matrix[deep][i])
        deep--
        if (deep < shallow) break
        for (i in deep downTo shallow) res.add(matrix[i][left])
        left++
        if (left > right) break
    }
    return res
}
fun main(args: Array<String>) {
    println(spiralOrder(arrayOf(
            intArrayOf(1, 4, 7, 11, 15),
            intArrayOf(2, 5, 8, 12, 19),
            intArrayOf(3, 6, 9, 16, 22),
            intArrayOf(10, 13, 14, 17, 24),
            intArrayOf(18, 21, 23, 26, 30)
    )))
}