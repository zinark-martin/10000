package leetcode.字符串与数组与矩阵
import java.util.*
//  46:
//  题目要是求是给定一个没有重复元素的数组要求返回其全排列,也就是说数组元素不一定是连续的
//  思路: dfs 回溯
//  每次添加满一组数字就会回退返回栈,去掉后面一个数字,继续上一层的遍历
//  因为每次循环是从头开始遍历,所以为防止在一个组合里面重复添加一个数字,
//  使用一个数组记录每个位置的重复情况,每次回退上一层后将其取消标记
/*相对于46多一个可重复元素条件
* 最简单的方法:返回时使用一个HashSet去重再包装进一个List
* 方法二先排序! 连续是方法二的前提!
* 方法二: 重点在于判断是同一支路还是同一个层,同一支则可以当作一般非重复情况看待,同一层就说明这两个下标不一样
*   但重复的数字会使这两个支路的答案一模一样,就需要舍弃分支
* 判断方法: 如果这个数字和它上一个数字相同了,则找到了一个重复数字,就需要判断两者是同一支还是平行层,
*   如果它前面的数字(的index),没有在当前支路的队列deque中,就说明它前的数字已经在1一个独立的分支中了,
*   这时两者就是同一层的平行关系,就舍弃这个分支; 如果与它相等的前面的数字nums[i-1]存在于的队列中,说明它在上面一层,
*   同属一支,正常添加
* 能看的出来前提是连续数组,所以必须先进行排序
* plus: 注意 i 每次对应的是刚被砍掉的数字的下标*/

fun permuteUnique(nums: IntArray): List<List<Int>> {
    val len = nums.size
    val res = mutableListOf<List<Int>>()
    if (len == 0) {
        return res
    }
    val used = BooleanArray(len)
    val deque = ArrayDeque<Int>(len)
    // 因为判断
    val nums = nums.sortedArray()
    //val 比较 = LinkedList(listOf(len))
    dfs1(nums, len, 0, deque, used, res)
    //从第0层开始
    // return LinkedList(HashSet(res))
    return res
}
private fun dfs1(nums: IntArray, len: Int, depth: Int,
                 deque: Deque<Int>, used: BooleanArray, res: MutableList<List<Int>>) {
        if (depth == len) {
            // 当添加满这一层的元素后才会add进res,然后回撤上一层(再往后遍历下一个数字)
            res.add(deque.toList())
            return
        }
    for (i in 0 until len) {
    //  增加条件: 当前的值等于前一个值且前一个值没有被使用过 (i > 0 是为了防止 used[i-1] 越界)
    //  对于 num[i-1] 和 num[i] 的两种情况:
    //  1.nums[i-1]没用过(true),它前面一个数字还没有用过,说明回溯到了同一层,它和它前面的数字是平行关系
    //  这时它和它前面数字如果重复,说明两个平行支路的结果将会是一样的,就不行
    //  2.nums[i-1]使用过(false),它前面一个数字已经添加进了这一趟的队列中,说明它在同支路的下面层,那么可以
    //  当作非重复情况看待,因为是同一支路所以不影响
        if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
            continue
        }
        //每次遍历会跳过前面(前面的递归栈)添加过的数字
        deque.addLast(nums[i])
        //这一组结果中没有这个数字的话,将其添加进队列
        used[i] = true
        dfs1(nums, len, depth + 1, deque, used, res)
        /*递归结束一次只回撤一个数字,继续for循环*/
        used[i] = false
        deque.removeLast()
    }
}
fun main() {
    println(permuteUnique(intArrayOf(2,1,4,1)))
}