package com.example.timelineapp.domain.usecase.get_all_places

import com.example.timelineapp.data.network.remote.dto.PlaceDto
import com.example.timelineapp.domain.repository.BestItineraryRepository
import com.example.timelineapp.utilits.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetAllPlacesUseCase @Inject constructor(
    private val networkRepository: BestItineraryRepository
) {
    operator fun invoke(query: String): Flow<Resource<List<PlaceDto>>> = flow {
        try {
            emit(Resource.Loading())
            val places = networkRepository.getAllPlaces(query)
            emit(Resource.Success(places))
        } catch(e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error"))
        } catch (e: IOException){
            emit(Resource.Error("Couldn't reach server"))
        }
    }
}
