package leetcode

/**
1.     1
2.     11
3.     21
4.     1211
5.     111221
第一项是数字 1
描述前一项，这个数是 1 即 “一个 1 ”，记作 11
描述前一项，这个数是 11 即 “两个 1 ” ，记作 21
描述前一项，这个数是 21 即 “一个 2 一个 1 ” ，记作 1211
描述前一项，这个数是 1211 即 “一个 1 一个 2 两个 1 ” ，记作 111221
 ********************************************************************************
 * data 2020/7/16
 * 解法
 *首先一组数是对上一组数字的描述, 所以直接递归.(也可以从前往后迭代) 先拿到上一组数, 然后设置两个前后指针
 *前面的前驱时若遇到和后面的不一致的数字, 就记录两者长度差值即作为"数量"
 *再记录后指针的数字, 即作为"数字"
 *
 *
 * */
fun countAndSay(n: Int): String {
    val s = StringBuilder()
    if (n==1) return "1"
    if (n==2) return "11"
    var str = countAndSay(n - 1)
    var front = 1
    var back = 0

    //front在前遍历完上一组的String
    while (front < str.length){
        if (str[front] != str[back]) {
            s.append(front - back).append(str[back])
            back = front
        }
        front++
        //最后一趟虽然不循环但是front还是会加一, 所以结束时front-back就是末尾的重复数字位数
    }
    //如果上一组数字的最后一段数字是相等的那么就被漏掉了
    //所以在这里判断, 若两个指针相等说明最后一段数字已经被更新了, 否则就是末尾出现了一段>=2的重复数字
    if (front != back) {
        s.append(front - back).append(str[back])
    }
    return s.toString()
}

fun main() {
    println(countAndSay(9))
}