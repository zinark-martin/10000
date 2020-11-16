package leetcode.字节跳动题库
import java.util.*
import kotlin.collections.HashMap
//https://leetcode-cn.com/problems/lru-cache/
/*为了保证每一个操作都是O(1)级别的时间复杂度
* 1.首先从查找开始:数组支持随机访问,符合时间复杂度要求,HashMap的键就是保存在数组中的
* 2.其次开始put和前置和删除数据节点:删除末尾,添加,前置,这些操作最适合使用队列来操作
*   为了使这些对于节点的操作符合时间复杂度要求,就用上了链表,于是我们把实现了双向队列的
*   LinkedList作为保存数据的缓存
* */
class Node(var key: Int, var data: Int)
//删除结点一定要删除 map 中的 key,否则存在引用的对象不会被GC回收相当于这个机制没用
//为了寻找这个key,我们将它写在node中
class LRUCache(private val capacity: Int) {
    //HashMap + LinkedList
    private val map: HashMap<Int, Node> = HashMap()
    private val cache: LinkedList<Node> = LinkedList<Node>()
    // 如果使用ArrayDeque来作为双向队列,因为是数组,所以操作就不是O(1)而是O(n)
    fun get(key: Int): Int {
        return if (!map.containsKey(key)) -1
        else {
            val value = map.getOrDefault(key, Node(key, -1)).data
            // 更新数据到最前端位置 因为put旧结点的原理是将旧结点删了,新创建一样的结点插到最前面
            // 所以我们使用put来前置数据
            put(key, value)
            value
        }
    }
    fun put(key: Int, value: Int) {
        val newNode = Node(key, value)
        // 不管之前有无这个节点 都需要构建它
        when {
            map.containsKey(key) -> {
                // 如果有这个结点 直接删了旧结点然后把新的插到头部
                cache.remove(map.getOrDefault(key, Node(key, -1)))
                cache.addFirst(newNode)
                // 最后将key重指向
                map[key] = newNode
            }
            cache.size >= capacity -> {
                // 如果已经饱和, 先删除最后一个结点 并取删除在map中对应的key, 取消引用
                cache.removeLast().apply {
                    map.remove(this.key)
                }
                cache.addFirst(newNode)
                map[key] = newNode
            }
            else -> {
                // 直接添加到头部并增加引用
                cache.addFirst(newNode)
                map[key] = newNode
            }
        }
    }
}
//
////直接使用封装好的数据结构 LinkedHashMap 面试不可以
//class LRUCache2(private val capacity: Int): LinkedHashMap<Int?, Int?>(capacity, 0.75f, true) {
//    fun get(key: Int): Int? {
//        return super.getOrDefault(key, -1)
//    }
//
//    fun put(key: Int, value: Int) {
//        super.put(key, value)
//    }
//
//    override fun removeEldestEntry(eldest: Map.Entry<Int?, Int?>?): Boolean {
//        return size > capacity
//    }
//}
