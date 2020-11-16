package leetcode.字节跳动题库

///*
//* 使用DFS, 一次性搜索完每个岛屿
//* 每次调用DFS递归函数就意味着一个岛屿的搜索 所以每次更新一下面积大小
//* 和岛屿数量一个套路
//* */
//var area = 0 //记录探索每一个岛屿时的大小 循环末尾清0
//fun maxAreaOfIsland(grid: Array<IntArray>): Int {
//    var ans = 0
//    for (r in grid.indices) {
//        for (c in grid[0].indices) {
//            if (grid[r][c] == 1) {
//                dfs(grid, r, c)
//                ans = ans.coerceAtLeast(area)
//                area = 0 // 下一个岛屿探索前清0
//            }
//        }
//    }
//    return ans
//}
//fun dfs(grid: Array<IntArray>, r: Int, c: Int) {
//    if (r >= grid.size || r < 0 || c >= grid[0].size || c < 0 || grid[r][c] != 1)
//        return
//    area++
//    grid[r][c] = 2
//    dfs(grid, r + 1, c)
//    dfs(grid, r - 1, c)
//    dfs(grid, r, c + 1)
//    dfs(grid, r, c - 1)
//}