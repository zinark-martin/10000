package Coroutines

import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.*

fun test1() {
    //如果很多协程都是顶级, 想要取消就需要挨个Job.cancel()
    var topCoroutine = GlobalScope.launch{

    }
    topCoroutine.cancel()
    //所有调用stScope创建的协程都可以通过job来取消
    val job = Job()
    val ctScope = CoroutineScope(job)
    ctScope.launch {  }
    job.cancel()
    //注意大小写
    suspend  fun cts() = coroutineScope {

    }
    job.cancel()
}