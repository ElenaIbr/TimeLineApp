package com.example.timelineapp.ui.bestitinerarysearch.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.timelineapp.data.database.model.StorageItinerary
import com.example.timelineapp.data.database.repository.ItineraryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItinerarySearchViewModel @Inject constructor(
    private val dbRepository: ItineraryRepository
): ViewModel() {
    var itineraries = dbRepository.getItineraries()

    fun deleteItinerary(itinerary: StorageItinerary) {
        viewModelScope.launch {
            dbRepository.deleteItinerary(itinerary)
        }
    }
}
