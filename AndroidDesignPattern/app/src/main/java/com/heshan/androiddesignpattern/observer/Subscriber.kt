package com.heshan.androiddesignpattern.observer

import androidx.fragment.app.Fragment

abstract class Subscriber: Fragment() {
    protected lateinit var locationManager: LocationManager
    abstract fun updateLocation(currentLocation: Double)
}