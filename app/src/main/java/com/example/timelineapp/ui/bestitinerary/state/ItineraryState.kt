package com.example.timelineapp.ui.bestitinerary.state

import com.example.timelineapp.domain.model.Itinerary

data class ItineraryState (
    val itinerary: Itinerary? = null,
    val departureId: String? = null,
    val destinationId: String? = null,
    val date: String? = null,
    val itineraryId: Int? = null,
    val isNewItinerary: Boolean? = null,
    val isLoafing: Boolean = false,
    val error: String = ""
)
