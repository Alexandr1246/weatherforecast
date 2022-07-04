package com.example.weatherforecast

data class dayItem(
    val city: String,
    val date: String,
    val condition: String,
    val imageURL: String,
    val currentTemp: String,
    val maxTemp: String,
    val minTemp: String,
    val hours: String
)
