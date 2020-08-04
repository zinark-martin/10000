import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import kotlin.reflect.KProperty

class myContainer(val helper: Set<Int>) : Set<Int> {
    override val size: Int
        get() = helper.size

    override fun contains(element: Int) = helper.contains(element)

    //同上, 重写的方法实现是靠
    override fun containsAll(elements: Collection<Int>): Boolean {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    override fun iterator(): Iterator<Int> {
        TODO("Not yet implemented")
    }

}
class myContainter2(private val helper2: HashSet<Int>) : Set<Int> by helper2 {
    override val size: Int
        get() = 22
    suspend fun xiecheng (Block:() -> Unit) {
        withContext(Dispatchers.IO){
            Block
        }
        coroutineScope {
            Block
        }
    }
}
class test : HashSet<Int>() {
    override fun remove(element: Int): Boolean {
        return super.remove(element)
    }
    fun k(): Int {
        return super.size
    }
}
//属性委托 会自动调用被委托的类的两个方法
class 属性委托 {
    var 被委托属性 = Delegation()
}
class Delegation {
    var tar: Any? = null
    operator fun getValue(w:属性委托, c:KProperty<*>)  = tar
    operator fun setValue(w:属性委托, c:KProperty<*>, value:Any?) {
        tar = value
    }

}

fun main() {
    println("???")
    println("abc" * 3)
}

