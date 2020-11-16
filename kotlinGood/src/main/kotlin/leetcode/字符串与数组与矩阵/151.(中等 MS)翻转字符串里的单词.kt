package leetcode.字符串与数组与矩阵
//https://leetcode-cn.com/problems/reverse-words-in-a-string/
//翻转单词, 不翻转字母
//有两个以及以上的空格需要考虑
/*翻转 也就是从后往前添加每个单词到StringBuffer中
* 利用双指针从后往前,左指针遍历到空格之前的位置,左右锁定一个单词,然后收缩右指针添加每个字母,
* 然后左指针跳过空格们,也就是"登陆"一个新的单词,再开始新一轮操作前把右指针前置到左指针"登陆"的位置*/
fun reverseWords(s: String): String {
    var r = s.length - 1
    var l = s.length - 1
    val res = StringBuffer()
    while (l >= 0) {
        while (l >= 0 && s[l] != ' ') {
            l--
        }// l的左边是空格,结束循环
        for (index in l + 1 .. r) {
            res.append(s[index])
        }
        // 添加一个空格
        res.append(' ')
        // 开始跳过空格们
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