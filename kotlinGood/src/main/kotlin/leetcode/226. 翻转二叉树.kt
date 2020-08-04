package leetcode

fun invertTree(root: TreeNode?): TreeNode? {
    if (root == null) return null
    //注意递归格式 把子节点作为参数传进去而不是拿子节点
    val right = invertTree(root.right)
    val left = invertTree(root.left)
    //先用递归拿到左右子, 再分别把根的左右子指向前两者
    root.left = right
    root.right = left
    return root
}
