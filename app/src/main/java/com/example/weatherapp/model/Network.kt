package com.example.weatherapp.model

import com.example.weatherapp.BuildConfig
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface Network {


    @GET("data/2.5/forecast")
    suspend fun getWeatherByCity(
        @Query("q") cityInput: String,
        @Query("appid") appid: String = BuildConfig.APP_ID
        ): Response<WeatherApiResponse>

    //@GET("data/2.5/forecast")
    //suspend fun getWeatherDetail()

    companion object {
        fun initRetrofit(): Network{
            return Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Network::class.java)

        }




    }
}