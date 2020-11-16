package leetcode.字符串与数组与矩阵

import java.util.*
//https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
//TODO:不使用额外空间, 使用一种类快排的做法
/*最简单的方法:优先栈
* 优先栈自带排列,使用其来保存k个元素,这样最后返回队列最前端就是第k大数字
* 循环中,如果队列的大小若大于了k,就出队列,也就是队列中最小的数字,始终保持保存k个最大数字*/
fun findKthLargest(nums: IntArray, k: Int): Int {
    val queue = PriorityQueue<Int>()
    for (i in nums) {
        queue.add(i)
        if (queue.size > k)
            queue.poll() // 把小的出队
    }
    return queue.peek()
}

/*一行代码排序后返回,面试时可以拿来开个玩笑*/
fun findKthLargest2(nums: IntArray, k: Int): Int {
   return nums.sorted()[nums.size - k]
}
fun main() {
    println(findKthLargest2(intArrayOf(3,2,1,5,6,4), 2))
}