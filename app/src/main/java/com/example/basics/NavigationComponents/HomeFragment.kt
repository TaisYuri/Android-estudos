package com.example.basics.NavigationComponents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.basics.R
import com.example.basics.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        binding.buttonNav.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragment2ToNavGame()
            findNavController().navigate(action)
        }

        return binding.root
    }


}