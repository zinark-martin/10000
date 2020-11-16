package leetcode.字节跳动题库
//https://leetcode-cn.com/problems/maximal-square/solution/zui-da-zheng-fang-xing-by-leetcode-solution/
/**
 * 动态规划 时间复杂度O(mn):需要遍历整个矩阵中的元素 空间复杂度O(mn):因为创建了一个和原始矩阵相同的矩阵
 * 由于状态转移方程中的 dp(i, j)dp(i,j) 由其上方、左方和左上方的三个相邻位置的 dp 值决定,因此可以使用两个一维数组进行状态转移
 * 空间复杂度优化至 O(n)O(n)
 * 思路: 从左上向右下找,除了第一行以及第一列最大是一以外,其它的点都可以"累积"正方形
 * 即每个点的正方形大小由其左上方,左方,上方这三个点(的最大正方形大小)决定,我们取四者最小值,
 * 因为要保证这个正方形能"囊括"前面三者的正方形,这就实现了向右下"累积"在正方形
 * 再一个值更替记录最大值就行了
 * */
fun maximalSquare(matrix: Array<CharArray>?): Int {
    var maxSide = 0
    if (matrix == null || matrix.isEmpty() || matrix[0].isEmpty())
        return maxSide
    val dp = Array(matrix.size) {
        IntArray(matrix[0].size)
        // 长度: m 初始化为长度是n的数组 -> 即初始化一个m*n的二维数组的逻辑
    }
    for (i in matrix.indices) {
        for (j in matrix[0].indices) {
            if (matrix[i][j] == '1') {
                if (i == 0 || j == 0) {
                    // 对于第一行及第一列的数字,左上无法形成更大的正方形
                    dp[i][j] = 1 // 所以设置为1
                } else {
                    dp[i][j] = dp[i - 1][j].coerceAtMost(dp[i][j - 1]).coerceAtMost(dp[i - 1][j - 1]) + 1
                    // 左,左上,上,取三者最小值 + 1
                }
                maxSide = maxSide.coerceAtLeast(dp[i][j])
                // 更新最大正方形
            }
        }
    }
    return maxSide * maxSide
    // 返回面积
}