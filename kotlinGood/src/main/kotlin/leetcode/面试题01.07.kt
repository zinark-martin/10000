package leetcode

fun rotate5(matrix: Array<IntArray>): Unit {
    val n = matrix.size - 1
    //首先只写等号只表示引用对象
    //copyof后才是一次只展开一层
    val matrix2  = matrix.copyOf().map { it.copyOf() }
    for (i in matrix.indices) {
        for (j in matrix.indices) {
            matrix[i][j] = matrix2[n - j][i]
        }
    }
}
private fun rotate(matrix: Array<IntArray>) {
    val tmp = 0
    val len = matrix.size
    val help = Array(len) { IntArray(len) }
    for (i in matrix.indices) {
        for (j in matrix.indices) {
            help[i][j] = matrix[len-1-j][i]
            println("${help[i][j]} help!")
        }
        println(help.contentDeepToString())
    }
    for (i in matrix.indices) {
        for (j in matrix.indices) {
            matrix[i][j] = help[i][j]
        }
    }
}
