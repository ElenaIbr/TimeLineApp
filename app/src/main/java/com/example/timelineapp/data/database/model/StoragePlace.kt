package com.example.timelineapp.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class StoragePlace(
    val placeId: String,
    val city: String,
    val address: String,
    @PrimaryKey val id: Int? = null
)
