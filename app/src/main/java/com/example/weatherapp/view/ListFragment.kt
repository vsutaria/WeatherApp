package com.example.weatherapp.view
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.weatherapp.R

import com.example.weatherapp.databinding.FragmentListBinding
import com.example.weatherapp.model.WeatherForcast

import com.example.weatherapp.viewModel.ViewModel


class ListFragment : Fragment() {


    private val sharedViewModel: ViewModel by activityViewModels()
    private val args: ListFragmentArgs by navArgs()


    private lateinit var binding: FragmentListBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        sharedViewModel.getWeatherByCity(args.cityName)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_list,container,false)
        binding.setLifecycleOwner (this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.weatherRv.layoutManager =LinearLayoutManager(this.context,LinearLayoutManager.VERTICAL,false)

        sharedViewModel._weatherApiResponse.observe(viewLifecycleOwner, Observer {


            it?.let {
               binding.weatherRv.adapter= WeatherRecyclerViewAdapter(it.list,::setOnclickListener)
                //val navController = view?.findNavController()
                //navController?.graph?.label = it.city.name as CharSequence
            }
        })

    }
    private fun setOnclickListener(clickedOn:WeatherForcast,navController: NavController){
        val action = ListFragmentDirections.actionListFragmentToDetailFragment(weatherForcastArgs = clickedOn)
        navController.navigate(action)


    }



}