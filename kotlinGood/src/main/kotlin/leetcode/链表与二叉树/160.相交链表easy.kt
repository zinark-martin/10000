package leetcode.链表与二叉树

import leetcode.ListNode
/**
 * 第一种方法:缓存法
 * 和环形链表的第一种解法一致,都是用set作为一个缓存来看有没有重复的
 * issue:需要先循环缓存一条再去循环判断另一条,在同一个循环中同时判断 前驱 缓存
 * 会出现错误,没有找出问题处,猜测是在"同时"上
 * 分开缓存和查询jiu*/
fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
    var set = HashSet<ListNode>()
    var nodeA = headA
    var nodeB = headB
    while (nodeA != null) {
        set.add(nodeA)
        nodeA = nodeA.next
    }
    while (nodeB != null) {
        if (set.contains(nodeB)) {
            return nodeB
        }
        nodeB = nodeB.next
    }
    return null
}

/**
 * 思路二:"浪漫解法" 减少空间复杂度 增加时间复杂度
 * 两个指针走完自己的路走对方的路,一直这样
 * 如果两者有相交,那么到相交的时候,走过的路是一样长的
 * 这并不是一个死循环,因为没有交点的两个链表,两个指针都会有一次同时指向null
 * 使 pA == pB 来结束while循环
 */
fun getIntersectionNode2(headA: ListNode?, headB: ListNode?): ListNode? {
    var pA = headA
    var pB = headB
    while (pA != pB) {
        pA = if (pA == null) headB else pA.next
        pB = if (pB == null) headA else pB.next
        //若没有重叠,两者都会有一次同时指向null,来结束while循环
    }
    return pA
}