package com.example.timelineapp.ui.itinerarysearch.departuresearch

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.timelineapp.R
import com.example.timelineapp.ui.itinerarysearch.viewmodel.DepartureSearchViewModel

@Composable
fun DepartureSearchField(
    searchViewModel: DepartureSearchViewModel = hiltViewModel(),
    onPlaceChosen: (String) -> Unit
) {

    val searchState by searchViewModel.searchState.collectAsState()

    var query: String by rememberSaveable { mutableStateOf("") }
    var showClearIcon by rememberSaveable { mutableStateOf(false) }

    if (query.isEmpty()) {
        showClearIcon = false
        searchViewModel.cleanSearch()
    } else if (query.isNotEmpty()) {
        showClearIcon = true
    }

    Column {
        TextField(
            value = if (searchState.chosenPlace == "") query else searchState.chosenPlace,
            onValueChange = { onQueryChanged ->
                query = onQueryChanged

                if (onQueryChanged.isNotEmpty()) {
                    searchViewModel.getSearchResult(onQueryChanged)
                } else {
                    searchViewModel.cleanSearch()
                    onPlaceChosen("")
                }
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    tint = MaterialTheme.colors.onBackground,
                    contentDescription = "Search Icon"
                )
            },
            trailingIcon = {
                if (showClearIcon) {
                    IconButton(onClick = {
                        query = ""
                    }) {
                        Icon(
                            imageVector = Icons.Rounded.Clear,
                            tint = MaterialTheme.colors.onBackground,
                            contentDescription = "Clear Icon"
                        )
                    }
                }
            },
            colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent),
            maxLines = 1,
            placeholder = { Text(text = "from A") },
            textStyle = MaterialTheme.typography.subtitle1,
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colors.background, shape = RectangleShape)
        )

        if (!searchState.places.isNullOrEmpty()) {
            LazyColumn(
                modifier = Modifier.padding(bottom = 48.dp)
            ) {
                searchState.places.forEach { place ->
                    item {
                        Text(
                            text = place.city + ", " + place.address,
                            style = MaterialTheme.typography.h6,
                            color = MaterialTheme.colors.onBackground,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp, vertical = 12.dp)
                                .wrapContentWidth(Alignment.Start)
                                .clickable {
                                    searchViewModel.setPlace(place.city + ", " + place.address)
                                    onPlaceChosen(place.placeId)
                                }
                        )
                    }
                }
            }
        } else {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(painter = painterResource(id = R.drawable.ic_road_route_destination), contentDescription = "empty")
            }

        }

    }
}
