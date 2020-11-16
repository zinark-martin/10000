package leetcode.链表与二叉树

import leetcode.ListNode


fun removeElements(head: ListNode?, `val`: Int): ListNode? {
    val dummy: ListNode? = ListNode(Int.MAX_VALUE, head)
    //用伪头结点可以解决链表不能更改头节点的情况
    var pre = dummy
    while (pre?.next != null) {
        if (pre.next?.`val` == `val`) {
            pre.next = pre.next?.next
        } else {
            pre = pre.next
        }
    }
    return dummy?.next
}
