package leetcode

import java.util.*

fun setZeroes(matrix: Array<IntArray>): Unit {
    val row = HashSet<Int>()
    val column = mutableListOf<Int>()
    //记录有零的列, 因为使用的是hashset所以对于任意列只要出现一次零就会被记录
    for (i in matrix.indices) for (j in matrix[0].indices) if (matrix[i][j] == 0) {
        row.add(i)
        column.add(j)
    }
    //一整行替换和每行涉及的零列替换
    for (row_idx in row) matrix[row_idx].fill(0)
    for (col_idx in column) {
        for (i in matrix.indices) matrix[i][col_idx] = 0
    }
}