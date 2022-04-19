package com.example.timelineapp.domain.model

data class Itinerary(
    val id: Int,
    val departureId: Int,
    val destinationId: Int,
    val date: Long,
    val distance: Int,
    val flightId: Int,
    val hotelId: Int,
    val carRentId: Int
)
