package com.androidacademy.workshop.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "Movie")
data class Movie(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    val title: String,
    val posterUrl: String,
    val backdropUrl: String,
    val overview: String,
    val releaseDate: String,
    val popularity: Int
) : Parcelable