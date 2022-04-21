package com.example.timelineapp.data.network.repository

import com.example.timelineapp.data.network.remote.BestItineraryApi
import com.example.timelineapp.data.network.remote.dto.*
import com.example.timelineapp.domain.repository.BestItineraryRepository
import javax.inject.Inject

class BestItineraryImpl @Inject constructor(
    private val api: BestItineraryApi
): BestItineraryRepository {

    override suspend fun getBestItinerary(
        departureId: String,
        destinationId: String,
        date: String
    ): ItineraryDto {
        return api.getBestItinerary(departureId, destinationId, date)
    }

    override suspend fun getAllPlaces(query: String): List<PlaceDto> {
        return api.getAllPlaces(query)
    }

}
