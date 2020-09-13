package Squareup

import okhttp3.Call
import okhttp3.ResponseBody
import retrofit2.http.*

interface Api {
    @GET("article/list/{page}/json")
    suspend fun get(@Path("page") page: Int): List<model>

    @GET("get_data.json")
    suspend fun getData(@Query("u") user: String): List<model>

    @DELETE("data/{id}")
    suspend fun delete(@Path("id") id: String): List<model>

    @POST("data/create")
    suspend fun post(@Body data: model)
}