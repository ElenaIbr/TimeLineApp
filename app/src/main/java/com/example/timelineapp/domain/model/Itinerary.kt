package com.example.timelineapp.domain.model

import com.example.timelineapp.data.database.model.StorageItinerary

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

fun Itinerary.convertToStorageItinerary(): StorageItinerary {
    return StorageItinerary(
        id = this.id,
        departureId = this.departureId,
        destinationId = this.destinationId,
        distance = this.distance,
        flightTitle = this.flightTitle,
        flightNumber = this.flightNumber,
        flightDate = this.flightDate,
        hotelTitle = this.hotelTitle,
        hotelCity = this.hotelCity,
        hotelAddress = this.hotelAddress,
        hotelImage = this.hotelImage,
        hotelPhone = this.hotelPhone,
        carRentTitle = this.carRentTitle,
        carRentCity = this.carRentCity,
        carRentAddress = this.carRentAddress,
        carRentImage = this.carRentImage,
        carRentPhone = this.carRentPhone
    )
}