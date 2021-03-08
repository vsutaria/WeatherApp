package com.example.weatherapp.model

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.weatherapp.WeatherApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import retrofit2.Call
import retrofit2.HttpException
import kotlin.coroutines.CoroutineContext

private const val TAG = "Repository"
class Repository : CoroutineScope {
    private val networkApi: Network= Network.initRetrofit()
    private val currentJob:Job= Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + currentJob

    suspend fun getWeatherByCity(city: String): WeatherApiResponse? {

        val result= networkApi.getWeatherByCity(city)

        try {
            if (result.isSuccessful){
                Log.d(TAG, "getForecast:onResponse: " +
                        "${result.body()}")
            }else{
                Log.d(TAG, "getMetaData:onFailure: ")

                return null
            }
            return result.body()
        } catch (e: HttpException) {
            return null
        } catch (e: Throwable) {
            Log.d(TAG, "getMetaData:onFailure: ")

            return null
        }

    }
    companion object{
        @Volatile
        private var INSTANCE: Repository? = null

        fun getInstance(context: Context): Repository{
            return  INSTANCE ?: synchronized(this){
                var instance = Repository()
                INSTANCE= instance
                instance
            }

        }
    }


}