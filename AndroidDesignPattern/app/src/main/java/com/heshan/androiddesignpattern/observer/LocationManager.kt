package com.heshan.androiddesignpattern.observer

class LocationManager {

    private val subscribers: MutableList<Subscriber> = mutableListOf()
    private  var location: Double = 0.0

    var currentLocation: Double
        get() {
            return location
        } set(value) {
        location = value
    }

    fun attachSubscribers(subscriber: Subscriber) {
        subscribers.add(subscriber)
    }

    fun notifyThemAll() {
        subscribers.forEach {
            it.updateLocation(location)
        }
    }

}