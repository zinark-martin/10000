package leetcode.链表与二叉树
// 把第二题两数相加的逆序链表换成顺序

import leetcode.ListNode
import java.util.*


/**"一般逆序都需要使用到栈"
 * 注意使用LinkedList实现栈的话,是pollLast() */
fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var l1 = l1
    var l2 = l2
    val stack1 = LinkedList<Int?>()
    val stack2 = LinkedList<Int?>()
    while (l1 != null) {
        stack1.add(l1.`val`)
        l1 = l1.next
    }
    while (l2 != null) {
        stack2.add(l2.`val`)
        l2 = l2.next
    }
    var carry = 0
    var realHead: ListNode?  = null
    // 注意输出的链表也变成了正序 所以需要头插法
    while (stack1.isNotEmpty() || stack2.isNotEmpty() || carry > 0) {
        val x = stack1.pollLast() ?: 0
        val y = stack2.pollLast() ?: 0
        val curr = x + y + carry
        val cache = ListNode(curr % 10)
        cache.next = realHead
        realHead = cache
        carry = curr / 10
    }
    return realHead
}
