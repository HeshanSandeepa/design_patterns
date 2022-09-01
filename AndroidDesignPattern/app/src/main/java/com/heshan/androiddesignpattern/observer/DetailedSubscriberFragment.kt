package com.heshan.androiddesignpattern.observer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.heshan.androiddesignpattern.databinding.FragmentDetailedBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class DetailedSubscriberFragment : Subscriber() {

    private lateinit var _binding: FragmentDetailedBinding

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentDetailedBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun updateLocation(currentLocation: Double) {
        _binding.textview.text   = "This is Detailed Imaplementation:  $currentLocation"
    }
}