package com.example.timelineapp.ui.bestitinerarysearch.departuresearch

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.timelineapp.ui.bestitinerarysearch.viewmodel.DepartureSearchViewModel
import com.example.timelineapp.ui.components.PrimaryTextField

@Composable
fun DepartureSearchField(
    searchViewModel: DepartureSearchViewModel = hiltViewModel(),
    onPlaceChosen: (String) -> Unit
) {
    val searchState by searchViewModel.searchState.collectAsState()
    PrimaryTextField(
        searchState,
        showImage = true,
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

