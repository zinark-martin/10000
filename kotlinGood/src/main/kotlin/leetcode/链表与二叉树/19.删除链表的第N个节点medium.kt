package leetcode.链表与二叉树
import leetcode.ListNode
/**
 * 思想就是快慢指针很简单
 * 唯一难点在于类似kotlin这样只允许在方法中引用传递的情况
 * 如果只有一个节点并且让你删除这个节点,你将无法改变head的指向
 * 所以使用一个伪首节点指向head,并将其最为返回值,这样就能解决单node的问题*/
fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    val realHead = ListNode(0, head)
    //手动更改head:添加一个node指向head以防止只有一个node的情况
    var fast:ListNode? = realHead
    var slow:ListNode? = realHead
    var count = 0
    while (fast?.next != null) {
        fast = fast.next
        count++
        if (count <= n) continue //使快指针比慢指针多走n次
        slow = slow?.next
    }
    slow?.next = slow?.next?.next
    return realHead.next
}