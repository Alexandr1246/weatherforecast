package com.example.weatherforecast.adapters

data class WeatherModel(
    val city: String,
    val time: String,
    val condition: String,
    val currentTemp: String,
    val maxTem: String,
    val minTemp: String,
    val imageUrl: String,
    val hours: String
    )
