package com.example.timelineapp.ui.bestitinerarysearch.destinationsearch

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.timelineapp.ui.bestitinerarysearch.viewmodel.DestinationSearchViewModel
import com.example.timelineapp.ui.components.PrimaryTextField

@Composable
fun DestinationSearchField(
    searchViewModel: DestinationSearchViewModel = hiltViewModel(),
    onPlaceChosen: (String) -> Unit
) {
    val searchState by searchViewModel.searchState.collectAsState()

    PrimaryTextField(
        searchState,
        showImage = false,
        onPlaceChosen,
        onSearchClean = {
            searchViewModel.cleanSearch()
        },
        onSearchResult = { value ->
            searchViewModel.getSearchResult(value)
        },
        onSetPlace = { value ->
            searchViewModel.setPlace(value)
        }
    )
}
