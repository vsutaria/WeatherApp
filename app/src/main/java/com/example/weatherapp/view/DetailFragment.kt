package com.example.weatherapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentDetailBinding
import com.example.weatherapp.model.WeatherForcast


class DetailFragment : Fragment() {


    private lateinit var binding: FragmentDetailBinding
    private lateinit var clickedWeather: WeatherForcast
    private val args: DetailFragmentArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        clickedWeather= args.weatherForcastArgs

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_detail,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvWeatherName.text= clickedWeather.weather[0].main
        binding.tvDescription.text= clickedWeather.weather[0].description
        binding.tvFeelsLike.text = "Feels Like: ${clickedWeather.main.feels_like.toString()}"
        binding.tvTempHuge.text= clickedWeather.main.temp.toString()

    }


}