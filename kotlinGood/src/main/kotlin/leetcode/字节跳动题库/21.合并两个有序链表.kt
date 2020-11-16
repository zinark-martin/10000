package leetcode.字节跳动题库

import leetcode.ListNode

/*
* Author 马
* data 2020/6/25
* 初始思路:因为两个链表是有序的, 合并的时候判断当前节点和对面的最前节点的大小, 还需要判断和当前链表
* 的下一个节点的大小, 每个链表设置两个指针, 一个前驱一个操作当前节点
* 进阶思路:初始的是暴力破解,写起来还有更简单的递归写法,虽然空间复杂度会增高
* */

fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    //递归出口, 一个是null了返回另一个剩下的部分
    if (l1 == null) return l2
    if (l2 == null) return l1

    return if (l1.`val` < l2.`val`) {
        l1.next = mergeTwoLists(l1.next, l2)
        l1
    } else {
        l2.next = mergeTwoLists(l2.next, l1)
        l2
    }
}
