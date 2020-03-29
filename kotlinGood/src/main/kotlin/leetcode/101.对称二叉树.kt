package leetcode

class TreeNode(var int: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

/**
 * title:给定一个二叉树, 检查它是否镜像对称
 * 就是对于一个根节点它的左右子树需要一样
 * */

fun isSymmetric(root: TreeNode?): Boolean {
    return isMirror(root, root)
}

fun isMirror(t1: TreeNode?, t2: TreeNode?): Boolean {
    //两参数一左一右, 每个节点开支, 可以同时比较对称的两个点
    if (t1 == null && t2 == null) return true
    return if (t1 == null || t2 == null) false
    else t1.int == t2.int //"全短路原则" 当前结点不镜面相等则后面不用看直接false
            && isMirror(t1.right, t2.left)
            && isMirror(t1.left, t2.right)
}
