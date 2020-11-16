package leetcode.字符串与数组与矩阵

//https://leetcode-cn.com/problems/reverse-string/
/*利用双指针对原数组进行交换*/
fun reverseString(s: CharArray) {
    val n = s.size
    var front = 0
    var tmp: Char
    var back = n - 1
    while (back > front) {
        tmp = s[front]
        s[front++] = s[back]
        s[back--] = tmp
        // 顺便自增减来收缩指针
    }
}
/*因为原题要求是返回Unit,所以必须在原数组上改动,也就不能使用额外对象StringBuilder转存了*/
//fun reverseString2(s: CharArray): CharArray {
//    val n = s.size - 1
//    val sb = StringBuilder()
//    for (i in n downTo 0) {
//        sb.append(s[i])
//    }
//    return sb.toString().toCharArray()
//}
