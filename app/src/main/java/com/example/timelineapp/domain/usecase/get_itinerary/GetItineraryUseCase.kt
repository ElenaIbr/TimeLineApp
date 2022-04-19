package com.example.timelineapp.domain.usecase.get_itinerary

import com.example.timelineapp.data.database.ItineraryRepository
import com.example.timelineapp.data.network.remote.dto.*
import com.example.timelineapp.domain.model.Flight
import com.example.timelineapp.domain.model.Itinerary
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
    operator fun invoke(departureId: String, destinationId: String, date: Long): Flow<Resource<ItineraryDto>> = flow {
        try {
            emit(Resource.Loading())
            val itinerary = repository.getBestItinerary("", "", "")
            itinerary.id = 1
            itinerary.date = 164646456
            itinerary.departureId = 1
            itinerary.destinationId = 1
            itinerary.distance = 1
            itinerary.flight = FlightDto(
                id = 1,
                date = "",
                departureId = 1,
                destinationId = 1,
                flightNumber = "cdscds",
                gate = "fdfsd"
            )
            itinerary.hotel = HotelDto(
                id = 1,
                title = "",
                city = "",
                address = "",
                image = "",
                phone = "",
                rooms = emptyList()
            )
            itinerary.carRent = CarRentDto(
                id = 1,
                title = "",
                city = "",
                address = "",
                image = "",
                phone = "",
            )
            //dbRepository.insertItinerary(itinerary.convertToStorageItinerary())
            emit(Resource.Success(itinerary))
        } catch(e: HttpException){
            emit(Resource.Error<ItineraryDto>(e.localizedMessage ?: "An unexpected error"))
        } catch (e: IOException){
            emit(Resource.Error<ItineraryDto>("Couldn't reach server"))

            val itinerary = repository.getBestItinerary("", "", "")
            itinerary.id = 1
            itinerary.date = 164646456
            itinerary.departureId = 1
            itinerary.destinationId = 1
            itinerary.distance = 1
            itinerary.flight = FlightDto(
                id = 1,
                date = "",
                departureId = 1,
                destinationId = 1,
                flightNumber = "cdscds",
                gate = "fdfsd"
            )
            itinerary.hotel = HotelDto(
                id = 1,
                title = "",
                city = "",
                address = "",
                image = "",
                phone = "",
                rooms = emptyList()
            )
            itinerary.carRent = CarRentDto(
                id = 1,
                title = "",
                city = "",
                address = "",
                image = "",
                phone = "",
            )
        }
    }
}