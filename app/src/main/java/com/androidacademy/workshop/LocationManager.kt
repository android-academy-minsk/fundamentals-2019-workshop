package com.androidacademy.workshop

import android.content.Context
import android.content.Context.LOCATION_SERVICE
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle


class LocationManager(context: Context?, val callBack: (Location) -> Unit) {

    private var locationManager: LocationManager? = null

    private val locationListener = object : LocationListener {
        override fun onLocationChanged(p0: Location?) {
            p0?.let { callBack(it) }
        }

        override fun onStatusChanged(p0: String?, p1: Int, p2: Bundle?) {
        }

        override fun onProviderEnabled(p0: String?) {
        }

        override fun onProviderDisabled(p0: String?) {
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