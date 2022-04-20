package com.example.timelineapp.data.network.remote.dto

import com.example.timelineapp.data.database.TempAppData
import com.example.timelineapp.data.database.model.StorageItinerary
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

fun StorageItinerary.convertToItinerary(): ItineraryDto {
    return ItineraryDto(
        id = this.id ?: 1,
        date = TempAppData.itinerary.date,
        departureId = this.departureId,
        destinationId = this.destinationId,
        distance = this.distance,
        flight = TempAppData.itinerary.flight,
        hotel = TempAppData.itinerary.hotel,
        carRent = TempAppData.itinerary.carRent
    )
}