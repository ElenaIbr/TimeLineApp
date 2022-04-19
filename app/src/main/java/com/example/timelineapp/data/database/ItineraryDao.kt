package com.example.timelineapp.data.database

import androidx.room.*
import com.example.timelineapp.data.database.models.StorageItinerary
import kotlinx.coroutines.flow.Flow

@Dao
interface ItineraryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItinerary(itinerary: StorageItinerary)

    @Delete
    suspend fun deleteItinerary(itinerary: StorageItinerary)

    @Query("SELECT * FROM storageitinerary WHERE id = :id")
    suspend fun getItineraryById(id: Int): StorageItinerary?

    @Query("SELECT * FROM storageitinerary")
    fun getItineraries(): Flow<List<StorageItinerary>>
}
