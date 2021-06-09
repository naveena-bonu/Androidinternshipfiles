package com.example.coviddata;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MyInterface {
    @GET("dayone/country/{input}")//curly braces help us to get data from user
    Call<String> getValue(@Path("input")String i); //we can use query instead of path
    //i is country name the user gives.


}
