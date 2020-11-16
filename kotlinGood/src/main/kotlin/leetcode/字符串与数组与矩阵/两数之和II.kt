package leetcode.字符串与数组与矩阵
//https://leetcode-cn.com/problems/two-sum/submissions/
//这个方式是看右边有没有等于差值的数字
//另一个方法是看左边有没有合适的数字
//(另一个更直观一些)
fun twoSum(numbers: IntArray, target: Int): IntArray {
    for (i in numbers.indices) {
        if (numbers.copyOfRange(i + 1, numbers.size).contains(target - numbers[i])) {
            return intArrayOf(i, numbers.copyOfRange(i + 1, numbers.size).indexOf(target - numbers[i]) + (i + 1))
            //由于查找另一半是在当前数字之后的数组中进行的, 所以得加上当前数字的位
        } else continue
    }
    return intArrayOf(0,0)
}

fun main() {
    println(twoSum(intArrayOf(2,7,11,15), 9).toList())
}