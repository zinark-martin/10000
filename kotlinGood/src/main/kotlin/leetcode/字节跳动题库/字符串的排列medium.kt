package leetcode.字节跳动题库
//同438
fun checkInclusion(s1: String, s2: String): Boolean {
    val map = HashMap<Char, Int>()
    val carry = HashMap<Char, Int>()
    var l = 0
    var r = 0
    var match = 0
    s1.forEach {
        map[it] = map.getOrDefault(it,0) + 1
    }
    while (r < s2.length) {
        val right: Char = s2[r]
        if (map.containsKey(right)) {
            carry[right] = carry.getOrDefault(right, 0) + 1
            if (map[right]?.let { carry[right]?.compareTo(it) } == 0) {
                match++ //字符一致且数量够了,认为匹配
                //!!新加入的字符虽然还是会添加进来, 但是不会影响match数量
            }
        }
        while (match == map.size) {
            //进入此循环前提是匹配数量达到
            if (r - l + 1 == s1.length) {
                //判断是否连续
                return true
            }
            val left = s2[l]
            //判断左指针指向的,即边界,是不是已经算在carry里了
            if (carry.containsKey(left)) {
                //carry里面只会存放目标字符,所以如果当前左边界存在于carry中的话,就需要进行match删减
                //因为每个字符的match都是数量一致的,如果不一致就不能算匹配
                //(因为操作减一的后者其值有为空的可能,所以get时使用此方法设置默认指)
                carry[left] = carry.getOrDefault(left, 0) - 1
                if (carry.getOrDefault(left, 0) < map.getOrDefault(left, 0)) {
                    //这里是考虑重复添加目标元素,即删除一个目标元素还有剩余的话,不会影响match
                    match--
                }
            }
            //缩短左边界
            l++
        }
        r++
    }
    return false
}
fun main() {
    println(checkInclusion("abc","asddbcafsdab"))
}
/*
//官方题解, 使用数组代替HashMap提高效率
fun checkInclusion2(s1: String, s2: String): Boolean {
    if (s1.length > s2.length) return false
    val s1map = IntArray(26)
    val s2map = IntArray(26)
    //初始化哈希表,二十六个字母:index对应key,int对应value
    //即哪个字母出现几次
    for (i in s1.indices) {
        s1map[s1[i] - 'a']++
        s2map[s2[i] - 'a']++
        //字符减去'a'结果就是字母在26位中对应的index
        //字母对应的index的数字加一相当于标记这个字母出现多一次
        //这样一来我们现在就得到了s1各个元素在s2中的位置
    }
    //s2map作为窗口
    for (i in 0 until s2.length - s1.length) {
        if (matches(s1map, s2map)) return true
        s2map[s2[i + s1.length] - 'a']++
        //前面那个字母对应的index的int值加一,也就是前面这个字母多一个
        s2map[s2[i] - 'a']--
        //后面这个字母少一个
    }
    return matches(s1map, s2map)
}

fun matches(s1map: IntArray, s2map: IntArray): Boolean {
    for (i in 0..25) {
        if (s1map[i] != s2map[i]) return false
    }
    return true
}
fun leetcode.微软题库.leetcode.字节跳动题库.main() {
    println(checkInclusion2("abc", "efagbhbac"))
}
 */