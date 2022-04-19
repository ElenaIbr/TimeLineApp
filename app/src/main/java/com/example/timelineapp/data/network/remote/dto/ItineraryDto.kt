package com.example.timelineapp.data.network.remote.dto

import com.example.timelineapp.data.database.models.StorageItinerary
import com.example.timelineapp.domain.model.Itinerary

data class ItineraryDto(
    var id: Int,
    var departureId: Int,
    var destinationId: Int,
    var date: Long,
    var distance: Int,
    var flight: FlightDto,
    var hotel: HotelDto,
    var carRent: CarRentDto
)

fun ItineraryDto.convertToItinerary(): Itinerary {
    return Itinerary(
        id = this.id,
        departureId = this.departureId,
        destinationId = this.destinationId,
        date = this.date,
        distance = this.distance,
        flightId = this.flight.id,
        hotelId = this.hotel.id,
        carRentId = this.carRent.id
    )
}

fun ItineraryDto.convertToStorageItinerary(): StorageItinerary {
    return StorageItinerary(
        id = this.id,
        departureId = this.departureId,
        destinationId = this.destinationId,
        distance = this.distance,
        flightId = this.flight.id,
        hotelId = this.hotel.id,
        carRentId = this.carRent.id
    )
}