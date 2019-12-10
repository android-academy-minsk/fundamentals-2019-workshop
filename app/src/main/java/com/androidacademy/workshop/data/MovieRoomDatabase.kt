package com.androidacademy.workshop.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

private const val DB_FILE_NAME = "movies.db"

@Database(entities = [Movie::class], version = 2)
abstract class MovieRoomDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: MovieRoomDatabase? = null

        fun getDatabase(context: Context): MovieRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room
                    .databaseBuilder(
                        context.applicationContext,
                        MovieRoomDatabase::class.java,
                        DB_FILE_NAME
                    )
                    .createFromAsset(DB_FILE_NAME)
                    .build()

                INSTANCE = instance

                return instance
            }
        }
    }
}