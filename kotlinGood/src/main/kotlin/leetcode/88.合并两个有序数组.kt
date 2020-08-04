package leetcode

import java.util.*
import kotlin.collections.HashMap

/**
 * 要求将第二个数组合并到第一个里面, 第一个数组保证长度充足(补零占位符)
 * 第0中算法直接合并然后排序, 这样没有使用到"有序数组"这个条件
 * 下面的算法中从后往前维护三个指针, 分别是两个数组的有效位和其加和
 * 使用指针自减前驱的方式, 当地中一个数组比较完了结束循环, 这时会出现第一个数组先遍历完的情况
 * 这样就有可能将第二个数组里的元素落下, 因为"有序"且第一个"先结束", 所以落下的元素就是最小的
 * 把从0到当前二数组下标的元素从头粘贴给第一个数组就好了
 * */

fun merge0(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    var j = 0
    //System.arraycopy(nums2, 3, nums1, 3, 2)
    for (i in m until m + nums2.size) nums1[i] = nums2[j++]
}
fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
    var len1 = m - 1
    var len2 = n - 1
    var len = m + n - 1
    while (len1 >= 0 && len2 >= 0) {
        // 注意--符号在后面，表示先进行计算再减1，这种缩写缩短了代码
        nums1[len--] = if (nums1[len1] > nums2[len2]) nums1[len1--] else nums2[len2--]
    }
    // 由于是自减, len2+1现在就是当前下标
    // 将nums2数组从下标0位置开始，拷贝到nums1数组中，从下标0位置开始，长度为len2+1
    System.arraycopy(nums2, 0, nums1, 0, len2 + 1)
}
