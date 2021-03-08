package com.example.weatherapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WeatherForcast (
    val main: MainWeather,
    val weather: List<WeatherIcon>
    ): Parcelable
