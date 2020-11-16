package leetcode.字符串与数组与矩阵

import java.util.ArrayList
/*
* DFS递归＋剪枝 (不是回溯)
* 左右括号初始的值都是n,每递归一层加一个左/右括号,左/右剩余数量减一
* 剪枝条件是右边可以括号用不够了*/

fun generateParenthesis(n: Int): ArrayList<String> {
    val res = ArrayList<String>()
    if (n == 0) {
        return res
    }
    dfs("", n, n, res)
    return res
}

/* 因为判断是从左到右&&做减法 所以左括号可用的个数大于右括号可用的个数，就剪枝*/
private fun dfs(curr: String, left: Int, right: Int, res: ArrayList<String>) {
    // 在递归终止的时候，直接把它添加到结果集即可，注意与「力扣」第 46 题、第 39 题区分
    if (left == 0 && right == 0) {
        res.add(curr)
        return
    }
    // 不会出现 "(()))(" 这种情况,因为在添加最后一个之前,左边可使用的个数大于右边,剪枝
    if (left > right) return

    if (left > 0) dfs("$curr(", left - 1, right, res)

    if (right > 0)  dfs("$curr)", left, right - 1, res)
}
