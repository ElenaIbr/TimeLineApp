package com.example.timelineapp.data.network.remote

import com.example.timelineapp.data.network.remote.dto.ItineraryDto
import com.example.timelineapp.data.network.remote.dto.PlaceDto
import retrofit2.http.GET
import retrofit2.http.Query

interface BestItineraryApi {
    @GET("/get-best-itinerary")
    suspend fun getBestItinerary(
        @Query("departure_id") departureId: String,
        @Query("destination_id") destinationId: String,
        @Query("date") date: String
    ): ItineraryDto

    @GET("/get-place")
    suspend fun getAllPlaces(
        @Query("query") query: String
    ): List<PlaceDto>
}
