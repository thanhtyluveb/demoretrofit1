package com.example.demomvvm.utility;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import com.example.demomvvm.remote.database.WeatherDao;
import com.example.demomvvm.remote.database.WeatherDatabase;
import com.example.demomvvm.remote.database.WeatherModel;
import com.example.demomvvm.remote.retrofit.ApiUtils;
import com.example.demomvvm.remote.retrofit.SOService;

import androidx.lifecycle.LiveData;

public class WeatherRepository {
    private WeatherDao weatherDao;
    public LiveData<WeatherModel> weatherModel;
    private SOService mService;


    public WeatherRepository(Application application) {
        WeatherDatabase db = WeatherDatabase.getDatabase(application);
        weatherDao = db.weatherDao();
        weatherModel = weatherDao.getdata();
        this.mService = ApiUtils.getSOService();
    }




    public void insert(WeatherModel weatherModel) {
        new insertAsyncTask(weatherDao).execute(weatherModel);
    }

    private static class insertAsyncTask extends AsyncTask<WeatherModel, Void, Void> {
        WeatherDao aSyncweatherDao;

        public insertAsyncTask(WeatherDao aSyncweatherDao) {
            this.aSyncweatherDao = aSyncweatherDao;
        }

        @Override
        protected Void doInBackground(WeatherModel... weatherModels) {
            aSyncweatherDao.deleteAll();
            aSyncweatherDao.insert(weatherModels[0]);
            return null;

        }
    }

    public LiveData<WeatherModel> getData() {
        new getdataAsynctask(weatherDao).execute();
        return weatherModel;
    }

    private static class getdataAsynctask extends AsyncTask<WeatherModel, Void, Void> {
        WeatherDao aSyncweatherDao;

        public getdataAsynctask(WeatherDao aSyncweatherDao) {
            this.aSyncweatherDao = aSyncweatherDao;
        }

        @Override
        protected Void doInBackground(WeatherModel... weatherModels) {
            aSyncweatherDao.getdata();
            return null;

        }
    }
}
