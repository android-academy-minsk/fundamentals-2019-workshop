package com.androidacademy.workshop.data

import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.androidacademy.workshop.data.MovieRoomDatabase.Companion.MOVIE_TABLE
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity(tableName = MOVIE_TABLE)
data class Movie(
    val title: String,
    @DrawableRes val posterRes: Int,
    @DrawableRes val backdropRes: Int,
    val overview: String,
    val releaseDate: String,
    val trailerUrl: String,
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "movie_id")
    val id: Int = 0
) : Parcelable