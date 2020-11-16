package leetcode.字符串与数组与矩阵

import java.util.*

//https://leetcode-cn.com/problems/merge-intervals/
/**
 * 注意这个数组没说是有序的
 * 所以先排序,初始化一个集合,首元素是第一个子数组
 * 然后遍历每个子数组,将集合里第一个的右边和新的数组的左边比较
 * 若大于说明会重和,那么更改集合内这个区间的右边为新数组的右边
 * 否则说明不会重合直接添加新数组*/
/*update: 默写 + 改得顺手一些 使用list直接添加然后返回时转换成array就行了 好写不少并且省去余*/
fun merge(intervals: Array<IntArray>): Array<IntArray> {
    if (intervals.isEmpty()) return intervals
    Arrays.sort(intervals) { //正向排序
        first, second -> first[0] - second[0]
    }
    // 第一个区间添加进去作为初始对比对象
    val res = mutableListOf<IntArray>().apply { this.add(intervals[0]) }
    var i = 0
    // i记录res中被比较的对象的下标
    intervals.forEach {
        if (it[0] <= res[i][1]) {
            // 合并区间:更新res最前元素的右界
            res[i][1] = res[i][1].coerceAtLeast(it[1])
        } else {
            // 新数组左区间的更大,添加新数组
            res.add(it)
            i++
        }
    }
    return res.toTypedArray()
}

fun merge1(intervals: Array<IntArray>): Array<IntArray> {
    if (intervals.isEmpty()) return intervals
    Arrays.sort(intervals) { a, b -> a[0] - b[0] }
    // 按照每个子区间的左端点的大小为排序依据,排序所有区间
    // comparator接口 -> 重写 int compare(T o1, T o2)
    // 如果这个返回值是正则交换, 是负数则不动 (因为从小到大排序)
    val res: Array<IntArray> = Array(intervals.size) { IntArray(2) }.also {
        it[0] = intervals[0]
        //把第一个区间添加为初始区间
    }
    var index = 0
    for (curr in intervals) {
        // 左边大于现有数组的右边 就单纯添加这个区间
        if (curr[0] > res[index][1]) {
            res[++index] = curr
        } else {
            //反之取右边大的那个的右边 (因为有可能出现包含区间:[1,5][2,3])
            res[index][1] = res[index][1].coerceAtLeast(curr[1])
        }
    }
    return Arrays.copyOf(res,index + 1) //去除余下的位置
}
fun main() {
    println(merge(arrayOf(intArrayOf(0,2), intArrayOf(2,5))).forEach {
        println(it.toList())
    })
}