package com.example.timelineapp.data.database.repository

import com.example.timelineapp.data.database.model.StorageItinerary
import kotlinx.coroutines.flow.Flow

interface ItineraryRepository {

    suspend fun insertItinerary(storageItinerary: StorageItinerary)

    suspend fun deleteItinerary(storageItinerary: StorageItinerary)

    suspend fun getItineraryById(id: Int): StorageItinerary?

    fun getItineraries(): Flow<List<StorageItinerary>>

}
