package leetcode

fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    var result: ListNode? = null
    for (lili in lists) {
        result = mergeTwoLists(result, lili)
    }
    return result
}


fun mergeTwolists(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null) return l2
    if (l2 == null) return l1

    if (l1.`val` < l2.`val`) {
        l1.next = mergeTwoLists(l2, l1.next)
        return l1
    } else {
        l2.next = mergeTwoLists(l1, l2.next)
        return l2
    }
}