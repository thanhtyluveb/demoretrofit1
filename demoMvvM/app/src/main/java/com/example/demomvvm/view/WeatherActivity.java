package com.example.demomvvm.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.demomvvm.R;
import com.example.demomvvm.databinding.ActivityWeatherBinding;
import com.example.demomvvm.model.WeatherModel.WeatherDigital;
import com.example.demomvvm.remote.database.WeatherModel;
import com.example.demomvvm.remote.retrofit.ApiUtils;
import com.example.demomvvm.remote.retrofit.SOService;
import com.example.demomvvm.viewmodel.WeatherViewModel;

public class WeatherActivity extends AppCompatActivity {
    ActivityWeatherBinding binding;
    private SOService mService;
    private WeatherViewModel weatherViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        mService = ApiUtils.getSOService();
        weatherViewModel = ViewModelProviders.of(this).get(WeatherViewModel.class);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_weather);
        binding.setLifecycleOwner(this);
        binding.setViewmodel(weatherViewModel);
        if (isNetworkAvailable(this)){
            weatherViewModel.loadData();
            Toast.makeText(this, "network aviable", Toast.LENGTH_SHORT).show();

        }else {
            Toast.makeText(this, "network error", Toast.LENGTH_SHORT).show();

            weatherViewModel.getWeatherModelLiveData().observe(this, new Observer<WeatherModel>() {
                @Override
                public void onChanged(WeatherModel weatherModel) {
                    binding.name.setText(""+weatherModel.name);
                    binding.clouds.setText(""+weatherModel.cloud);
                    binding.humidity.setText(""+weatherModel.humidity);
                    binding.pressure.setText(""+weatherModel.pressure);
                    binding.temp.setText(""+weatherModel.temp);
                    binding.windr.setText(""+weatherModel.windr);
                    binding.winsp.setText(""+weatherModel.winsp);
                }
            });
        }



    }

    public static  boolean isNetworkAvailable(Context context) {
        if(context == null) { return false; }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        // if no network is available networkInfo will be null, otherwise check if we are connected
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

}
