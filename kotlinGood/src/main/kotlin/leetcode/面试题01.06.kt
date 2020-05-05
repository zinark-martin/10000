package leetcode

fun compressString(S: String): String {
    if (S.length <= 1) return S

    val sb = StringBuffer().append(S[0])
    var num = 1
     for (i in 1 until S.length) {
         if (S[i] == S[i-1]) {
             num += 1
         } else {
             sb.append(num).append(S[i])
             num = 1
         }
     }
     //return时append最后一个数字
    return if (sb.append(num).length < S.length) sb.toString() else S
}
fun main() {
    println(compressString("aabbddaa"))
}