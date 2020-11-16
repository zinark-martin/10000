package leetcode

fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    var result: ListNode? = null
    for (node in lists) {
        result = mergeTwoLists(result, node)
    }
    return result
}

fun mergeTwolists(l1: ListNode?, l2: ListNode?): ListNode? {
    // 递归出口
    if (l1 == null) return l2
    if (l2 == null) return l1
    return if (l1.`val` < l2.`val`) {
        // 较小的节点指向递归后,返回当前节点
        l1.next = mergeTwoLists(l1.next, l2)
        l1
    } else {
        l2.next = mergeTwoLists(l2.next,l1)
        l2
    }
}
