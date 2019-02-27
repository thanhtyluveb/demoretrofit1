package com.example.demomvvm.remote.retrofit;

public class ApiUtils {

    public static final String BASE_URL = "https://samples.openweathermap.org/data/2.5/";
    public static SOService getSOService() {
        return RetrofitClient.getClient(BASE_URL).create(SOService.class);
    }
}