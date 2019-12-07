package com.androidacademy.workshop.data


object Repository {

    var movieDatabase: MovieRoomDatabase? = null

    fun getMovieFromDb(): List<Movie> {
        return movieDatabase?.movieDao()?.getMovies() ?: emptyList()
    }

    fun loadMovies(): List<Movie> {
        return DataStorage.getMoviesList()
    }


}