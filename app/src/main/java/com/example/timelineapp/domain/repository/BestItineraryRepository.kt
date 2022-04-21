package com.example.timelineapp.domain.repository

import com.example.timelineapp.data.network.remote.dto.ItineraryDto
import com.example.timelineapp.data.network.remote.dto.PlaceDto

interface BestItineraryRepository {

    suspend fun getBestItinerary(
        departureId: String,
        destinationId: String,
        date: String
    ) : ItineraryDto

    suspend fun getAllPlaces(query: String) : List<PlaceDto>

}