package com.example.timelineapp.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class StorageItinerary(
    val departureId: Int,
    val destinationId: Int,
    val distance: Int,
    val flightId: Int,
    val hotelId: Int,
    val carRentId: Int,
    @PrimaryKey val id: Int? = null
)

