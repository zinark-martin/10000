package leetcode.字节跳动题库

import leetcode.ListNode

/*使用递归 先压栈到末尾 再从后往前地一个栈一个节点地操作*/
fun reverseList(head: ListNode?): ListNode? {
    if (head?.next == null) {
        return head // 递归出口,把最后一个结点返回给head
    }
    val curr = reverseList(head.next)
    // 从最后一层开始,此时curr就是倒数第一个结点
    // head是倒数第二个结点(也就是上一层传入的参数head)
    head.next?.next = head
    head.next = null
    return curr//返回上一层
}

//使用双指针
fun reverseList2(head: ListNode?): ListNode? {
    var back:ListNode? = null
    var front = head
    while (front != null) {
        val nextNode = front.next//缓存前面节点,以便断链后使用
        front.next = back//逆转
        back = front//back前驱
        front = nextNode//front利用缓存前驱
        /**不用back.next = nextNode 因为除了第一个null以为,每个节点上一次都指向前节点了*/
    }
    return back
}
