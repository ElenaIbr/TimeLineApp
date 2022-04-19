package com.example.timelineapp.data.database

import com.example.timelineapp.data.database.models.StorageItinerary
import kotlinx.coroutines.flow.Flow

class ItineraryRepositoryImpl(
    private val dao: ItineraryDao
): ItineraryRepository {
    override suspend fun insertItinerary(storageItinerary: StorageItinerary) {
        dao.insertItinerary(storageItinerary)
    }

    override suspend fun deleteItinerary(storageItinerary: StorageItinerary) {
        dao.deleteItinerary(storageItinerary)
    }

    override suspend fun getItineraryById(id: Int): StorageItinerary? {
        return dao.getItineraryById(id)
    }

    override fun getItineraries(): Flow<List<StorageItinerary>> {
        return  dao.getItineraries()
    }
}