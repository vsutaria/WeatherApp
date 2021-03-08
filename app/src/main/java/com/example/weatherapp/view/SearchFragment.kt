package com.example.weatherapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController


import com.example.weatherapp.R

import com.example.weatherapp.databinding.FragmentSearchBinding
import com.example.weatherapp.viewModel.ViewModel


class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding

    private val sharedViewModel: ViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_search,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLookup.setOnClickListener {
            if (binding.etInputCityName.text.toString() !=""){
                val action= SearchFragmentDirections.actionSearchFragmentToListFragment(cityName = binding.etInputCityName.text.toString())
                view.findNavController().navigate(action)
            }
        }




    }


}