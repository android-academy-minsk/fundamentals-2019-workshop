package com.androidacademy.workshop

import android.content.Context
import android.content.Context.LOCATION_SERVICE
import android.location.Location
import android.location.LocationManager


class LocationManager(context: Context?, val callBack: (Location) -> Unit) {

    private var locationManager: LocationManager? = null

    private val locationListener = object : SimpleLocationListener() {
        override fun onLocationChanged(location: Location?) {
            location?.let { nonNullLocation -> callBack(nonNullLocation) }
        }
    }

    init {
        locationManager = context?.getSystemService(LOCATION_SERVICE) as LocationManager
    }

    fun start() {
        locationManager?.requestLocationUpdates(
            LocationManager.GPS_PROVIDER, 5000L, 10f,
            locationListener
        )
    }

    fun stop() {
        locationManager?.removeUpdates(locationListener)
    }
}