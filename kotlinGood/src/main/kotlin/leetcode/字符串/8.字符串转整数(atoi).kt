package leetcode.字符串

/**
 * 第一个非空字符串必须是正负号或者数字
 * 若不是则输出0
 * 若数字超出MAX_VALUE或者MIN_VALUE就返回最大数或最小数
 * 正负数就输出正负数*/
fun myAtoi(str: String): Int {
    val realStr = str.trim()
    val n = realStr.length
    //去掉首位空格并记录长度
    //Remove the first space and to record the length
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
    //After the first character is processed, start carry and add
    var num: Int
    while (index < n && realStr[index].isDigit()) {
        //循环条件: 只要str没结束并且当前的Char还是个数字
        //Loop condition: as long as the str is not over yet and the current char represent a number
        num = realStr[index] - '0'
        //一个数字char减去0的ASCII码就是它代表的数字
        //The ASCII code of a number char minus 0 is the number it represents
        if (ans > (Int.MAX_VALUE - num) / 10) return if (state == 2) Int.MIN_VALUE else Int.MAX_VALUE
        //必须要在加乘之前判断, 因为加成后要是超出限制结果就会变了
        //It must be judged before addition and multiplication
        //because the result will change if the limit is exceeded after the addition and multiplication
        ans = ans * 10 + num
        index++
    }
    return if (state == 2) -ans else ans
}
fun main() {
    println(Int.MIN_VALUE)
    println(myAtoi("2147483646"))
}
