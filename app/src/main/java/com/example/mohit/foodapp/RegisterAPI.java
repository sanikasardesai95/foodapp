package com.example.mohit.foodapp;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RegisterAPI {
    @FormUrlEncoded
    @POST("/api/registeruser")
    Call<String > insertUser(@Field("username") String username,
                             @Field("email") String email,
                             @Field("mobile") String mobile,
                             @Field("password") String password);


}
