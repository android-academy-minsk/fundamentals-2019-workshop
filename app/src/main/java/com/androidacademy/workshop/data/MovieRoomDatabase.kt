package com.androidacademy.workshop.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class MovieRoomDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao?

    companion object {
        const val MOVIE_TABLE = "movies_table"

        @Volatile
        private var INSTANCE: MovieRoomDatabase? = null

        fun getDatabase(context: Context): MovieRoomDatabase? {
            if (INSTANCE == null) {
                synchronized(MovieRoomDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder<MovieRoomDatabase>(
                            context.applicationContext,
                            MovieRoomDatabase::class.java, MOVIE_TABLE
                        ).createFromAsset("movie_table.db")
                            .build()
                    }
                }
            }
            return INSTANCE
        }


    }


}