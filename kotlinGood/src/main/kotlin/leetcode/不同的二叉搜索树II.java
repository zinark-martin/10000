import java.util.LinkedList;
import java.util.List;
/**
 * title:给定整数n, 完成建立所有从1到n的每个数字作为节点构成的二叉搜索树
 * keys:我们从序列 1 ..n 中取出数字 i，作为当前树的树根。
 * 于是，剩余 i - 1 个元素可用于左子树，n - i 个元素用于右子树。
 * 重复此过程, 最后将左右子树连接在根上
 **/
class TreeNode {
    TreeNode left;
    TreeNode right;
    int i;
    public TreeNode(int x) {
        i = x;
    }
}
class Solution {
    public LinkedList<TreeNode> getTree(int start, int end) {
        LinkedList<TreeNode> ans = new LinkedList<TreeNode>();
        //两出口, 一个是左边为null, 一个是当前节点没有左右子节点
        if (start > end) {
            ans.add(null);
            return ans;
        }
        if (start == end) {
            //子树只有一个数字的时候,直接把它作为一个节点添加, 这样会节约1ms
            //否则会继续递归走以上面那个为递归出口相当于添加了两个null的左右子树
            TreeNode single = new TreeNode(start);
            ans.add(single);
            return ans;
        }

        for (int i = start; i <= end; i++) {
            //以当前选取的节点i为根, 递归左右节点
            LinkedList<TreeNode> left_trees = getTree(start, i - 1);
            LinkedList<TreeNode> right_trees = getTree(i + 1, end);
            //每一根节点左右递归完了后就建树
            //每一趟都有i-1-1个子趟
            for (TreeNode l : left_trees) {
                for (TreeNode r : right_trees) {
                    TreeNode currentTree = new TreeNode(i);
                    currentTree.left = l;
                    currentTree.right = r;
                    ans.add(currentTree);
                }
            }
        }
        return ans;
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return getTree(1, n);
    }
}


