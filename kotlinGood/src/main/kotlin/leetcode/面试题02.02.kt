package leetcode
/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * ,}
 */

class ListNode(var `val`: Int, var next: ListNode? = null)
//查找链表倒数第k个结点
//一开始是想遍历一遍链表然后记录下长度, 在遍历一次停留在(长度 - k)的地方 返回这的值. 但是超时了
//看了题目的提示后发现有三个方法, 第一个记录所有值返回倒数k, 第二个使用双指针, 前面的比后面多两节点, 第三个递归

fun kthToLast(head: ListNode?, k: Int): Int {
//    var p = head
//    val list = mutableListOf<Int>()
//    while (p?.next != null) {
//        list.add(p.`val`)
//        p = p.next
//    }
//    list.add(p!!.`val`)
//   return list[list.size - k]
    //方法2.快慢指针 当前指针走k步后再开始后指针的前驱
    var front = head
    var back = head
    var count = 0
    while (front?.next != null) {
        front = front.next
        count++
        if (count < k) {
            continue
        }
        back = back?.next
    }
    return back!!.`val`
}
