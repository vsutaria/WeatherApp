package com.example.weatherapp.view

import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.databinding.FragmentCardBinding

import com.example.weatherapp.model.WeatherForcast

class WeatherViewHolder(val binding: FragmentCardBinding): RecyclerView.ViewHolder(binding.root){

    fun onBind(
        weather: WeatherForcast,
        onclickLister: (clickedOn: WeatherForcast, navController: NavController) -> Unit
    ){
        binding.root.setOnClickListener{
            onclickLister(weather,binding.root.findNavController())
        }
        binding.tvTemp.text= weather.main.temp.toString()
        binding.tvWeatherItem.text= weather.weather[0].main
    }

}
