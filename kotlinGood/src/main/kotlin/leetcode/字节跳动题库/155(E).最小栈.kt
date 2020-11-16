package leetcode.字节跳动题库

import java.util.*
//https://leetcode-cn.com/problems/min-stack/solution/zui-xiao-zhan-by-leetcode-solution/
class MinStack() {
    private val stack = ArrayDeque<Int>()
    //如果不是调用kotlin拓展的sorted方法,就使用辅助栈
    //辅助栈与真栈同进出,始终保持更小的在栈顶----添加时如果更小就压栈
    //如果没有更小就再添加一次栈顶的元素,保证从上一次遇到最小到下一次遇到最小
    //"这段时间里"都是同一个最小数
    fun push(x: Int) {
        stack.add(x)
    }
    fun pop() {
        if (stack.isNotEmpty()) stack.pollLast()
    }

    fun top(): Int? {
        return if (stack.isNotEmpty()) stack.peekLast() else null
    }

    fun getMin(): Int {
        return stack.sorted()[0]
    }
    //sorted才是返回一个排序后的List 并且不会改变对象本身
}

