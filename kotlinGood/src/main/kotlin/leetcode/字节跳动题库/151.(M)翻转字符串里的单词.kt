package leetcode.字节跳动题库
//https://leetcode-cn.com/problems/reverse-words-in-a-string/
//翻转单词, 不翻转字母
//有两个以及以上的空格需要考虑

fun reverseWords(s: String): String {
    var r = s.length - 1
    var l = s.length - 1
    val res = StringBuffer()
    while (l >= 0) {
        while (l >= 0 && s[l] != ' ') {
            l--
        }//l的左边是空格,结束循环
        for (index in l + 1 .. r) {
            res.append(s[index])
        }
        res.append(' ')
        while (l >= 0 && s[l] == ' ') {
            l--
        }
        r = l
    }
    return res.toString().trim()
}
fun main() {
    println(reverseWords("the sky is blue"))
}