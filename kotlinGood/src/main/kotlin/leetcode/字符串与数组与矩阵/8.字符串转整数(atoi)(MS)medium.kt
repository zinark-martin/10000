package leetcode.字符串与数组与矩阵
/**
 * 第一个非空字符串必须是正负号或者数字
 * 若不是则输出0
 * 若数字超出MAX_VALUE或者MIN_VALUE就返回最大数或最小数
 * 正负数就输出正负数
 * 思路: 先判断第一个字符, 决定要继续还是直接返回0, 如果继续就记住正负状态
 * 循环进位累加, 每次操作前都判断一次是否操作后会超出INT限制
 * 返回时更具状态加上正负号*/

fun myAtoi(str: String): Int {
    val realStr = str.trim()
    val n = realStr.length
    //去掉首位空格并记录长度
    var index = 0
    var state = 0
    var ans = 0
    when {
        realStr.isEmpty() -> return 0
        !realStr[0].isDigit() && realStr[0] != '-' && realStr[0] != '+' -> return 0
        realStr[0] == '+' -> {
            state = 1
            index++
        }
        realStr[0] == '-' -> {
            state = 2
            index++
        }
    }
    //头字符处理完毕, 开始进位相加
    var num: Int
    while (index < n && realStr[index].isDigit()) {
        //循环条件: 只要str没结束并且当前的Char还是个数字
        num = realStr[index] - '0'
        //一个数字char减去0的ASCII码就是它代表的数字
        if (ans > (Int.MAX_VALUE - num) / 10) return if (state == 2) Int.MIN_VALUE else Int.MAX_VALUE
        //必须要在加乘之前判断, 因为加成后要是超出限制结果就会变了
        ans = ans * 10 + num
        index++
    }
    return if (state == 2) -ans else ans
}
fun main() {
    println(Int.MIN_VALUE)
    println(myAtoi("2147483646"))
}
