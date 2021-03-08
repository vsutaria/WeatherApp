package com.example.weatherapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MainWeather (
    val temp: Double,
    val feels_like: Double

    ): Parcelable
