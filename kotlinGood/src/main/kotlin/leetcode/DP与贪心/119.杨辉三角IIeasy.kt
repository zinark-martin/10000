package leetcode.DP与贪心

/**
 * 给一个数字返回三角中的这一行
 * 1.递归会超时, 原理是中间的每个数字等于上一层同位置的数字加上它前一个位置的数字
 *   这里的"上一层"用的是递归,会超时
 * 2.找规律可以,数学上得算一算,公式很复杂
 * 3.DP用时非常短,原理在下面
 * */
fun getRow(rowIndex: Int): List<Int> {
    val res = arrayListOf<Int>()
    for (i in 0..rowIndex) {
        //层数的下标就等于这行的下标
        if (i == 0 || i == rowIndex) { //去除首位
            res.add(1)
        } else {
            val lastRow = getRow(rowIndex - 1)
            res.add(lastRow[i] + lastRow[i - 1])
        }
    }
    return res
}
/**
 * 动态规划的原理
 * 既然杨辉三角的每次曾都是在上一层基础上累加的
 * 那么对当前层使用这种累加就能到下一层*/
fun getRow2(rowIndex: Int): List<Int> {
    val res = arrayListOf<Int>()
    for (i in 0 .. rowIndex) {
        res.add(1)//每一次增加一位数,也是作为末尾那个不动的1
        for (j in 1 until i) {//去除第一个和最后一个的遍历
            res[j] += res[j - 1]//就是新的一层的结果
        }
    }
    return res
}
/**
 * 因为杨辉的特点是res[i] += res[i-1]
 * 为了防止后一位加上的前位, 是改变过的前位, 应当从后往前加*/
fun main(args: Array<String>) {
    println(getRow2(3))
}

