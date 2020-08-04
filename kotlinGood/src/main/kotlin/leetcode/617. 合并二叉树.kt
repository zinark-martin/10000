package leetcode

/**
 * 返回将两个二叉树合并的数, 合并是指将两个数重叠, 每个节点相加
 * 解法: 把第二个节点的值加到第一个节点上, 递归的方式遍历
 * 递归出口: 如果某一个为null,
 * 就说明其子树为空, 所以返回另一个的子树
 *
 * */
fun mergeTrees(t1: TreeNode?, t2: TreeNode?): TreeNode? {
    if (t1 == null) return t2
    if (t2 == null) return t1
    t1.`val` += t2.`val`
    t1.right = mergeTrees(t1.right, t2.right)
    t1.left = mergeTrees(t1.left, t2.left)
    return t1
}