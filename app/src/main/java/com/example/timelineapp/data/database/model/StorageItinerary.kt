package com.example.timelineapp.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class StorageItinerary(
    val departureId: Int,
    val destinationId: Int,
    val distance: Int,
    val flightTitle: String,
    val flightNumber: String,
    val flightDate: String,
    val hotelTitle: String,
    val hotelCity: String,
    val hotelAddress: String,
    val hotelImage: String,
    val hotelPhone: String,
    val carRentTitle: String,
    val carRentCity: String,
    val carRentAddress: String,
    val carRentImage: String,
    val carRentPhone: String,
    @PrimaryKey val id: Int? = null
)