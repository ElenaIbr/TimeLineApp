package com.example.timelineapp.ui.bestitinerary

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.timelineapp.R
import com.example.timelineapp.ui.bestitinerary.viewmodel.ItineraryViewModel
import com.yeocak.timelineview.TimelineView

@OptIn(
    ExperimentalUnitApi::class,
    ExperimentalMaterialApi::class,
    ExperimentalFoundationApi::class
)
@Composable
fun ItineraryScreen(
    itineraryViewModel: ItineraryViewModel = hiltViewModel(),
    onBackStack: () -> Unit
) {

    val itineraryState = itineraryViewModel.itineraryState.value

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .height(
                        dimensionResource(id = R.dimen.itinerary_screen_height)
                    ),
                title = {
                    Text(
                        text = stringResource(id = R.string.best_itinerary)
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        onBackStack.invoke()
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
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = dimensionResource(id = R.dimen.app_padding))
            ) {
                item {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = itineraryState.date ?: "",
                            fontSize = 18.sp
                        )
                    }
                }
                item {
                    Box(
                        modifier = Modifier
                            .fillParentMaxHeight(0.3F)
                    ) {
                        PointInfoCard(
                            cardName = stringResource(id = R.string.best_flight),
                            type = TimelineView.NodeType.FIRST,
                            title = itineraryState.itinerary?.flightTitle ?: "",
                            phone = itineraryState.itinerary?.flightDate ?: "",
                            address = itineraryState.itinerary?.flightNumber ?: "",
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
                            cardName = stringResource(id = R.string.best_hotel),
                            type = TimelineView.NodeType.MIDDLE,
                            title = itineraryState.itinerary?.hotelTitle ?: "",
                            phone = itineraryState.itinerary?.hotelPhone ?: "",
                            address = itineraryState.itinerary?.hotelAddress ?: "",
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
                            cardName = stringResource(id = R.string.best_car_rent),
                            type = TimelineView.NodeType.LAST,
                            title = itineraryState.itinerary?.carRentTitle ?: "",
                            phone = itineraryState.itinerary?.carRentPhone ?: "",
                            address = itineraryState.itinerary?.carRentAddress ?: "",
                            image = R.drawable.ic_car
                        )
                    }
                }
            }
        }
    )
}
