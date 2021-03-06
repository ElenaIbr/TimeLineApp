package com.example.timelineapp.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.timelineapp.domain.model.Itinerary

@Entity
data class StorageItinerary(
    @PrimaryKey val id: Int? = null,
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
)

fun StorageItinerary.convertToItinerary(): Itinerary {
    return Itinerary(
        id = this.id ?: 1,
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