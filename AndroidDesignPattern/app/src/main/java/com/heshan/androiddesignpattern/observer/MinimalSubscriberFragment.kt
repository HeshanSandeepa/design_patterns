package com.heshan.androiddesignpattern.observer

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.heshan.androiddesignpattern.databinding.FragmentMinBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MinimalSubscriberFragment : Subscriber() {

    private lateinit var binding: FragmentMinBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMinBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun updateLocation(currentLocation: Double) {
        binding.textview.text   = "This is Min Imaplementation:  $currentLocation"
    }
}