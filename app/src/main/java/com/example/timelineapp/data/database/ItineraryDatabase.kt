package com.example.timelineapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.timelineapp.data.database.dao.ItineraryDao
import com.example.timelineapp.data.database.model.StorageItinerary

@Database(
    entities = [
        StorageItinerary::class
    ],
    version = 1
)
abstract class ItineraryDatabase: RoomDatabase() {
    abstract val itineraryDao: ItineraryDao
}
