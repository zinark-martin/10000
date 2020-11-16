package leetcode.字节跳动题库

fun multiply(num1: String, num2: String): String {
    val array = IntArray(num1.length + num2.length)//结果最长就是两个数字的位数相加
    //从低位向高位,所以倒序遍历
    for (i in num1.length - 1 downTo 0) {
        for (j in num2.length - 1 downTo 0) {
            val multi: Int = (num1[i] - '0') * (num2[j] - '0')
            //相当于两个个位数相乘,乘积最小是0,最大是81,一个两位数
            //每两个个位数的乘积的位数,符合以下特点:个位在i+j+1,十位在i+j,即一左一右
            //由于这一次乘积的个位可能存在上次乘积的十位,需要加上后者,即"重叠"
            val l = i + j
            val r = i + j + 1
            val sum = multi + array[r] //靠右边的那一位,即上次的十位
            //重叠的数字中,右边即个位是上次的十位和这次的个位, 左边是这次的真正十位
            array[r] = sum % 10
            array[l] += sum / 10
        }
    }
    //以下进行高位去0,结果为0判断,转化数字为字符然后添加进结果
    val res = StringBuffer()
    var i = 0
    val zeroNums = array.size
    while (i < array.size && array[i] == 0) {//(!!这个顺序一定要注意,否则先判断res[i]的话这里会越接
        i++
    }
    if (i == zeroNums) return "0"
    for (index in i until array.size) {
        res.append('0' + array[index])//这里一定要写成'0'作为加数
    }
    return res.toString()
}
fun main() {
    println(multiply("123","123"))
}
