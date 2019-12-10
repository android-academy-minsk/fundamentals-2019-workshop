package com.androidacademy.workshop

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androidacademy.workshop.data.Movie
import com.androidacademy.workshop.data.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MoviesViewModel(private val repository: Repository) : ViewModel() {

    private val movies = MutableLiveData<List<Movie>>()

    init {
        loadMovies()
    }

    fun observeMovies(): LiveData<List<Movie>> {
        return movies
    }

    fun sortByName() {
        movies.value = movies.value?.sortedBy { it.title }
    }

    fun sortByOverview() {
        movies.value = movies.value?.sortedBy { it.overview }
    }

    fun sortByReleaseDate() {
        movies.value = movies.value?.sortedBy { it.releaseDate }
    }

    fun loadMovies() {
        viewModelScope.launch {
            movies.value = withContext(Dispatchers.IO) {
                repository.getMovieFromDb()
            }
        }
    }
}