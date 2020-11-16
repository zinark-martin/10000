package leetcode.字节跳动题库

import leetcode.TreeNode

/*普通二叉树
* 使用递归,因为要找左右子叶,所以采用后序遍历*/
fun lowestCommonAncestor二叉树(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    if (root == null || root == p || root == q) return root
    /** ps: 如果在两个节点在一条支路重合,那么找到的这一个就是最近组先(其它支路都是null)*/
    val left = lowestCommonAncestor二叉树(root.left, p, q)
    val right = lowestCommonAncestor二叉树(root.right, p, q)
    // 3 种情况
    if (left == null && right == null) return null
    // 1 两边null 没找到
    if (left == null) return right
    if (right == null) return left
    // 2 只有一边为null 返回找到的那一边
    return root
    // 3 两边都找到了 说明这个就是目标节点
}
