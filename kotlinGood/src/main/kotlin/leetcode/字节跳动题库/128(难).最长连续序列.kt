package leetcode.字节跳动题库

fun longestConsecutive(nums: IntArray): Int {
    val numSet: MutableSet<Int> = HashSet()
    for (num in nums) {
        numSet.add(num)
    }
    var res = 0
    for (num in numSet) {
        if (!numSet.contains(num - 1)) {
            var currentNum = num
            var currentStreak = 1
            while (numSet.contains(currentNum + 1)) {
                currentNum += 1
                currentStreak += 1
            }
            res = res.coerceAtLeast(currentStreak)
        }
    }
    return res
}
