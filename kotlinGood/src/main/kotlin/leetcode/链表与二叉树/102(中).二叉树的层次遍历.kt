package leetcode.链表与二叉树

import leetcode.TreeNode
import java.util.*
/* 由于每次处理的时候,只有每次while循环新开始是新的一层,其余都是新旧层同在队列中
* 所以加一个for循环 在每一层开始的时候先一口气出完这一层所有的节点
* 然后这一层添加的所有节点归到下一层,在下一趟for循环中再又一口气处理*/
fun levelOrder(root: TreeNode?): List<List<Int?>?>{
    val queue = LinkedList<TreeNode?>()
    val res = mutableListOf<List<Int?>>()
    if (root == null) return res
    queue.add(root)
    while (!queue.isEmpty()) {
        val level = mutableListOf<Int?>()
        repeat(queue.size) {
            val node = queue.poll()
            level.add(node?.`val`)
            if (node?.left != null) queue.add(node.left)
            if (node?.right != null) queue.add(node.right)
        }
        res.add(level)
    }
    return res
}