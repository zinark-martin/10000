package leetcode
/**
 * 首先要注意char类型的toInt()转换的ASCII码, 要先转化为String再转化Int
 * 再就是这个转换为Long再加和的方法行不通, 链表稍微一长就超出Long的位数了
 * 而且在加和和构建链表时, 进行了两次reverse显然可以不用reverse, 而且两个链表的遍历也可以放在一起进行
* */
fun addTwoNumbers1(l1: ListNode?, l2: ListNode?): ListNode? {
    val sum = helper1(l1) + helper1(l2)
    //println(sum)
    val res = ListNode(0)
    var p = res
    val sb = StringBuffer(sum.toString()).reverse()
    //println("sb is $sb")
    for (i in sb) {
        p.next = ListNode(i.toString().toInt())
        p = p.next!!
    }
    return res.next
}
fun helper1(head: ListNode?): Long {
    var newHead = head
    val list = StringBuffer()
    var res = ""
    while (newHead != null) {
        //println("喔 ${newHead.`val`}")
        list.append(newHead.`val`)
        newHead = newHead.next
    }
    for (i in list.reverse()) {
        //println("啊 $i")
        res += i.toString()
    }
    //println(res.toInt())
    return res.toLong()
}
/**
 * carry参与处理两个数字相加超过十的情况
 * 因为链表是从个位开始遍历的, 构建链表时也时从个位开始的, 所以不需要逆转, 每位加和后直接可以构建
 * */
fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var p1 = l1
    var p2 = l2
    val result = ListNode(0)
    var p: ListNode? = result
    var carry = 0
    //carry > 0 保证上最后一次如果有溢出位,它能被添加进去
    while (p1 != null || p2 != null || carry > 0) {
        var sum = carry
        //结点事null默认零
        sum += p1?.`val` ?: 0
        sum += p2?.`val` ?: 0
        p!!.next = ListNode(sum % 10) //取个位
        p = p.next
        carry = sum / 10 //清个位
        //结点是null停止前驱
        if (p1 != null) p1 = p1.next
        if (p2 != null) p2 = p2.next
    }
    return result.next
}

