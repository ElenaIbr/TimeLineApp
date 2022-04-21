package com.example.timelineapp.data.database

import com.example.timelineapp.data.network.remote.dto.ItineraryDto
import com.example.timelineapp.domain.model.Place

object TempAppData {
    val itinerary = ItineraryDto(
        id = 1,
        departureId = 1,
        destinationId = 0,
        distance = 5,
        flightTitle = "Delft-Rijswijk",
        flightNumber = "2282-2611",
        flightDate = "no date",
        hotelTitle = "Casa Julia",
        hotelCity = "Delft",
        hotelAddress = "Yperstraat 12, 2611SH Delft",
        hotelImage = "https://kohlerautoverhuur.nl/images/contact/delft.jpg",
        hotelPhone = "+31152121419",
        carRentTitle = "Regio Delft",
        carRentCity = "Delft",
        carRentAddress = "Maerten Trompstraat 33, 2628RC Delft",
        carRentImage = "https://kohlerautoverhuur.nl/images/contact/delft.jpg",
        carRentPhone = "+31152121419"
    )

    val places = listOf<Place>(
        Place(
            id = 0,
            placeId = "3",
            city = "Delft",
            address = "Phoenixstraat 49, 2611AL Delft"
        ),
        Place(
            id = 1,
            placeId = "4",
            city = "Rijswijk",
            address = "Kerklaan 165, 2282CJ Rijswijk"
        )
    )
}
