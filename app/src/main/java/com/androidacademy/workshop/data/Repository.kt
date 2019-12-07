package com.androidacademy.workshop.data


class Repository(private val movieDatabase: MovieRoomDatabase) {

    fun getMovieFromDb(): List<Movie> {
        return movieDatabase.movieDao()
            .getMovies()
    }

    fun loadMovies(): List<Movie> {
        return DataStorage.getMoviesList()
    }
}