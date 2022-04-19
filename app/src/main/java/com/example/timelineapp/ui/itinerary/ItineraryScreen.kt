package com.example.timelineapp.ui.itinerary

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ItineraryScreen(
    viewModel: WeatherViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Text(
        text = state.error.toString()
    )
}