package leetcode

fun reverseList(head: ListNode?): ListNode? {
    var pre: ListNode? = null
    var cur = head
    //tmp 用来记录指针逆置前的"下一位"
    var tmp: ListNode? = null

    while (cur != null) {
        tmp = cur.next
        cur.next = pre

        pre = cur
        cur = tmp
    }
    return pre
}