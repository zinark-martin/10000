package Squareup

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Url
import java.net.URL

fun main() {
    val survice = Survice.createRetrofit(Api::class.java)

    suspend fun deleteUser(name: String) = withContext(Dispatchers.IO) {
        survice.delete(name)
    }

}

object Survice {
    private const val URL = ""
    private val retrofit = Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build()
    fun <T> createRetrofit(survice: Class<T>) : T = retrofit.create(survice)
}