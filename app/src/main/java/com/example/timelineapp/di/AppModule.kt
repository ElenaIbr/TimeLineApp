package com.example.timelineapp.di

import android.app.Application
import androidx.room.Room
import com.example.timelineapp.data.database.ItineraryDatabase
import com.example.timelineapp.data.database.repository.ItineraryRepository
import com.example.timelineapp.data.database.repository.ItineraryRepositoryImpl
import com.example.timelineapp.data.network.remote.BestItineraryApi
import com.example.timelineapp.data.network.repository.BestItineraryImpl
import com.example.timelineapp.domain.repository.BestItineraryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideBestItineraryApi(): BestItineraryApi {
        return Retrofit.Builder()
            .baseUrl("https://stackoverflow.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BestItineraryApi::class.java)
    }

    @Provides
    @Singleton
    fun provideBestItineraryRepository(api: BestItineraryApi): BestItineraryRepository {
        return BestItineraryImpl(api)
    }

    @Provides
    @Singleton
    fun provideItineraryDatabase(app: Application): ItineraryDatabase {
        return Room.databaseBuilder(
            app,
            ItineraryDatabase::class.java,
            "itinerary_table"
        ).build()
    }

    @Provides
    @Singleton
    fun provideItineraryRepository(db: ItineraryDatabase): ItineraryRepository {
        return ItineraryRepositoryImpl(db.itineraryDao)
    }
}
