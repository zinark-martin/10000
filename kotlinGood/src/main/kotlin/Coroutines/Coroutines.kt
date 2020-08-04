package Coroutines

import kotlinx.coroutines.*
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

fun main() {
    val ml = mutableListOf<String>()
    ml.clear()
    //val thread = mutableListOf<Thread>()
    var i = 0
   //挂起就是可以自动切回来的切线程
    val timeStart = System.currentTimeMillis()
    runBlocking {
        println("${System.currentTimeMillis() - timeStart}")

        val def1 = async {
            println("开始delay ${System.currentTimeMillis() - timeStart}")
            delay(1000)
            println(Thread.currentThread()).apply {
                println("结束delay ${System.currentTimeMillis() - timeStart}")
            }
            5 + 18
        }

        val def2 = async(Dispatchers.IO){
            println("开始delay2 ${System.currentTimeMillis() - timeStart}")
            delay(900)
            println(Thread.currentThread()).apply {
                println("结束delay2222 ${System.currentTimeMillis() - timeStart}")
            }
            5 + 8
        }
        println("输出前一刻的时间啊${  System.currentTimeMillis() - timeStart}")
        //println("${def2.await()} TIME: ${System.currentTimeMillis() - timeStart}\n")
        //println("${def1.await()} TIME: ${System.currentTimeMillis() - timeStart}\n")
        println("测试先后顺序开始")
        Thread.sleep(1000)
        println("测试先后顺序结束")
        println("测试先后顺序开始")
        Thread.sleep(100)
        println("测试先后顺序结束")
        println("测试先后顺序开始")
        Thread.sleep(100)
        println("测试先后顺序结束")
        //println("${Coroutines.d1(timeStart).await() + Coroutines.d2(timeStart).await()} ${System.currentTimeMillis() - timeStart}")
        //def1.await()
        //def2.await()

//                  repeat(100) {
//            launch {
//                println(message = "当前线程是: ${Thread.currentThread().name}")
//
//                ml.add(Thread.currentThread().toString())
//                delay(3000)
//                Thread.sleep(3000)
//                println("${i++} ${Thread.currentThread().name}")
//            }
//            println("啦啦啦啦啦")
//            //thread.add(Thread.currentThread())
//            if (ml.contains(Thread.currentThread().toString())) {
//                println("!!!!!!!!!!!!!!!!出现重复编号的线程${Thread.currentThread().name}")
//                exitProcess(6969696)
//            }
//            //println("launch结束后的线程数量: ${thread.size}")
//        }
//        //println("  %^&*  repeat结束后的线程数量: ${thread.size}")
//        println("${System.currentTimeMillis() - timeStart} 这句话是写在repeat之后的!${Thread.currentThread()}")
//        println("@#$%^&*(${System.currentTimeMillis() - timeStart} 这句话是写在repeat之后的! ${Thread.currentThread()}")
//        Thread.sleep(100)
//        println("${System.currentTimeMillis() - timeStart} 这句话是写在repeat之后的!${Thread.currentThread()}")
//        System.gc()
//        Thread.sleep(2000)
//        //println("结束后的线程数量: ${thread.size}")
//
//    }
    }
}
suspend fun d1(start: Long) = coroutineScope {
    async {
        delay(1000)
        println("${Thread.currentThread()}  ${System.currentTimeMillis() - start} 第一个协程")
        1 + 2
    }
}

suspend fun d2(start: Long) = coroutineScope {
    async {
        delay(1000)
        println("${Thread.currentThread()}  ${System.currentTimeMillis() - start} 第二个协程")
        2 + 2
    }
}


fun Repeat() = repeat(100_00) {
    Executors.newCachedThreadPool().execute {
        Thread.sleep(1000)
        println("点")
    }
}

fun Repeat2() = repeat(100_00) {
    Executors.newSingleThreadScheduledExecutor().schedule({
        println("点")
    }, 1, TimeUnit.SECONDS)
}


class PrintTest {
    @Synchronized
    fun print() {
        println("hello world")
    }

    @Synchronized
    fun print2() {
        println("hello world")
    }
}