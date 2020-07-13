package leetcode

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    var dummy = ListNode(0)
    dummy.next = head
    var pre = dummy
    var back = dummy
    var count = 0
    while (pre.next != null) {
        pre = pre?.next!!
        count++
        if (count < n + 1) {
            continue
        }
        back = back?.next!!
    }
    back?.next = back?.next?.next
    return dummy.next
}

//单指针 两次循环
//fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
//    val dummy = ListNode(0)
//    dummy.next = head
//    var length = 0
//    var first = head
//    while (first != null) {
//        length++
//        first = first.next
//    }
//    length -= n//找到目标节点的长度
//
//    first = dummy
//    while (length > 0) {
//        length--
//        first = first?.next
//    }
//    first?.next = first?.next?.next
//    return dummy.next
//}




