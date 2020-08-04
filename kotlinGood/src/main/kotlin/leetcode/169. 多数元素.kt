package leetcode

import java.util.*

/**
 * 投票法, 第一个人为初始候选人, 遇见和自己票一样的就count++, 不是的话就count--
 * 如果count为零, 就换下一个人为候选人
 * 因为如果这个数字是最终结果的话, 那么他肯定超过一半, 所以count--很多次后一定还是这个数字
 * 如果count为零就换, 同样道理, 这个数字须大于n/2所以不管从哪开始抵消到最后都是它
 * */
/**
 * 最简单法
 * 因为数字长度超过一半, 所以只要使得这些数字连续, 那么数组一半的位置总归是它
 * */
/**
 * HashMap法
 * 如代码
 * */

private fun countNums(nums: IntArray): Map<Int, Int> {
    val counts: HashMap<Int, Int> = HashMap()
    var list = mutableListOf<Int>().apply {
        addAll(listOf(1,2))
    }
    for (num in nums) {
        if (!counts.containsKey(num)) {
            counts[num] = 1
        } else {
            counts[num] = counts[num]!! + 1
        }
    }
    return counts
}

fun majorityElement(nums: IntArray): Int? {
    val counts = countNums(nums)

    //从键取值是低效的, 而且这里去了值找了最大还得返回它对应的key, 所以无论什么时候都不应该首选
    //使用entry的方式, 也就是遍历每一个键值对, 对单一键值对的值进行操作是最高效的

    var majorityEntry: Map.Entry<Int?, Int?>? = null
    //这里注意空类型和判空逻辑, 因为值必须初始化所以设null再判空一次
    for (entry in counts.entries) {
        if (majorityEntry == null || entry.value > majorityEntry.value!!) {
            majorityEntry = entry
        }
    }
    return majorityEntry?.key
}