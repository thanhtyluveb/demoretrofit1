package com.example.demomvvm.remote.retrofit;
import com.example.demomvvm.model.WeatherModel.WeatherDigital;

import retrofit2.Call;
import retrofit2.http.GET;

//quan ly viec truy xuat voi server
public interface SOService {
 
   @GET("weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22")
   Call<WeatherDigital> EXAMPLE_CALL();
}