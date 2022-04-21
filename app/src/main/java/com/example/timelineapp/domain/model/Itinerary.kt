package com.example.timelineapp.domain.model

data class Itinerary(
    val id: Int,
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
    val carRentPhone: String
)
