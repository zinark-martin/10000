package leetcode
/**
 * tile:给出数字n, 给出从1到n这些连续数字能构成的二叉搜索树个数
 * 由于根各自不同，每棵二叉树都保证是独特的。
 * 可见，问题可以分解成规模较小的子问题。因此，我们可以存储并复用子问题的解，
 * 而不是递归的解决这些子问题，这就是动态规划法
 *
 * key:两层循环, 一层控制数组长度慢慢增加, 一层控制根节点慢慢后移
 *当前长度的结果 = 左子树的结果 * 右子树的结果
 *
 * */
fun numTrees(n: Int): Long {
    val G = LongArray(n + 1)
    G[0] = 1
    G[1] = 1
    //两层循环, 一层控制n慢慢增加, 一层控制根节点慢慢后移
    for (i in 2..n) {
        for (j in 1..i) {
            //左子树就是以当前根节点减一的n构成的树, 右子树就是以当前n减去根节点往前的数剩下的n构成的数
            //当前长度下每一个可能根节点对应的结果累加就是此长度时的结果
            G[i] += G[j - 1] * G[i - j]
        }
    }
    return G[n]
}
fun main() {
    println("${numTrees(3)}为最后结果")
    println(Long.MAX_VALUE)
    println(Int.MAX_VALUE)
    println(Long.SIZE_BYTES)
    println(Long.SIZE_BITS)
}