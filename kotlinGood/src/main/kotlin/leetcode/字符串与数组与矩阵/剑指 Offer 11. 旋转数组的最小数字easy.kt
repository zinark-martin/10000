package leetcode.字符串与数组与矩阵

fun minArray(numbers: IntArray): Int {
    var back = 0
    var front = numbers.size - 1
    while (back < front) {
        var c = (back + front) / 2 //取中间
        println(numbers[c])
        when {
            numbers[c] > numbers[front] -> back = c + 1
            //区间中点大于末尾,说明旋转点在center后面,于是更新后指针
            numbers[c] < numbers[front] -> front = c
            //区间的中间点小于区间末尾,说明这个区间(m,j)是递增的所以是正常连续区间,旋转点在center前面
            //不能跳过边界中间点,因为目标就在区间中,有可能c就是
            else -> front--
            //有重复元素,不能确定
        }
    }
    return numbers[back]
}
