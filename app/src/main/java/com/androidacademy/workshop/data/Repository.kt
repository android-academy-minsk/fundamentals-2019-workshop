package com.androidacademy.workshop.data


class Repository(private val movieDatabase: MovieRoomDatabase) {

    suspend fun getMovieFromDb(): List<Movie> {
        return movieDatabase.movieDao()
            .getMovies()
    }
}