package com.example.timelineapp.domain.usecase.get_all_places

import com.example.timelineapp.data.database.ItineraryRepository
import com.example.timelineapp.data.network.remote.dto.PlaceDto
import com.example.timelineapp.data.network.remote.dto.convertToPlace
import com.example.timelineapp.data.network.remote.dto.convertToStoragePlace
import com.example.timelineapp.domain.repository.BestItineraryRepository
import com.example.timelineapp.utilits.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetAllPlacesUseCase @Inject constructor(
    private val networkRepository: BestItineraryRepository,
    private val dbRepository: ItineraryRepository
) {
    operator fun invoke(): Flow<Resource<List<PlaceDto>>> = flow {
        try {
            emit(Resource.Loading())
            val places = networkRepository.getAllPlaces()
            /*places.forEach { place ->
                dbRepository.insertItinerary(place.convertToStoragePlace())

            }*/
            emit(Resource.Success(places))
        } catch(e: HttpException){
            emit(Resource.Error<List<PlaceDto>>(e.localizedMessage ?: "An unexpected error"))
        } catch (e: IOException){
            emit(Resource.Error<List<PlaceDto>>("Couldn't reach server"))
        }
    }
}
