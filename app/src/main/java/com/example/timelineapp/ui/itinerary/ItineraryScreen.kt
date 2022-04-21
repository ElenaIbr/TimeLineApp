package com.example.timelineapp.ui.itinerary

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.yeocak.timelineview.TimelineView
import com.example.timelineapp.R
import com.example.timelineapp.ui.components.PrimaryButton
import com.example.timelineapp.ui.itinerary.viewmodel.ItineraryViewModel

@OptIn(
    ExperimentalUnitApi::class,
    ExperimentalMaterialApi::class,
    ExperimentalFoundationApi::class
)
@Composable
fun ItineraryScreen(
    viewModel: ItineraryViewModel = hiltViewModel(),
    OnBackStack: () -> Unit
) {
    val state = viewModel.state.value

    LaunchedEffect(key1 = Unit) {
        viewModel.getItinerary("", "", "")
    }

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .height(
                        40.dp
                    ),
                title = {
                    Text(
                        text = "The Best Itinerary"
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        OnBackStack.invoke()
                    }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "back"
                        )
                    }
                },
                backgroundColor = Color.White
            )
        },
        content = {
            LazyColumn {
                item {
                    Box(
                        modifier = Modifier
                            .fillParentMaxHeight(0.3F)
                    ) {
                        PointInfoCard(
                            cardName = "Best Flight",
                            type = TimelineView.NodeType.FIRST,
                            title = state.itinerary?.flightTitle ?: "",
                            phone = state.itinerary?.flightDate ?: "",
                            address = state.itinerary?.flightNumber ?: "",
                            image = R.drawable.ic_flight_airplane
                        )
                    }
                }
                item {
                    Box(
                        modifier = Modifier
                            .fillParentMaxHeight(0.3F)
                    ) {
                        PointInfoCard(
                            cardName = "Best Hotel",
                            type = TimelineView.NodeType.MIDDLE,
                            title = state.itinerary?.hotelTitle ?: "",
                            phone = state.itinerary?.hotelPhone ?: "",
                            address = state.itinerary?.hotelAddress ?: "",
                            image = R.drawable.ic_hotel
                        )

                    }
                }
                item {
                    Box(
                        modifier = Modifier
                            .fillParentMaxHeight(0.3F)
                    ) {
                        PointInfoCard(
                            cardName = "Best Car Rent",
                            type = TimelineView.NodeType.LAST,
                            title = state.itinerary?.carRentTitle ?: "",
                            phone = state.itinerary?.carRentPhone ?: "",
                            address = state.itinerary?.carRentAddress ?: "",
                            image = R.drawable.ic_car
                        )
                    }
                }
            }
        }
    )
}
