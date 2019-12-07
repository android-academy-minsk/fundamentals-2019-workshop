package com.androidacademy.workshop

import android.location.Location
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment(), MenuItem.OnMenuItemClickListener {
    private var locationManager: LocationManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        locationManager = LocationManager(requireContext()) { location ->
            print(location)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.menu_next, menu)
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)

        val menuItem = menu.findItem(R.id.menuNext)
        menuItem?.setOnMenuItemClickListener(this)
    }

    override fun onMenuItemClick(menuItem: MenuItem): Boolean {
        return when (menuItem.itemId) {
            R.id.menuNext -> {
                fragmentManager
                    ?.beginTransaction()
                    ?.replace(R.id.flContainer, MoviesFragment())
                    ?.addToBackStack(null)
                    ?.commit()

                return true
            }
            else -> false
        }
    }


    override fun onStart() {
        super.onStart()

        locationManager?.start()
    }

    override fun onStop() {
        super.onStop()

        locationManager?.stop()
    }

    private fun print(location: Location) {
        val longitude = "Longitude: ${location.longitude}"
        val latitude = "Latitide:  ${location.latitude}"
        tvCoordinates.text = "$longitude\n$latitude"
    }

}