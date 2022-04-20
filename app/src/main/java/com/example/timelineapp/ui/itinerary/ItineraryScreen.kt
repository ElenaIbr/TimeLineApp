package com.example.timelineapp.ui.itinerary

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ItineraryScreen(
    viewModel: ItineraryViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    LaunchedEffect(key1 = Unit) {
        viewModel.getItinerary("", "", "")
    }

    Text(
        text = state.error.toString()
    )
}