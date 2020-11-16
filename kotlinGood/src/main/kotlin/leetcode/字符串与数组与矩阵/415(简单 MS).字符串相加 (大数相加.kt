package leetcode.字符串与数组与矩阵

//https://leetcode-cn.com/problems/add-strings/

fun addStrings(num1: String, num2: String): String? {
    when {
        num1[0].isDigit() && num2[0].isDigit() -> {

        }
        !num1[0].isDigit() && num2[0].isDigit() -> {

        }
        num1[0].isDigit() && !num2[0].isDigit() -> {

        }
    }
    val res = StringBuilder("")
    var i = num1.length - 1
    var j = num2.length - 1
    var carry = 0
    while (i >= 0 || j >= 0) {
        val n1 = if (i >= 0) num1[i] - '0' else 0
        val n2 = if (j >= 0) num2[j] - '0' else 0
        val tmp = n1 + n2 + carry
        carry = tmp / 10
        res.append(tmp % 10)
        i--
        j--
    }
    if (carry == 1) res.append(1)
    return res.reverse().toString()
}
fun main() {
    println(addStrings("32","12"))
}