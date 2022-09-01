package com.heshan.androiddesignpattern

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.google.android.material.snackbar.Snackbar
import com.heshan.androiddesignpattern.databinding.ActivityMainBinding
import com.heshan.androiddesignpattern.observer.LocationManager
import com.heshan.androiddesignpattern.observer.Subscriber
import kotlin.concurrent.fixedRateTimer

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onResume() {
        super.onResume()

        var locationManager = LocationManager()
        locationManager.attachSubscribers(supportFragmentManager.findFragmentById(R.id.min) as Subscriber)
        locationManager.attachSubscribers(supportFragmentManager.findFragmentById(R.id.mod) as Subscriber)
        locationManager.attachSubscribers(supportFragmentManager.findFragmentById(R.id.detail) as Subscriber)

        fixedRateTimer("timer",false,1000,5000){
            this@MainActivity.runOnUiThread {
                locationManager.currentLocation = this.scheduledExecutionTime().toDouble()
                locationManager.notifyThemAll()
            }
        }

    }
}