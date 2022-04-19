package com.example.timelineapp.data.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class StorageHotel(
    val title: String,
    val city: String,
    val address: String,
    val image: String,
    val phone: String,
    val rooms: List<String>,
    @PrimaryKey val id: Int? = null
)
