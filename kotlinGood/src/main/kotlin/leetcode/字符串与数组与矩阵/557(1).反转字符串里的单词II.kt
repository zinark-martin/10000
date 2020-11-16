package leetcode.字符串与数组与矩阵

//557

fun reverseWords2(s: String): String {
    var l = 0
    var r = 0
    val str: String = s.trim() + ' '
    val res = StringBuffer()
    //这里可以使用末尾增加零来使循环多判断最后一次,解决它漏掉最后一个word的问题
    while (r < str.length) {
        if (str[r] == ' ') {
            for (index in r-1 downTo l) {
                res.append(str[index])
            }
            res.append(' ')
            l = r + 1 //
        }
        r++

    }
    return res.toString().trimEnd()
}
//上面需要多添加一个space在末尾去防止最后一个单词不操作
//这里使用第二个while循环,将结尾也算一次遍历的边界
fun reverseWords3(s: String): String {
    var l = 0
    var r = 0
    val str: String = s.trim()
    val res = StringBuffer()
    while (r < str.length) {
        while (r < str.length && str[r] != ' ') {
            r++
        }
        for (index in r - 1 downTo l) {
            res.append(str[index])
        }
        res.append(' ')
        l = r + 1 //跳过前面一个space所以加一,若在最上面赋值,就不用加一因为右指针已经前驱一位了
        r++
    }
    return res.toString().trimEnd()
}


fun main() {
    println(reverseWords3("the sky is blue"))
}