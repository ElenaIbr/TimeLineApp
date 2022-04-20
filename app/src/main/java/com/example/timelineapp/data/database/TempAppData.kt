package com.example.timelineapp.data.database

import com.example.timelineapp.data.network.remote.dto.FlightDto
import com.example.timelineapp.data.network.remote.dto.HotelDto
import com.example.timelineapp.data.network.remote.dto.ItineraryDto
import com.example.timelineapp.data.network.remote.dto.CarRentDto

object TempAppData {

    private val flight = FlightDto(
        id = 1,
        date = "20/04/2022",
        departureId = 1,
        destinationId = 2,
        flightNumber = "2282",
        gate = "5"
    )

    private val hotel = HotelDto(
        id = 1,
        title = "Casa Julia",
        city = "Delft",
        address = "Maerten Trompstraat 33, 2628 RC",
        image = "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/1e/38/8b/de/casa-julia.jpg?w=900&h=-1&s=1",
        phone = "+31000000000",
        rooms = listOf("")
    )

    private val carRentDto = CarRentDto(
        id = 1,
        title = "Regio Delft",
        city = "Delft",
        address = "Yperstraat 12 2611 SH Delft",
        image = "https://kohlerautoverhuur.nl/images/contact/delft.jpg",
        phone = "+31152121419"
    )

    val itinerary = ItineraryDto(
        id = 1,
        date = 1650435299,
        departureId = 1,
        destinationId = 2,
        distance = 5,
        flight = flight,
        hotel = hotel,
        carRent = carRentDto
    )
}
