package com.example.timelineapp.ui.bestitinerarysearch

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.timelineapp.R
import com.example.timelineapp.ui.bestitinerarysearch.components.ItineraryItem
import com.example.timelineapp.ui.bestitinerarysearch.departuresearch.DepartureSearchField
import com.example.timelineapp.ui.bestitinerarysearch.destinationsearch.DestinationSearchField
import com.example.timelineapp.ui.bestitinerarysearch.viewmodel.ItinerarySearchViewModel
import com.example.timelineapp.ui.components.PrimaryButton
import com.example.timelineapp.ui.components.PrimaryDatePicker
import com.example.timelineapp.utilits.Constants
import com.example.timelineapp.utilits.Routes

@Composable
fun ItinerarySearchSearch(
    itinerarySearchViewModel: ItinerarySearchViewModel = hiltViewModel(),
    navController: NavController
) {
    val  itineraries = itinerarySearchViewModel.itineraries.collectAsState(initial = emptyList())

    val departureId = remember { mutableStateOf("") }
    val destinationId = remember { mutableStateOf("") }
    val itineraryDate = remember { mutableStateOf("") }
    var screen by remember { mutableStateOf(ItineraryScreenType.CreateScreen) }

    var tabIndex by remember { mutableStateOf(0) }
    val tabData = listOf(
        stringResource(id = R.string.create_new),
        stringResource(id = R.string.saved_itineraries)
    )

    Surface(
        color = MaterialTheme.colors.background
    ) {
        Column {
            TabRow(
                selectedTabIndex = tabIndex,
                backgroundColor = Color.White,
                contentColor = Color.Black
            ) {
                tabData.forEachIndexed { index, text ->
                    Tab(
                        selected = tabIndex == index,
                        onClick = {
                            tabIndex = index
                            screen = if (index == 0) {
                                ItineraryScreenType.CreateScreen
                            } else {
                                ItineraryScreenType.SavedItinerariesScreen
                                ItineraryScreenType.SavedItinerariesScreen
                            }
                        },
                        text = {
                            Text(
                                text = text,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    )
                }
            }
            when(screen) {
                ItineraryScreenType.CreateScreen -> {
                    Box(
                        modifier = Modifier
                            .height(
                                dimensionResource(id = R.dimen.search_field_height)
                            )
                            .padding(
                                vertical = dimensionResource(id = R.dimen.app_small_padding),
                                horizontal = dimensionResource(id = R.dimen.app_small_padding)
                            )
                    ) {
                        DepartureSearchField(
                            onPlaceChosen = { placeId ->
                                departureId.value = placeId
                            }
                        )
                    }
                    Box(
                        modifier = Modifier
                            .height(
                                dimensionResource(id = R.dimen.search_field_height)
                            )
                            .padding(
                                vertical = dimensionResource(id = R.dimen.app_small_padding),
                                horizontal = dimensionResource(id = R.dimen.app_small_padding)
                            )
                    ) {
                        DestinationSearchField(
                            onPlaceChosen = { placeId ->
                                destinationId.value = placeId
                            }
                        )
                    }
                    PrimaryDatePicker(
                        onDataChosen = { date ->
                            itineraryDate.value = date
                        }
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.BottomEnd
                    ) {
                        PrimaryButton(
                            title = stringResource(id = R.string.create_btn_title),
                            enabled = departureId.value != "" && destinationId.value != "" && itineraryDate.value != "",
                            onClick = {
                                navController.navigate(
                                    Routes.ITINERARY + "?${Constants.DEPARTURE_ID}=${departureId.value}"
                                            + "?${Constants.DESTINATION_ID}=${destinationId.value}"
                                            + "?${Constants.ITINERARY_DATE}=${itineraryDate.value}"
                                            + "?${Constants.ITINERARY_ID}=${-1}"
                                            + "?${Constants.IS_NEW_ITINERARY}=${true}"
                                )
                            }
                        )
                    }
                }
                ItineraryScreenType.SavedItinerariesScreen -> {
                    if (itineraries.value.isNotEmpty()) {
                        itineraries.value.forEach {
                            ItineraryItem(
                                itinerary = it,
                                onClick = {
                                    navController.navigate(
                                        Routes.ITINERARY + "?${Constants.DEPARTURE_ID}=${""}"
                                                + "?${Constants.DESTINATION_ID}=${""}"
                                                + "?${Constants.ITINERARY_DATE}=${""}"
                                                + "?${Constants.ITINERARY_ID}=${it.id}"
                                                + "?${Constants.IS_NEW_ITINERARY}=${false}"
                                    )
                                }
                            )
                        }
                    } else {
                        Box(
                            modifier = Modifier
                                .fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = stringResource(id = R.string.no_itineraries_label)
                            )
                        }
                    }
                }
            }
        }
    }
}



