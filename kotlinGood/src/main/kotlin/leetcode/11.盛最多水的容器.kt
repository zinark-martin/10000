package leetcode

fun maxArea(height: IntArray): Int {
    var res = 0
    var current: Int
    //双指针指向前后板子
    var back = 0
    var front = height.size-1
    //两板子在中间相遇即结束
    while (back < front) {
        //计算当前面积和更新结果
        current = (front-back)*(height[front].coerceAtMost(height[back]))
        res = current.coerceAtLeast(res)
        //小的那一个板子向中间移动
        if (height[back] <= height[front]) {
            ++back
        } else {
            --front
        }
    }
    return res
}