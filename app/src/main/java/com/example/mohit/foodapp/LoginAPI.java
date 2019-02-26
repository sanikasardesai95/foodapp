package com.example.mohit.foodapp;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface LoginAPI {
    @FormUrlEncoded
    @GET("/api/login")

    public Call<String> loginUser(@Field("username") String username,@Field("password") String password);


}
