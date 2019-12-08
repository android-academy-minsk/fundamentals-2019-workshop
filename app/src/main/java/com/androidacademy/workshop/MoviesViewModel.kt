package com.androidacademy.workshop

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.androidacademy.workshop.data.Movie
import com.androidacademy.workshop.data.Repository
import kotlinx.coroutines.Dispatchers


class MoviesViewModel(private val repository: Repository) {

    private val movies = MutableLiveData<List<Movie>>()

    init {
        movies.value = repository.loadMovies()
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

//    fun loadMovies() {
//        viewModelScope.launch(context = Dispatchers.IO) {
//            movies.postValue(repository.getMovieFromDb())
//        }
//    }
}