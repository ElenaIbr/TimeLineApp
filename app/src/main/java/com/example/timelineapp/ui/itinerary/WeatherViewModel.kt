package com.example.timelineapp.ui.itinerary

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.timelineapp.data.network.remote.dto.convertToItinerary
import com.example.timelineapp.domain.usecase.get_itinerary.GetItineraryUseCase
import com.example.timelineapp.utilits.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val getItineraryUseCase: GetItineraryUseCase
): ViewModel() {

    private val _state = mutableStateOf(ItineraryState())
    val state: State<ItineraryState> = _state

    init {
        getWeather()
    }

    private fun getWeather() {
        getItineraryUseCase("1", "1", 11212123123).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = ItineraryState(itinerary = result.data?.convertToItinerary())
                }
                is Resource.Error -> {
                    _state.value = ItineraryState(error = result.message ?: "An unexpected error")
                }
                is Resource.Loading -> {
                    _state.value = ItineraryState(isLoafing = true)
                }
            }

        }.launchIn(viewModelScope)
    }
}
