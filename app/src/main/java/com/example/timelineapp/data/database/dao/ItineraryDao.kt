package com.example.timelineapp.data.database.dao

import androidx.room.*
import com.example.timelineapp.data.database.model.StorageItinerary
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
