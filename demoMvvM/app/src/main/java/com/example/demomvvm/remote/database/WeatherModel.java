package com.example.demomvvm.remote.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "weather_table")
public class WeatherModel {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "thudo")
    public String name;

    @NonNull
    @ColumnInfo(name = "nhietdo")
    public double temp;

    @NonNull
    @ColumnInfo(name = "apsuat")
    public int pressure;

    @NonNull
    @ColumnInfo(name = "doam")
    public int humidity;

    @NonNull
    @ColumnInfo(name = "may")
    public int cloud;

    @NonNull
    @ColumnInfo(name = "tocdogio")
    public double winsp;

    @NonNull
    @ColumnInfo(name = "gocgio")
    public int windr;

    public WeatherModel(@NonNull String name, double temp, int pressure, int humidity, int cloud, double winsp, int windr) {
        this.name = name;
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
        this.cloud = cloud;
        this.winsp = winsp;
        this.windr = windr;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getCloud() {
        return cloud;
    }

    public void setCloud(int cloud) {
        this.cloud = cloud;
    }

    public double getWinsp() {
        return winsp;
    }

    public void setWinsp(double winsp) {
        this.winsp = winsp;
    }

    public int getWindr() {
        return windr;
    }

    public void setWindr(int windr) {
        this.windr = windr;
    }
}
