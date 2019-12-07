package com.androidacademy.workshop.data


object Repository {

    var movieDatabase: MovieRoomDatabase? = null

    fun getMovieFromDb(): List<Movie> {
        return emptyList<Movie>()
    }

    fun listMovies(): List<Movie> {
        return DataStorage.getMoviesList()
    }


}