package com.example.weatherapp

import android.app.Application
import android.content.Context

class WeatherApp : Application(){
    override fun onCreate() {
        super.onCreate()
        weatherContext = applicationContext
    }
    companion object{
        lateinit var weatherContext: Context
    }
}