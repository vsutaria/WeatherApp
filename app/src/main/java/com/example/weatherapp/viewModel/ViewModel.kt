package com.example.weatherapp.viewModel

import androidx.core.widget.ListViewAutoScrollHelper
import androidx.lifecycle.*
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.NavHostFragment
import com.example.weatherapp.R
import com.example.weatherapp.WeatherApp
import com.example.weatherapp.model.Repository
import com.example.weatherapp.model.WeatherApiResponse
import kotlinx.coroutines.launch

class ViewModel: ViewModel() {



    private val repository: Repository by lazy {
        Repository.getInstance(WeatherApp.weatherContext)
    }


    //private lateinit var  weatherApiResponse: MutableLiveData<WeatherApiResponse>
    val _weatherApiResponse= MutableLiveData<WeatherApiResponse>()

    fun getWeatherByCity(city:String){

        viewModelScope.launch {

            _weatherApiResponse.value= repository.getWeatherByCity(city)
        }

    }
    // viewModelScope.lauch{}



}
