package leetcode.深搜广搜
import java.util.*
//https://leetcode-cn.com/problems/rotting-oranges/
/**
 * BFS 因为求的是时间 也就是多少轮 也就是广度上有多少层
 * 重点: 因为感染一次是需要固定时间的 所以每一次感染就是每个腐烂的橘子去
 * 感染它相邻相邻相邻的健康橘子 这算在同一次时间中也叫一轮
 * 使用队列实现广度优先 队存入的是腐烂橘子的坐标
 * 分两个阶段:
 * 1.是O(n*m)的双层遍历来记录新鲜橘子的个数 -> count++
 *  并把腐烂橘子坐标放入队列(初始层)
 * 2.阶段是进行一层一层(BFS)地感染
 *  每轮需要一分钟 最后如果还有剩余的新鲜橘子就返回-1
 * */
fun orangesRotting(grid: Array<IntArray>): Int {
    val queue: Queue<IntArray> = LinkedList()//每一只腐烂橘子都是以其坐标形式存在
    var count = 0 // 新鲜橘子的数量
    for (r in grid.indices)
        for (c in grid[0].indices) {
            if (grid[r][c] == 1) {
                count++ // 新鲜橘子+1
            } else if (grid[r][c] == 2) {
                queue.add(intArrayOf(r, c))
                // 存入腐烂橘子的坐标
            }
        } // 此时找出了初始状态中 腐烂的橘子的坐标 和新鲜橘子的数量

    var round = 0
    // round 表示腐烂的轮数，即分钟数
    while (count > 0 && !queue.isEmpty()) {
        // 有未腐烂的橘子并且队列不空(就是存在腐烂橘子的坐标)
        round++
        // 先表示还需要一轮时间 即BFS层数+1
        for (i in queue.indices) {
            //queue的大小表示当前这一轮中 有多少腐烂的橘子
            //我们依次去判断这些腐烂的橘子是否能感染它周围的新鲜橘子
            //然后将感染的新鲜橘子入队列 并将新鲜数量--
            //for循环结束时 上一层(轮)腐烂橘子已经被剔除出队列 因为它们与下一层的感染无关
            //这时队列中的都是在这一轮中新被感染的橘子 它们将在下一轮感染别的橘子
            val orange = queue.poll()
            val r = orange[0]// 层
            val c = orange[1]// 列
            //上👆
            if (r - 1 >= 0 && grid[r - 1][c] == 1) {
                // 上面还有层 并且上面是一只新鲜橘子
                grid[r - 1][c] = 2 // 感染它
                count-- // 新鲜橘子少一个
                queue.add(intArrayOf(r - 1, c)) // 将感染的橘子坐标入队列(体现BFS)
            }
            //下👇
            if (r + 1 < grid.size && grid[r + 1][c] == 1) {
                grid[r + 1][c] = 2
                count--
                queue.add(intArrayOf(r + 1, c))
            }
            //👈左
            if (c - 1 >= 0 && grid[r][c - 1] == 1) {
                grid[r][c - 1] = 2
                count--
                queue.add(intArrayOf(r, c - 1))
            }
            //右👉
            if (c + 1 < grid[0].size && grid[r][c + 1] == 1) {
                grid[r][c + 1] = 2
                count--
                queue.add(intArrayOf(r, c + 1))
            }
        }
    }
    return if (count > 0) -1 else round
}
