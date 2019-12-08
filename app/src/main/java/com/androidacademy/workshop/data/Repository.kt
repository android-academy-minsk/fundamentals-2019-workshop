package com.androidacademy.workshop.data


class Repository(private val movieDatabase: MovieRoomDatabase? = null) {

    fun getMovieFromDb(): List<Movie> {
        return movieDatabase?.movieDao()?.getMovies() ?: emptyList()
    }

    fun loadMovies(): List<Movie> {
        return DataStorage.getMoviesList()
    }
}