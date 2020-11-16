package leetcode.字符串与数组与矩阵

//https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum/submissions/
fun canThreePartsEqualSum(A: IntArray): Boolean {
    val sum = A.sum()
    if (sum % 3 != 0) return false
    var count = 0
    var curr = 0
    A.forEach {
        curr += it
        if (curr == sum / 3) {
            count++
            curr = 0
        }
    }
    //如果sum为0 count是可以大于3的
    return count >= 3
}

//双指针
fun canThreePartsEqualSum1(A: IntArray): Boolean {
    val sum = A.sum()
    var left = 0
    var right = A.size - 1
    var leftSum = A[left]
    var rightSum = A[right]
    if (sum % 3 != 0) return false
    while (left + 1 < right) {
        when {
            leftSum == sum / 3 && rightSum == sum / 3 -> {
                return true
            }
            leftSum != sum / 3 -> {
                leftSum += A[++left]
            }
            rightSum != sum / 3 -> {
                rightSum += A[--right]
            }
        }
    }
    return false
}