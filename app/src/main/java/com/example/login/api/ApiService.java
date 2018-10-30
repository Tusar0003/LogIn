package com.example.login.api;

import com.example.login.model.GetResponse;
import com.example.login.model.LogInResponse;
import com.example.login.model.User;

import org.json.JSONObject;
import org.json.JSONStringer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    @GET("insert.php")
    Call<String> logIn(@Query("user_name") String userName, @Query("password") String password);

    @GET("get.php")
    Call<List<GetResponse>> getUser(@Query("id") String id);
}
