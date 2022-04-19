package com.example.timelineapp.domain.model

data class Flight(
    val id: Int,
    val date: String,
    val departureId: Int,
    val destinationId: Int,
    val flightNumber: String,
    val gate: String
)