package com.example.timelineapp.data.database

import com.example.timelineapp.data.network.remote.dto.ItineraryDto

object TempAppData {
    val itinerary = ItineraryDto(
        id = 1,
        departureId = 1,
        destinationId = 2,
        distance = 5,
        flightTitle = "Delft-Delft",
        flightNumber = "2282",
        flightDate = "dsdf",
        hotelTitle = "Casa Julia",
        hotelCity = "Delft",
        hotelAddress = "Yperstraat 12 2611 SH Delft",
        hotelImage = "https://kohlerautoverhuur.nl/images/contact/delft.jpg",
        hotelPhone = "+31152121419",
        carRentTitle = "Regio Delft",
        carRentCity = "Delft",
        carRentAddress = "Maerten Trompstraat 33, 2628 RC",
        carRentImage = "https://kohlerautoverhuur.nl/images/contact/delft.jpg",
        carRentPhone = "+31152121419"
    )
}
