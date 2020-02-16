
data class Man(var name:String, var age:Int, val plus:Int)

class Outer {
    var theInt = 100
    class StaticInner {
        fun innerFunction(int:Int) {
            //默认静态 不可以访问外部属性
            //所以也没有this@Outer标签使用
        }
    }
    inner class Inner {
        private var theInt = 6
        fun change(int:Int): Unit {
            theInt = int
            this@Outer.theInt = int
        }
    }
}

fun main(args: Array<String>) {
    //非静态和默认静态的内部类的调用
    val inner = Outer().Inner()
    val staticInner = Outer.StaticInner()

    val man = Man("the bitch", 20,1)
    //dataClass 输出自带toString方法
    println(man)
    for ((index,value) in args.withIndex()) {
        println(index);println("value is $value")
    }
}