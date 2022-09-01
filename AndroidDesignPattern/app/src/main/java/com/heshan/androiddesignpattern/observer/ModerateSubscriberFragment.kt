package com.heshan.androiddesignpattern.observer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.heshan.androiddesignpattern.databinding.FragmentModerateBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ModerateSubscriberFragment : Subscriber() {

    private lateinit var _binding: FragmentModerateBinding

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentModerateBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun updateLocation(currentLocation: Double) {
        _binding.textview.text   = "This is Moderate Imaplementation:  $currentLocation"
    }
}