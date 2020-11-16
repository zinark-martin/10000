package leetcode.字节跳动题库
import java.util.*
//https://leetcode-cn.com/problems/friend-circles/
/*
* 朋友圈
* 一共M.size个人
* 和岛屿系列逻辑不同, 这里判断朋友圈的逻辑不是某一块是否联通
* 而是更具每个数字对应的横纵坐标,如果这个数字是1,那么
* 横纵坐标分别代表的人也就是横行,是"联通"的
* 求这些横行能联通为几个整体,即几个朋友圈
* 注意:
*  1.给定数组是N*N正方形, 并且M[i][j] 一定等于 M[j][i]
*    因为 M[i][j] == 1 时表示第i和j位是py,所以M一定是对称矩阵
*  2.这个矩阵的每一行都包含了第这一行对应的这个人与其他人是否是朋友的全部信息
*    如第2个人和其他人:[2,0]=1 [2,1]=0 [2,2]=1 [2,3]=1
* */
/*****************************DFS******************************/
/*查一个人,从这个人开始一直找有联系的朋友圈,只要新的人没有查过就一直找*/
val visited = mutableListOf<Int>()
fun findCircleNum(M: Array<IntArray>): Int {
    //如果一个人被查过了,ta不可能还再属于新这个人的朋友圈, 因为联通的py深搜中会全部查完
    var res = 0
    for (i in M.indices)
    //分别深搜N个人的朋友圈
        if (!visited.contains(i)) {
            //发现一个"新人",搜索完ta所有的朋友 朋友圈+1
            dfs(M, i)
            res++
        }
    return res
}
fun dfs(M: Array<IntArray>, i: Int) {
    for (j in M[0].indices) {
        //以i这个人出发,查每个"新人"j
        //即在i基准行遍历查找每个列元素j
        if (i == j) continue
        //自己和自己不用查了
        if (M[i][j] == 1 && !visited.contains(j)) {
            //这个"新人"是朋友,并且没有被收录其他pyq
            visited.add(j)
            dfs(M, j)
            //一条路走到黑: 以这个"新人"为出发点 去ta的行找ta的朋友
            //即查ta这一行的其他人
        }
    }
}
//时间复杂度: O(n^2),整个矩阵都要被遍历
//空间复杂度: visited的大小
/*****************************BFS*********************************/
/*bfs的逻辑: 查一个人新人,朋友圈加1,将ta牵连的其他新人都*/

fun findCircleNum2(M: Array<IntArray>): Int {
    //TODO(感觉有点重复??所需时间比DFS多一倍)
    val visited = mutableListOf<Int>()
    var res = 0
    val queue = LinkedList<Int>()
    for (i in M.indices)
        if (!visited.contains(i)) {
            res++
            //新人代表新的朋友圈开始
            queue.add(i)
            while (!queue.isEmpty()) {
                //以这个人开始广搜与ta有联系的人
                val curr = queue.poll()
                visited.add(curr)
                //取人,先标记为遍历过, 再看ta(这一行)的朋友有谁
                for (j in M.indices)
                    if (M[curr][j] == 1 && !visited.contains(j))
                        queue.add(j) //把新发现的ta的朋友添加到队列
            }
        }
    return res
}
//时间复杂度: O(n^2) 空间复杂度: visited 和 queue 的大小

/****************************并查集********************************/
fun main() {
    val test = arrayOf(
            intArrayOf(1, 0, 0, 1),
            intArrayOf(0, 1, 1, 0),
            intArrayOf(0, 1, 1, 1),
            intArrayOf(1, 0, 1, 1)
    )
    println(findCircleNum2(test))
}



































































