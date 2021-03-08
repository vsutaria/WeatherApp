package com.example.weatherapp.view

import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentCardBinding
import com.example.weatherapp.model.WeatherForcast

class WeatherRecyclerViewAdapter(val weather: List<WeatherForcast>,
                                 val onclickLister:(clickedOn:WeatherForcast,navController: NavController) ->Unit)
    : RecyclerView.Adapter<WeatherViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        val binding :FragmentCardBinding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_card,parent,false)
        return WeatherViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return weather.size
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.onBind(weather[position],onclickLister)
    }


}
