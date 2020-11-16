package leetcode.字节跳动题库
/**
 * 使用string的API: indexOf(String) (或者将判断变为判断两者第一个字符是否相等)
 * substring(String)重载方法会返回第一次在调用方中查找到完整参数字符串的位置
 * 如果没有包含参数字符串,返回-1
 * while中判断:若条件不成立则从右截取前缀的substring使前缀缩短来退让
 * 空则说明全部砍掉,没有前缀,则返回空字符串*/
fun longestCommonPrefix(strs: Array<String>): String {
    if (strs.isEmpty()) {
        return ""
    }
    var res = strs[0]
    for (i in 1 until strs.size) {
        while (strs[i].indexOf(res) != 0) {
            res = res.substring(0, res.length - 1)
            if (res.isEmpty()) return ""
        }
    }
    return res
}

