package com.example.timelineapp.ui.bestitinerarysearch.state

import com.example.timelineapp.domain.model.Place

data class SearchUIState(
    val places: List<Place> = mutableListOf(),
    val chosenPlace: String = "",
    val isLoafing: Boolean = false,
    val error: String = ""
)
