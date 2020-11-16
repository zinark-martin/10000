package leetcode.字节跳动题库

import leetcode.TreeNode

/*利用二叉搜索树的特点: 比节点小的在左边,大的在右边
* 那么从根节点开始,若两个目标数字同大或同小于当前节点,说明是它两在同一侧,这个节点是离得很远的组先
* 向小或大的一侧前驱,直到乘积为负数或者零,说明分别在两边或者找到了其中一个节点,那么当前根节点就是最近组先*/

fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    var root: TreeNode? = root ?: return null
    // 因为不能一次性判断两个独立条件,这里使用差的乘积正负表示两个节点是否在同一侧
    // 零表示这个节点就是两者之一 那肯定就也是最近组先
    while ((root!!.`val` - p!!.`val`) * (root.`val` - q!!.`val`) > 0) {
        root = if (p.`val` < root.`val`) root.left else root.right // "前驱"
    }
    return root // 否则说明找到了最近两个分叉的合并点,也就是最近组先
}


/*递归(没有必要递归 不是很像递归的递归)*/
fun lowestCommonAncestor2(root: TreeNode?, p: TreeNode, q: TreeNode): TreeNode? {
    return if ((root!!.`val` - p.`val`) * (root.`val` - q.`val`) <= 0) root
    // 一边一个,说明这个节点就是目标
    else lowestCommonAncestor2(if (p.`val` < root.`val`) root.left else root.right, p, q)
}
