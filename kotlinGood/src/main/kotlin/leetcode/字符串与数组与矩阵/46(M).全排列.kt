package leetcode.字符串与数组与矩阵
import leetcode.Solution
import java.util.*
//https://leetcode-cn.com/problems/permutations/
/**
 * 题目要是求是给定一个没有重复元素的数组要求返回其全排列,也就是说数组元素不一定是连续的
 * 思路: dfs 回溯
 * 每次添加满一组数字就会回退返回栈,去掉后面一个数字,继续上一层的遍历
 * 因为每次循环是从头开始遍历,所以为防止在一个组合里面重复添加一个数字,
 * 使用一个数组记录每个位置的重复情况,每次回退上一层后将其取消标记
 * */
fun permute(nums: IntArray): List<List<Int>> {
    val len = nums.size
    val res = mutableListOf<List<Int>>()
    if (len == 0) { return res }
    val used = BooleanArray(len)
    val deque = ArrayDeque<Int>(len)
    //val 比较 = LinkedList(listOf(len))
    dfs(nums, len, 0, deque, used, res)
    //从第0层开始
    return res
}
private fun dfs(nums: IntArray, len: Int, depth: Int,
                deque: Deque<Int>, used: BooleanArray, res: MutableList<List<Int>>) {
    if (depth == len) {
        // 当添加满这一层的元素后才会add进res,然后回撤上一层(再往后遍历下一个数字)
        res.add(ArrayList(deque))
        return
        /*每一次所有数字都被添加进队列后才会回撤*/
    }
    for (i in 0 until len) {
        if (used[i]) continue
        //每次遍历会跳过前面(前面的递归栈)添加过的数字

        deque.addLast(nums[i])
        //这一组结果中没有这个数字的话,将其添加进队列
        used[i] = true
        println("before -> $deque")
        dfs(nums, len, depth + 1, deque, used, res)
        /*递归结束一次只回撤一个数字,继续for循环*/
        used[i] = false
        deque.removeLast()
        println("after -> $deque")
        println("${deque.toList()} + 当前遍历下标:$i in (0 ~ ${nums.size - 1})")
    }
}
fun main() {
    val nums = intArrayOf(2,1,3,4)
    println(permute(nums))
}