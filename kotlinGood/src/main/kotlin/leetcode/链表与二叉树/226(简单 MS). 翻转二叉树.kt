package leetcode.链表与二叉树
import leetcode.TreeNode
//https://leetcode-cn.com/problems/invert-binary-tree/

/*递归: 出口为null,一直递归找到左右子树最后节点,然后交换左右子树,返回父节点,每层类推*/
fun invertTree(root: TreeNode?): TreeNode? {
    if (root == null) {
        return null
    }
    val right = invertTree(root.right)
    val left = invertTree(root.left)
    root.left = right
    root.right = left
    return root
}
