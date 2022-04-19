package com.example.timelineapp.data.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class StorageFlight(
    val date: String,
    val departureId: Int,
    val destinationId: Int,
    val flightNumber: String,
    val gate: String,
    @PrimaryKey val id: Int? = null
)