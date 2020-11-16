package leetcode.链表与二叉树

import leetcode.ListNode
/**
 * 思路:走迷宫
 * 若找到出口即代表不是闭环
 * 若是闭环,给每个节点做记号,一旦重新回到记号处表示存在环
 * 记号就是把每个节点放进Hashset*/
fun hasCycle(head: ListNode?): Boolean {
    var newHead = head
    val set = HashSet<ListNode>()
    while (newHead?.next != null) {
        if (set.contains(newHead))
            return true
        else
            set.add(newHead)
        newHead = newHead.next
    }
    return false//遇到null结束循环,并且代表不存在闭环
}
/**
 * 这里注意一个问题
 * 因为两个结点一样就直接返回了
 * 所以如果像142那样,双指针起始点都是head的话,第一次判断就直接返回了
 * 把判断条件放到后面的话,两次都是null也就返回了(除非再要求其中一个不为空)
 * 而142还会进行弗洛伊德算法的再一次操作,条件不成立会再重新循环判断
 * 所以这里初始状态是一前一后
 **/
fun hasCycle2(head: ListNode?): Boolean {
    var fast = head?.next
    var slow = head
    while (fast != null) {
        if (fast == slow) return true
        fast = fast.next?.next
        slow = slow?.next
    }
    return false
}
