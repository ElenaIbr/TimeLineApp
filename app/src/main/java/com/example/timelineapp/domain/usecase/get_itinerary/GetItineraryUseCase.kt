package com.example.timelineapp.domain.usecase.get_itinerary

import com.example.timelineapp.data.database.TempAppData
import com.example.timelineapp.data.database.repository.ItineraryRepository
import com.example.timelineapp.data.network.remote.dto.*
import com.example.timelineapp.domain.repository.BestItineraryRepository
import com.example.timelineapp.utilits.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetItineraryUseCase @Inject constructor(
    private val repository: BestItineraryRepository,
    private val dbRepository: ItineraryRepository
) {
    operator fun invoke(departureId: String, destinationId: String, date: String): Flow<Resource<ItineraryDto>> = flow {
        try {
            emit(Resource.Loading())
            val itinerary = repository.getBestItinerary(departureId, destinationId, date)
            dbRepository.insertItinerary(itinerary.convertToStorageItinerary())

            emit(Resource.Success(itinerary))
        } catch(e: HttpException){
            emit(Resource.Error<ItineraryDto>(e.localizedMessage ?: "An unexpected error"))
        } catch (e: IOException){
            emit(Resource.Error<ItineraryDto>("Couldn't reach server"))

            if (dbRepository.getItineraryById(TempAppData.itinerary.id) == null) {
                dbRepository.insertItinerary(TempAppData.itinerary.convertToStorageItinerary())
            }
        }
    }
}