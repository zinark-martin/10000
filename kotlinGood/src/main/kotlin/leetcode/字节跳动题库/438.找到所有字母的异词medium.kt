package leetcode.字节跳动题库

import java.util.*

//解法同字符串的排列,不过这里需要返回每一种可能的起始点
fun findAnagrams(s: String, p: String): MutableList<Int> {
    val map = HashMap<Char, Int>()
    val window = HashMap<Char, Int>()
    val ans: MutableList<Int> = ArrayList()
    for (ch in p.toCharArray()) {
        map[ch] = map.getOrDefault(ch, 0) + 1
    }
    var l = 0
    var r = 0
    var match = 0
    while (r < s.length) {
        val ch = s[r]
        if (map.containsKey(ch)) {
            window[ch] = window.getOrDefault(ch, 0) + 1
            if (map[ch]?.let { window[ch]?.compareTo(it) } == 0) {
                match++
            }
        }
        while (match == map.size) {
            if (r - l + 1 == p.length) {
                ans.add(l)
            }
            val leftChar = s[l]
            if (window.containsKey(leftChar)) {
                window[leftChar] = window.getOrDefault(leftChar, 0) - 1
                if (window[leftChar]!! < map[leftChar]!!) {
                    match--
                }
            }
            l++
        }
        r++
    }
    return ans
}
    /**
     * 解法二：数组+滑动窗口
     * 使用数组替代哈希表以提升效率
     */
    /*    public List<Integer> findAnagrams2(String s, String p) {
        char[] arrS = s.toCharArray();
        char[] arrP = p.toCharArray();
        // 接收最后返回的结果
        List<Integer> ans = new ArrayList<>();
        // 定义一个 needs 数组来看 arrP 中包含元素的个数
        int[] needs = new int[26];
        // 定义一个 window 数组来看滑动窗口中是否有 arrP 中的元素，并记录出现的个数
        int[] window = new int[26];
        // 先将 arrP 中的元素保存到 needs 数组中
        for (int i = 0; i < arrP.length; i++) {
            needs[arrP[i] - 'a'] += 1;
        }
        // 定义滑动窗口的两端
        int left = 0;
        int right = 0;
        // 右窗口开始不断向右移动
        while (right < arrS.length) {
            int curR = arrS[right] - 'a';
            right++;
            // 将右窗口当前访问到的元素 curR 个数加 1
            window[curR] += 1;
            // 当 window 数组中 curR 比 needs 数组中对应元素的个数要多的时候就该移动左窗口指针
            while (window[curR] > needs[curR]) {
                int curL = arrS[left] - 'a';
                left++;
                // 将左窗口当前访问到的元素 curL 个数减 1
                window[curL] -= 1;
            }
            // 这里将所有符合要求的左窗口索引放入到了接收结果的 List 中
            if (right - left == arrP.length) {
                ans.add(left);
            }
        }
        return ans;
    }*/
    fun findAnagrams3(s: String, p: String): List<Int> {
        val needs = IntArray(26)
        val window = IntArray(26)
        val ans: MutableList<Int> = ArrayList()
        for (element in p) {
            needs[element - 'a']++
        }
        var l = 0
        var r = 0
        while (r < s.length) {
            val curR = s[r] - 'a' //这里使用curR记录当前右边的索引比较好，因为下面判断窗口当前右边界元素要用到r
            window[curR]++
            r++
            while (window[curR] > needs[curR]) {
                window[s[l] - 'a']--
                l++
            }
            if (r - l == p.length) {
                ans.add(l)
            }
        }
        return ans
    }