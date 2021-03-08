package com.example.weatherapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WeatherApiResponse(
    val list: List<WeatherForcast>,
    val city: CityInfo
): Parcelable