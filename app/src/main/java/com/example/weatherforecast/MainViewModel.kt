package com.example.weatherforecast

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherforecast.adapters.WeatherModel

class MainViewModel : ViewModel() {
    val livedataCurrent = MutableLiveData<WeatherModel>()
    val livedataList = MutableLiveData<List<WeatherModel>>()
}