package leetcode.深搜广搜

/**方法一:染色问题 Flood fill
 * 使用DFS染色
 * 将遍历到的连在一起的岛屿"填色" 然后回来继续遍历
 * 陆地: 1 海洋: 0
 * */
fun numIslands(grid: Array<CharArray>): Int {
    var res = 0
    for (r in grid.indices) {
        for (c in grid[0].indices) {
            if (grid[r][c] == '1') {
                //新的岛屿
                res += 1
                //递归 去把属于这个岛屿的陆地都染色
                //染完色后会回来 然后继续遍历下一个区域
                areaDFS(grid, r, c)
            }
        }
    }// O(n*m)级别的时间复杂度 每块区域都需要遍历到
    return res
}
fun areaDFS(grid: Array<CharArray>, r: Int, c: Int) {
    if (r < 0 || r >= grid.size || c < 0 || c >= grid[0].size || grid[r][c] != '1') {
        return // 寻找这片海洋内的新的岛屿
    }
    //leetcode.字节跳动题库.dfs
    // 这个阶段结束后 所有能到的区域全部会染色
    // 这样下一次就不会将这些陆地当作新的岛屿
    grid[r][c] = '2' //给遍历过的陆地染色 标记已经添加
    areaDFS(grid, r - 1, c)
    areaDFS(grid, r + 1, c)
    areaDFS(grid, r, c - 1)
    areaDFS(grid, r, c + 1)
}

//*****************************************************并查集****************************************************************
fun numIslands2(grid: Array<CharArray>?): Int {
    if (grid == null || grid.isEmpty()) {
        return 0
    }
    val row = grid.size
    val col: Int = grid[0].size

    //初始化并查集
    val parent = IntArray(row * col)
    for (i in grid.indices) {
        for (j in grid[0].indices) {
            parent[i * col + j] = i * col + j
        }
    }

    //并
    for (i in 0 until row) {
        for (j in 0 until col) {
            if (grid[i][j] == '1') {
                if (i + 1 < row && grid[i + 1][j] == '1') {
                    union(parent, i * col + j, (i + 1) * col + j)
                }
                if (j + 1 < col && grid[i][j + 1] == '1') {
                    union(parent, i * col + j, i * col + j + 1)
                }
            }
        }
    }
    //统计并查集最顶层的节点有几个 就是有几个岛
    var count = 0
    for (i in 0 until row) {
        for (j in 0 until col) {
            if (grid[i][j] == '1' && parent[i * col + j] == i * col + j) {
                count++
            }
        }
    }
    return count
}

fun union(parent: IntArray, index1: Int, index2: Int) {
    parent[find(parent, index1)] = find(parent, index2)
}

fun find(parent: IntArray, index: Int): Int {
    var index = index
    while (parent[index] != index) {
        index = parent[index]
    }
    return index
}

//fun leetcode.微软题库.leetcode.字节跳动题库.main() {
//    val big = Array(4) { CharArray(4) }
//    big[0] = charArrayOf('1', '1', '1', '1', '0')
//    big[1] = charArrayOf('1', '1', '0', '1', '0')
//    big[2] = charArrayOf('1', '1', '0', '0', '0')
//    big[3] = charArrayOf('0', '0', '0', '0', '0')
//    for (i in big.indices) {
//        println(big[i].toList())
//    }
//    println(numIslands(big))
//}
