package com.example.timelineapp.ui.bestitinerary.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.timelineapp.data.database.TempAppData
import com.example.timelineapp.data.database.model.convertToItinerary
import com.example.timelineapp.data.database.repository.ItineraryRepository
import com.example.timelineapp.data.network.remote.dto.convertToItinerary
import com.example.timelineapp.domain.usecase.get_itinerary.GetItineraryUseCase
import com.example.timelineapp.ui.bestitinerary.state.ItineraryState
import com.example.timelineapp.utilits.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItineraryViewModel @Inject constructor(
    private val getItineraryUseCase: GetItineraryUseCase,
    private val dbRepository: ItineraryRepository,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _itineraryState = mutableStateOf(ItineraryState())
    val itineraryState: State<ItineraryState> = _itineraryState

    private val departureId = savedStateHandle.get<String>("departureId")!!
    private val destinationId = savedStateHandle.get<String>("destinationId")!!
    private val itineraryDate = savedStateHandle.get<String>("itineraryDate")!!
    private val itineraryId = savedStateHandle.get<Int>("itineraryId")!!
    private val isNewItinerary = savedStateHandle.get<Boolean>("isNewItinerary")!!

    init {
        if (isNewItinerary) {
            getNewItinerary(departureId, destinationId, itineraryDate)
        } else {
            getItineraryFromLocalById(itineraryId)
        }
    }

    private fun getNewItinerary(departureId: String, destinationId: String, date: String) {
        getItineraryUseCase(departureId, destinationId, date).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _itineraryState.value = ItineraryState(itinerary = result.data?.convertToItinerary())
                }
                is Resource.Error -> {
                    _itineraryState.value = ItineraryState(
                        error = result.message ?: "An unexpected error"
                    )
                    /*_itineraryState.value = ItineraryState(
                        itinerary = TempAppData.itinerary.convertToItinerary()
                    )
                    _itineraryState.value.date = itineraryDate*/
                }
                is Resource.Loading -> {
                    _itineraryState.value = ItineraryState(isLoafing = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getItineraryFromLocalById(itineraryId: Int) {
        viewModelScope.launch {
            _itineraryState.value = ItineraryState(
                itinerary = dbRepository.getItineraryById(itineraryId)?.convertToItinerary()
            )
        }
    }
}
