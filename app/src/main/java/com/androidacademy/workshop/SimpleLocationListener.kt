package com.androidacademy.workshop

import android.location.Location
import android.location.LocationListener
import android.os.Bundle

abstract class SimpleLocationListener : LocationListener {

    override fun onLocationChanged(location: Location?) {
    }

    override fun onStatusChanged(p0: String?, p1: Int, p2: Bundle?) {
    }

    override fun onProviderEnabled(p0: String?) {
    }

    override fun onProviderDisabled(p0: String?) {
    }
}