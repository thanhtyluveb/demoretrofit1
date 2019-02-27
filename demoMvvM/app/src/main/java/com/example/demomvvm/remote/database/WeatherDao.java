package com.example.demomvvm.remote.database;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface WeatherDao {
    @Insert
    void insert(WeatherModel weatherModel);
    @Query("DELETE FROM weather_table")
    void deleteAll();
    @Query("SELECT * from weather_table")
    LiveData<WeatherModel> getdata();
}
