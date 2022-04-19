package com.example.timelineapp.data.network.remote.dto

import com.example.timelineapp.domain.model.Flight

data class FlightDto(
    val id: Int,
    val date: String,
    val departureId: Int,
    val destinationId: Int,
    val flightNumber: String,
    val gate: String
)

fun FlightDto.convertToFlight(): Flight {
    return Flight(
        id = this.id,
        date = this.date,
        departureId = this.departureId,
        destinationId = this.destinationId,
        flightNumber = this.flightNumber,
        gate = this.gate
    )
}