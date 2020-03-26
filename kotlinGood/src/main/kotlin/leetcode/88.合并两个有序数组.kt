package leetcode
/**
 * title:将零个有序数组合并到第一个有序数组里面
 * keys:太简单了不说了, 说一下System.arraycopy函数, 把前一个数组从scrPos开始复制,
 * 复制到后一个数组从destPos开始, 一共复制length位
 * */

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    var j = 0
    System.arraycopy(nums2, 3, nums1, 3, 2)
    //for (i in m until m + nums2.size) nums1[i] = nums2[j++]
    println(nums1.joinToString())
}
fun main() {
    val nums1 = intArrayOf(1, 2, 4, 5, 6, 7, 8,0,0,0,0,0,0)
    val nums2 = intArrayOf(9, 10, 11, 12, 13)
    merge(nums1,8,nums2,5)
}