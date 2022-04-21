package com.example.timelineapp.ui.itinerarysearch

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.timelineapp.ui.itinerarysearch.departuresearch.DepartureSearchField
import com.example.timelineapp.ui.itinerarysearch.destinationsearch.DestinationSearchField
import com.example.timelineapp.ui.components.PrimaryButton
import com.example.timelineapp.utilits.Routes
import com.example.timelineapp.utilits.UiEvent

@Composable
fun ItinerarySearchSearch(
    navController: NavController
) {

    val departureId = remember { mutableStateOf("") }
    val destinationId = remember { mutableStateOf("") }

    Surface(
        color = MaterialTheme.colors.background
    ) {
        Column {
            Box(
                modifier = Modifier.height(200.dp)
            ) {
                DepartureSearchField(
                    onPlaceChosen = { placeId ->
                        departureId.value = placeId
                    }
                )
            }
            Box(
                modifier = Modifier.height(200.dp)
            ) {
                DestinationSearchField(
                    onPlaceChosen = { placeId ->
                        destinationId.value = placeId
                    }
                )
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomEnd
    ) {
        PrimaryButton(
            title = "Create Itinerary",
            enabled = departureId.value != "" && destinationId.value != "",
            onClick = {
                navController.navigate(Routes.ITINERARY)
            }
        )
    }
}
