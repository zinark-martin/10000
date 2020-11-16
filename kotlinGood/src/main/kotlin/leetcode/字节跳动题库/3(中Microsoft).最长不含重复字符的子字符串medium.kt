package leetcode.字节跳动题库
import java.util.*
/**
 * 双指针
 * 思路1: 使用两指针间的subString作为窗口
 * 思路2: 使用HashSet作为判重容器
 * 在排除重复项时使用while循环一直到排除完重复项为止
 * 2看起来只有一层循环,但其实while循环i你不是O(n),重复会多次循环处理. 1,2差不多一样
 * */
fun lengthOfLongestSubstring(s: String): Int {
    var back = 0
    var res = 0
    for (front in s.indices) {
        // front前驱 若出现重复的则从back开始砍,一直出现一直砍
        if (!s.substring(back, front).contains(s[front])) {
            res = res.coerceAtLeast(front - back + 1)
            //更新增加长度
        } else {
            while (s.substring(back, front).contains(s[front])) {
                back++ //缩减子序列
            }
        }
    }
    return res
}
//fun leetcode.微软题库.lengthOfLongestSubstring(s: String): Int {
//    var res = 0
//    var right = 0
//    var left = 0
//    val set = HashSet<Char>()// 只需要存一个值然后查看它有无重复
//    while (right < s.length) {
//        when {
//            set.contains(s[right]) -> {
//                set.remove(s[left++])
//            }
//            else -> {
//                set.add(s[right++])
//                res = res.coerceAtLeast(right - left)
//                // 这个时候right以及+1了,所以差值不用+1
//            }
//        }
//    }
//    return res
//}

fun main() {
    println(lengthOfLongestSubstring("pwwkew"))
}