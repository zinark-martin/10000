package leetcode.字符串与数组与矩阵
//https://leetcode-cn.com/problems/merge-sorted-array/
/**这道题给的条件和数据非常多
* 条件是数组1的长度大于等于数组1+数组2,数组1除了非零数字以外的长度用0补替
* 给的数据是m:数组1的非零区域,n:数组2的大小*/
fun merge2(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    var i = m
    for (j in nums2.indices) {
        nums1[i++] = nums2[j]
    }
    nums1.sort()
}
/*但是多一次的排序时间复杂度会增大
* 所以我们使用三指针,两个指针从两个数组的有效位末尾往前遍历,一个指针从数组1末尾开始遍历
* 两者的大值放到prt处也就是末尾哦,以此类推
* 但是会出现一个问题: 我们把数组1的前面和数组2都往数组1的零区域放,可能会剩下数组2中的一些小元素
* 所以需要在最后把数组2剩下的元素复制到数组1的最前面,若prt2完成了遍历就不会复制
**/
fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
    var ptr1 = m - 1
    var prt2 = n - 1
    var ptr = m + n - 1
    while (ptr1 >= 0 && prt2 >= 0) {
        nums1[ptr--] = if (nums1[ptr1] > nums2[prt2]) nums1[ptr1--] else nums2[prt2--]
    }
    // 表示将nums2数组从下标0位置开始，拷贝到nums1数组中，从下标0位置开始，长度为len2+1
    System.arraycopy(nums2, 0, nums1, 0, prt2 + 1)
}