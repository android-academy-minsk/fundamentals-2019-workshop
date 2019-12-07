package com.androidacademy.workshop

import android.location.Location
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment() {

    private var locationManager: LocationManager? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        locationManager = LocationManager(context!!) { location ->
            printLocation(location)
        }
    }

    override fun onResume() {
        super.onResume()
        locationManager?.start()
    }

    override fun onPause() {
        super.onPause()
        locationManager?.stop()
    }

    private fun printLocation(location: Location) {
        val longitude = "Longitude: ${location.longitude}"
        val latitude = "Latitide:  ${location.latitude}"
        tvCoordinates.text = "$longitude\n$latitude"
    }

}