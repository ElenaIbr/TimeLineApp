package com.example.timelineapp.ui.bestitinerarysearch.viewmodel

import androidx.lifecycle.ViewModel
import com.example.timelineapp.data.database.repository.ItineraryRepository
import com.example.timelineapp.domain.model.Itinerary
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ItinerarySearchViewModel @Inject constructor(
    private val dbRepository: ItineraryRepository
): ViewModel() {
    var tasks = dbRepository.getItineraries()

    /*@RequiresApi(Build.VERSION_CODES.O)
    fun onEvent(event: TaskListEvent) {
        when(event) {
            is TaskListEvent.OnTaskClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.ITINERARY+ "?taskId=${event.task.id}"))
            }
            is TaskListEvent.OnDeleteTaskClick -> {
                viewModelScope.launch {
                    deletedTask = event.task
                    repository.deleteTask(event.task)
                    sendUiEvent(UiEvent.ShowSnackbar(
                        message = "Task was deleted",
                        action = "Return"
                    ))
                }
            }
        }
    }
    private fun sendUiEvent(event: UiEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }*/

}

sealed class TaskListEvent {
    data class OnDeleteTaskClick(val task: Itinerary): TaskListEvent()
    data class OnTaskClick(val task: Itinerary): TaskListEvent()
}