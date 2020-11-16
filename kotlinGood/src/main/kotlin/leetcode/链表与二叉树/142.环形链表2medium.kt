package leetcode.链表与二叉树
import leetcode.ListNode

/*第一种思想 继续使用HashSet,返回类型变一下就行了*/
fun detectCycle使用set(head: ListNode?): ListNode? {
    val set = HashSet<ListNode>()
    var node = head
    while (node != null) {
        if (set.contains(node))
            return node
        set.add(node)
        node = node.next
    }
    return null
}
//TODO(微软面试的时候要求过返回环形的长度)
/*思路:
*   首先一个前提是必须保证第一次相遇时慢指针没有走过一整个环,证明:因为快指针走的路径是慢指针的两倍
*   故慢指针走完一个环的时候快指针走两圈,一定会在慢指针走第二圈之前碰撞
*  1.一个cnt跟踪慢指针,因为快慢第一次相遇的时,快指针实际上已经走了重复的路了.相交之后改为跟踪快指针
*    在一个cnt2跟踪新出发的慢指针,这样两者第二次在环形起点相遇时,刚好cnt比cnt2多走了一个环形
*  2.也可以在找到环形入口后用一个记录这个节点,然后用cnt记录一个指针,它继续从环形交点走,直到和引用相等时,就是走了一圈*/
/*
 * 弗洛伊德算法
 * 快慢指针相交后,一个留在原地,一个从头开始走
 * 相遇的地方就是环形开始的地方
 * 因为这时对于相遇的结点,一个指针走了一圈,一个指针走了完非环形区域
 * 如果不再这相遇,那么他们就永远无法相遇,因为错过相交点后,两个指针就变成了同方向
 * 同速度,一起在环形中死循环
 * 而需要注意! 两者最开始要一起从头节点出发(不能var fast = head?.next)
 * 因为这样才可以满足上述的两者相遇时走的路程
 * 的差值刚好等于"非环形路程",因为快指针多走了一步*/
fun detectCycle(head: ListNode?): ListNode? {
    var fast = head
    var slow = head
    while (fast != null) {
        fast = fast.next?.next
        slow = slow?.next
        if (fast == slow) {
            slow = head
            while (slow != fast) {
                slow = slow?.next
                fast = fast?.next
            }
            return fast
            // 两者相撞时即是开始的地方
        }
    }
    return null
}