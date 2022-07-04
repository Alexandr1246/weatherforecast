package com.example.weatherforecast

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val livedataCurrent = MutableLiveData<String>()
    val livedataList = MutableLiveData<List<String>>()
}