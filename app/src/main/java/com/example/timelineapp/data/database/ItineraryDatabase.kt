package com.example.timelineapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.timelineapp.data.database.models.StorageItinerary

@Database(
    entities = [StorageItinerary::class],
    version = 1
)
abstract class ItineraryDatabase: RoomDatabase() {
    abstract val dao: ItineraryDao
}