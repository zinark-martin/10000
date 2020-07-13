package leetcode
//查看一个串是不是另一个旋转得来的, 没弄清"旋转"什么意思, 但是如果是, 那么必须满足两个条件
//1. 两个长度相等 2. 其中一个再连接一个它自己, 必定包含另一个串
fun isFlipedString(s1: String, s2: String): Boolean {
    return s1.length == s2.length && (s1 + s1).contains(s2)
}
