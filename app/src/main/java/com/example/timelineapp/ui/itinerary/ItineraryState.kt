package com.example.timelineapp.ui.itinerary

import com.example.timelineapp.domain.model.Itinerary

data class ItineraryState (
    val itinerary: Itinerary? = null,
    val isLoafing: Boolean = false,
    val error: String = ""
)
