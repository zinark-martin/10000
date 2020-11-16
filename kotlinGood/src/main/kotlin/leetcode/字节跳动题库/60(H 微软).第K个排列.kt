package leetcode.字节跳动题库
import java.util.*
//https://leetcode-cn.com/problems/permutation-sequence/solution/hui-su-jian-zhi-python-dai-ma-java-dai-ma-by-liwei/
fun main() {
    println(getPermutation1(6,50))
}
/**
 * 从(n-1)开始相当于把排列组合树的头节点砍了,因为头节点并不能确定某个数,它只是汇总了所有组合的数量
 * 循环 + 剪枝算法
 * 思想: k这一个组合必然会落到 0~n!这个闭区间内,那么我们就需要关注0~(n-1!)这个闭区间,表示确定了第一个数字后
 * 剩下的排列组合数量,对于往后的每一层都可以分为 n份(n-1)!的组合,每次如果k大于一个n-1,我们就减去这个n-1,
 * 同时将数字往后一位
 * 举个例子,若我们找6的阶乘的第k,那么首先一共有n!个排列,在确定了第一个数字后的结果有(n-1)!个,也就是有6个(n-1)!
 * 个区间现在,那么开始观察k,如果这个k小于区间(n-1)!就是说明它一定落在当前层的第一个区间内,那么添加上当前区间所对应的数;
 * 如果大于,就跳过这个区间(k - (n-1)!)然后查看下一个数,直到k小于(n-1)!,添加上这个区间对应的数字然后重复度操作
 * 每一层这样都可以确定n个(n-1)!的区间,k是由这些区间一层层累加起来的,所以每一层对k进行迭代处理,一层一层确定每一个数字,缩小k
 * 注意:需要避免重复添加,因为找数字的遍历层也就是第二层,是从所有数字遍历起的,我们应该跳过上面某一层已经添加过的数字
 * */
fun getPermutation1(n: Int, k: Int): String? {
//    手动编写n阶的阶乘 0 and 1 的阶乘是1,往后所有的阶乘都是它自己乘以(它-1)的阶乘
//    val array = mutableListOf<Int>().apply {
//        this[0] = 1
//        for (i in 0 until n) {
//            this[i] = this[i - 1] * i
//        }
//    }.toTypedArray()
    var k = k
    val arr = intArrayOf(1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880)
    val visited = BooleanArray(n + 1)
    Arrays.fill(visited, false)
    val permutation = StringBuilder()
    for (i in n - 1 downTo 0) {
        //我们需要关注的最大值是 (n - 1)!，表示确定第一个数后，剩下 (n - 1) 个数字全排列的组合数
        val cnt = arr[i]
        //cnt是代表在i层时以任何一个数字为开头的组合都有cnt组
        //注意:再下面的循环中,之所以每一趟减去的cnt都不变,是应为对应层数一致的情况下,以任何数字开头的组合
        for (j in 1..n) {
            if (visited[j]) {
                continue
            }
            if (k > cnt) {
                //往后跳一个数位之前,减去这个数位对应的"区间"
                //每次跳过的区间是一样大的因为对于同一层,每个首数字对于的区间大小相同
                k -= cnt
                continue
            }
            //k <= 这个cnt也就是当前数字的组合的数量区间,说明结果在当前区间产生,当前数字需要添加到结果中
            //然后设置为添加过防止重复添加,然后再找下一层:结束循环让大循环继续往前一位
            //这里用循环代替层级dfs也体现出来了
            visited[j] = true
            permutation.append(j)
            break
        }
    }
    return permutation.toString()
}
