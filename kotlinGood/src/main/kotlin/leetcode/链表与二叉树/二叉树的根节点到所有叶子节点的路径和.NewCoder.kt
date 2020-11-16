package leetcode.链表与二叉树

import leetcode.TreeNode
import leetcode.深搜广搜.dfs

/*注意 每一层进一个位数*/
class SumNumbers {
    /** 方法一相当于先序遍历(递归结束前需要回溯)
     * 每查找处理完一个叶子节点后curr回溯一步 返回sum给上一层 */
    var curr = 0
    var sum = 0
    fun SumNumbers(root: TreeNode?): Int {
        if (root == null) return 0
        curr = curr * 10 + root.`val`
        if (root.left == null && root.right == null) {
            sum += curr
        } // 确认这个是叶子节点 直接加上
        else {
            // 递归查找
            SumNumbers(root.left)
            SumNumbers(root.right)
        }
        // 回溯到上一层
        curr /= 10
        return sum
    }
    /** 方法二dfs  也是先序遍历(递归)
     * 每一节点向下时直接把自己的val传给下一层,遇到叶子就返回上一层*/
    fun sunNumbers(root: TreeNode?): Int {
        if (root == null) return 0
        dfsSumNumbers(root, 0)
        return sum
    }
    private fun dfsSumNumbers(root: TreeNode?, depth: Int) {
        if (root == null) return
        if (root.left == null && root.right == null)
            sum += depth * 10 + root.`val`
        else {
            dfsSumNumbers(root.left, depth * 10 + root.`val`)
            dfsSumNumbers(root.right, depth * 10 + root.`val`)
        }
    }
}



