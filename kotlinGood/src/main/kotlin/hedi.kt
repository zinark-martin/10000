/*Created on 12.17*/
const val aBoolean: Boolean = true
const val anotherBoolean: Boolean = false
const val a:Int = Int.MAX_VALUE
//val是只读变量
class Example constructor(private var text: String)//construct可以省略
class Girl(private var characteristic: String, private var voice: String, private var looks: String){//直接放到构造参数中
    init {
        println("new了一个对象,性格:$characteristic 声音$voice 长相$looks")//一创建对象就会执行的东西
    }
}

open class Kick (string: String, char: String) {
    init {
        println("dsf")
    }
}

class Kick2(string:String) : Kick(string,"abc")
{
    //给委托的住构造参数使用了自己的一个参数, 相当于调用次构造参数的同时把这个值也赋值给主构造参数并调用
    constructor(int: Int,character: String,string: String) :this (string)
    init {
        println("")
    }
}
open class Person(internal var name:String)

class Worker{
    constructor(name:String)
    constructor(str2:String, char2:String, int: Int):this (name = "必须赋值")
}

class Woman(character: String, voice: String, appearance: String): Human(character,voice,appearance)

open class Human (private var character:String, voice:String, private var appearance:String){
    fun test1 (string:String): Unit {
        this.character = string //只有var修饰的参数可以使用
    }
    private var voice:String
    init {
        println("new了一个${this.javaClass.simpleName},性格$character 声音$voice 长相$appearance")
        var k:String = this.appearance
        this.voice = voice
    }
}

fun main() {
    val girl = Girl("沙雕","putz","动人")
    val mine: Girl = Girl("温柔勇敢", "动听", "动人")//相当于new对象
    val his: Woman = Woman("ok", "ok", "ok")
    val human:Human = Human("1","2","3")
    val kick2 = Kick2("测试继承")
    println(human.javaClass.simpleName + "human &{human == human}")
    println(his is Human)
}
