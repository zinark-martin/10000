package leetcode.字节跳动题库

import leetcode.TreeNode
import java.util.*
/*和上一道题一样的逻辑,只是设置一个flag,使用1/0标记奇偶行,如果是偶数行
* 就在添加revered这一层,奇数行就是直接添加. 使用xor异或对转标记*/
fun zigzagLevelOrder(root: TreeNode?): List<List<Int?>?>? {
    val queue = LinkedList<TreeNode?>()
    val res = mutableListOf<List<Int?>>()
    var flag = 1
    if (root == null) return res
    queue.add(root)
    while (!queue.isEmpty()) {
        val level = LinkedList<Int?>()
        repeat(queue.size) {
            val node = queue.poll().apply {
                level.add(this?.`val`)
                if (this?.left != null) queue.add(this.left)
                if (this?.right != null) queue.add(this.right)
            }
        }
        if (flag == 0) res.add(level.reversed())
        else res.add(level)
        flag = flag xor 1
    }
    return res
}