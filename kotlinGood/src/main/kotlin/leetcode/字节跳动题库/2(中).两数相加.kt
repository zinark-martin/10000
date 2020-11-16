package leetcode.字节跳动题库

import leetcode.ListNode
/*小技巧 对于链表问题, 返回结果为头节点时, 通常需要先初始化一个预先指针pre
该指针的下一个节点指向真正的头节点head. 这样使用预先指针的目的在于链表初始化时无可用的节点值
而且链表构造过程需要移动指针, 造成头指针丢失, 无返回结果 */
/**1.重点是将为null的节点当作值为0处理,就不用再结束循环后额外处理偏长的那一边了*
 * 2.注意!! 每次操作不要对当前节点的值操作,而是对下一位节点的值操作,这样就不用判断是否大于10了,
 *   直接交给一个进位值就行了,每次循环时加上它.
 * 3.最后处理一下最后一次的进位标记
 */
fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var l1 = l1
    var l2 = l2
    val Dummy = ListNode(0)
    var l3: ListNode? = Dummy
    var flag = 0 // 标记是否大于十需要进一位
    while (l1 != null || l2 != null) {
        // null 可以当作0对待
        val x = l1?.`val` ?: 0
        val y = l2?.`val` ?: 0
        val curr = x + y + flag
        flag = curr / 10 // 更新进位标识符
        l3?.next = ListNode(curr % 10) // 超出十位的就不要了,有flag
        l3 = l3?.next
        l2 = l2?.next
        l1 = l1?.next
    }
    if (flag == 1) l3?.next = ListNode(1)
    return Dummy.next
}


