package com.example.timelineapp.ui.itinerary

import com.example.timelineapp.domain.model.Itinerary

data class ItineraryState (
    val isLoafing: Boolean = false,
    val itinerary: Itinerary? = null,
    val error: String = ""
)