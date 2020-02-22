package com.example.retrofitrxjavademo;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface UserMgrService {
    @GET("login")
    Call<UserInfoModel> login(@Query("username") String username, @Query("pwd") String pwd);
    //@PUT("")
}
