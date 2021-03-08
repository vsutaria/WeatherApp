package com.example.weatherapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WeatherIcon (

    val main: String,
    val description: String,
    val icon: String
) : Parcelable
