package com.kotlin
/*Created on 12.17*/
const val aBoolean: Boolean = true
const val anotherBoolean: Boolean = false
const val a:Int = Int.MAX_VALUE

class girl(var 性格:String, var 声音:String, var 长相:String){//直接放到构造参数中
    init {
        println("new了一个对象,性格:$性格 声音$声音 长相$长相")//一创建对象就会执行的东西
    }
}
class woman(character: String,voice: String,appearance: String):human(character,voice,appearance)

open class human (var character:String, var voice:String, var appearance:String){
    init {
        println("new了一个${this.javaClass.simpleName},性格:$character 声音$voice 长相$appearance")
    }
}

fun main() {
    val 我喜欢的女孩:girl = girl("温柔勇敢","动听","动人")//相当于new对象
    val 他喜欢的女孩:woman = woman("ok","ok","ok")
    println(他喜欢的女孩 is human)
}