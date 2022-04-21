package com.example.timelineapp.ui.itinerary.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.timelineapp.data.database.TempAppData
import com.example.timelineapp.data.database.TempAppData.itinerary
import com.example.timelineapp.data.database.model.StorageItinerary
import com.example.timelineapp.data.database.repository.ItineraryRepository
import com.example.timelineapp.data.network.remote.dto.convertToItinerary
import com.example.timelineapp.domain.model.Itinerary
import com.example.timelineapp.domain.usecase.get_itinerary.GetItineraryUseCase
import com.example.timelineapp.ui.itinerary.state.ItineraryState
import com.example.timelineapp.utilits.Resource
import com.example.timelineapp.utilits.Routes
import com.example.timelineapp.utilits.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltViewModel
class ItineraryViewModel @Inject constructor(
    private val getItineraryUseCase: GetItineraryUseCase,
    private val dbRepository: ItineraryRepository
): ViewModel() {

    private val _uiEvent =  Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    private val _state = mutableStateOf(ItineraryState())
    val state: State<ItineraryState> = _state

    fun getItinerary(departureId: String, destinationId: String, date: String) {
        getItineraryUseCase(departureId, destinationId, date).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = ItineraryState(itinerary = result.data?.convertToItinerary())
                }
                is Resource.Error -> {
                    /*_state.value = ItineraryState(
                        error = result.message ?: "An unexpected error"
                    )*/
                    _state.value = ItineraryState(
                        itinerary = TempAppData.itinerary.convertToItinerary()
                    )
                }
                is Resource.Loading -> {
                    _state.value = ItineraryState(isLoafing = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun onEvent(event: TaskListEvent) {
        when(event) {
            is TaskListEvent.OnAddTaskClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.ITINERARY))
            }
            is TaskListEvent.OnTaskClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.ITINERARY + "?taskId=${event.task.id}"))
            }
            else -> {}
        }
    }

    private fun sendUiEvent(event: UiEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }

}


sealed class TaskListEvent {
    data class OnDeleteTaskClick(val task: Itinerary): TaskListEvent()
    object OnUndoDeleteClick: TaskListEvent()
    data class OnTaskClick(val task: Itinerary): TaskListEvent()
    object OnAddTaskClick: TaskListEvent()
}