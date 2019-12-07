package com.androidacademy.workshop

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androidacademy.workshop.data.DataStorage
import com.androidacademy.workshop.data.Movie
import com.androidacademy.workshop.data.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MoviesViewModel : ViewModel() {

    private val liveData: MutableLiveData<List<Movie>> = MutableLiveData()

    init {
        val moviesList = DataStorage.getMoviesList()
        liveData.value = moviesList
    }

    fun observeMovies(): LiveData<List<Movie>> {
        return liveData
    }

    fun sortByName() {
        liveData.value = liveData.value?.sortedBy { it.title }
    }

    fun sortByOverview() {
        liveData.value = liveData.value?.sortedBy { it.overview }
    }

    fun sortByReleaseDate() {
        liveData.value = liveData.value?.sortedBy { it.releaseDate }
    }

    fun loadMovies() {
        viewModelScope.launch(context = Dispatchers.IO) {
            Repository.movieDatabase?.movieDao()?.getMovies()?.forEach {
                Log.d("TAG", "Title ${it.title}")
            }
        }
    }


}