package Coroutines

import okhttp3.*
import java.io.IOException

val client = OkHttpClient()
val request: Request = Request.Builder().url("").build()
fun main() {
    val call = client.newCall(request).enqueue(object : Callback{
        override fun onResponse(call: Call, response: Response) {
        }

        override fun onFailure(call: Call, e: IOException) {
        }
    })
}


