package com.androidacademy.workshop

import android.content.Context
import android.location.Location
import androidx.core.content.getSystemService
import androidx.lifecycle.LiveData
import android.location.LocationManager as AndroidLocationManager

class LocationManager(context: Context) : LiveData<Location>() {

    private var locationManager: AndroidLocationManager? = null

    private val locationListener = object : SimpleLocationListener() {
        override fun onLocationChanged(location: Location?) {
            location?.let { nonNullLocation ->
                value = nonNullLocation
            }
        }
    }

    init {
        locationManager = context.getSystemService()
    }

    override fun onActive() {
        super.onActive()
        start()
    }

    override fun onInactive() {
        super.onInactive()
        stop()
    }

    fun start() {
        locationManager?.requestLocationUpdates(
            AndroidLocationManager.GPS_PROVIDER, 5000L, 10f,
            locationListener
        )
    }

    fun stop() {
        locationManager?.removeUpdates(locationListener)
    }
}