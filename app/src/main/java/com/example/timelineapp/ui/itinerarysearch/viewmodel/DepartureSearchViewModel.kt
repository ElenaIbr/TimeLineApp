package com.example.timelineapp.ui.itinerarysearch.viewmodel

import androidx.lifecycle.ViewModel
import com.example.timelineapp.domain.model.Place
import com.example.timelineapp.domain.usecase.get_all_places.GetAllPlacesUseCase
import com.example.timelineapp.utilits.Resource
import androidx.lifecycle.viewModelScope
import com.example.timelineapp.data.network.remote.dto.convertToPlace
import com.example.timelineapp.ui.itinerarysearch.state.SearchUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class DepartureSearchViewModel @Inject constructor(
    private val getAllPlacesUseCase: GetAllPlacesUseCase
): ViewModel() {

    private val _searchState = MutableStateFlow(SearchUIState())
    val searchState: StateFlow<SearchUIState> = _searchState

    fun getSearchResult(query: String) {
        getAllPlacesUseCase(query).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    val resultList: MutableList<Place> = mutableListOf()
                    result.data?.forEach { place ->
                        resultList.add(place.convertToPlace())
                    }

                    _searchState.value = SearchUIState(
                        places = resultList.filter { it.city.contains(query) || it.address.contains(query) }
                    )
                }
                is Resource.Error -> {
                    /*_searchState.value = SearchUIState(
                        error = result.message ?: "An unexpected error"
                    )*/
                    _searchState.value = SearchUIState(
                        places = actorsListData().filter { it.city.contains(query) || it.address.contains(query) }
                    )
                }
                is Resource.Loading -> {
                    _searchState.value = SearchUIState(isLoafing = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun setPlace(title: String) {
        _searchState.value = SearchUIState(chosenPlace = title)
    }

    fun cleanSearch() {
        _searchState.value = SearchUIState(chosenPlace = "")
    }

    private fun actorsListData(): List<Place> {
        val data = mutableListOf(
            Place(
                id = 0,
                placeId = "3",
                city = "Delft",
                address = "address"
            ),
            Place(
                id = 1,
                placeId = "4",
                city = "Rijswijk",
                address = "address"
            )
        )
        val places = mutableListOf<Place>()
        data.forEach {
            places.add(it)
        }
        return places
    }
}
