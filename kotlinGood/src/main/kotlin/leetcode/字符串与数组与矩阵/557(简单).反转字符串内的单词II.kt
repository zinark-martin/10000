package leetcode.字符串与数组与矩阵

/**
 * java系语言中, String是不可变类型
 * 故不能像cpp语言中使用swap交换String的单个字母
 * 基本逻辑: 快慢双指针,while里面两个平行循环,一个用于前驱寻找空格使快慢指针确定的区间就是单词
 * 一个for循环从后往前把字母依次添加进stringBuffer以做到逆置.最后前驱快指针到下一个单词并添加' '
 * 返回前需要trimEnd掉最后一次添加的' '
 * ***********************************************************
 * 特色: kotlin的downTo循环以及三种trim方式
 *
 * */
fun reverseWordsII(s: String): String? {
    val res = StringBuffer()
    val n = s.length
    var front = 0
    val array = s.trim().split(" ")
    while (front < n) {
        val back = front
        while (front < n && s[front] != ' ') {
            front++
        }
        for (p in front - 1 downTo back) {
            res.append(s[p])
        }
        front++
        res.append(' ')
    }
    return res.toString().trimEnd()
}
fun main() {
    println(reverseWordsII("the sky          is blue"))
}