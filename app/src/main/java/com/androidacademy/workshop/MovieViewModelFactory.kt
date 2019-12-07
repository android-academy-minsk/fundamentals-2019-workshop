package com.androidacademy.workshop

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.androidacademy.workshop.data.Repository

class MovieViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MoviesViewModel::class.java)) {
            return MoviesViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}