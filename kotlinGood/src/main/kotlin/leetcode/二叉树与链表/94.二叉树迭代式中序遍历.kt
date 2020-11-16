package leetcode.二叉树与链表

import leetcode.TreeNode
import java.util.*
//https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
/**
 * 一直添加左子数/结点到头,遇到空时
 * 先取父节点并添加其值,再前驱到父节点的右子树
 * 这就是中序的体现
 * */

fun inorderTraversal(root: TreeNode?): List<Int> {
    val res = mutableListOf<Int>()
    val stack = Stack<TreeNode>()
    var curr = root
    while (root != null || !stack.isEmpty()) {
        curr = if (curr == null) {
            val element = stack.pop()
            res.add(element.`val`)
            element.right
        } else {
            stack.add(curr)
            curr.left
        }
    }
    return res
}