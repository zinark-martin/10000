package leetcode.字符串与数组与矩阵

//https://leetcode-cn.com/problems/distribute-candies-to-people/

fun distributeCandies(candies: Int, num_people: Int): IntArray {
    val kids = IntArray(num_people)
    var candies = candies
    var i = 0
    while(candies != 0) {
        // 核心: i % num_people
        // 因为每个孩子糖果是顺序递增 并且每新一轮开始糖果增加数==人数(n)
        kids[i % num_people] += candies.coerceAtMost(i + 1)
        //最后一个孩子要是不够按数量给就给予剩余糖果
        candies -= candies.coerceAtMost(i + 1)
        i += 1
    }
    return kids
}
