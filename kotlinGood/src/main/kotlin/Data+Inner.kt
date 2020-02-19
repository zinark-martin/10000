
data class Man(var name:String, var age:Int, val plus:Int)

class Outer {
    var theInt = 100
    class StaticInner {
        fun innerFunction(int:Int) {
            //不使用关键字的内部类默认静态 不可以访问外部属性
            //所以也没有this@Outer标签使用
        }
    }
    inner class Inner {
        private var theInt = 6
        fun change(int:Int): Unit {
            //直接写是内部的那个, 加上标签是外部的那个
            theInt = int
            this@Outer.theInt = int
        }
    }
}

fun main(args: Array<String>) {
    //非静态和默认静态的内部类的调用
    val inner:Outer.Inner = Outer().Inner()//先实例化外部类对象(匿名)
    val staticInner = Outer.StaticInner()//不用实例化外部类, 只需引用

    val man = Man("the bitch", 20,1)
    //dataClass 输出自带toString方法
    println(man)
    for ((index,value) in args.withIndex()) {
        println(index);println("value is $value")
    }
}