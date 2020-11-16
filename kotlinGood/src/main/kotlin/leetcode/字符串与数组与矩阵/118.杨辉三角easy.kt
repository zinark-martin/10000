package leetcode.字符串与数组与矩阵

fun generate(numRows: Int): List<List<Int>> {
    var res = arrayListOf<List<Int>>() //结构:大list嵌套numRows个小list
    for (i in 0 until numRows) { //每一层循环的起始处new一个针对本层的list,在结束处将其add
        var subList = arrayListOf<Int>()
        for (j in 0..i) {
            if (j == 0 || j == i) subList.add(1)//每一层的第一个和[n,n]也就是最后一个都是0
            else subList.add(res[i - 1][j] + res[i - 1][j - 1])//杨辉三角中间的加法原则是上一侧的这个位置的与其相邻的相加

        }
        res.add(subList)
    }
    return res
}