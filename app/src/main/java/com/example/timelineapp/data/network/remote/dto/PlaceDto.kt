package com.example.timelineapp.data.network.remote.dto

import com.example.timelineapp.data.database.models.StoragePlace
import com.example.timelineapp.domain.model.Place

data class PlaceDto(
    val id: String,
    val city: String,
    val address: String
)

fun PlaceDto.convertToPlace(): Place {
    return Place(
        id = this.id,
        city = this.city,
        address = this.address
    )
}

fun PlaceDto.convertToStoragePlace(): StoragePlace {
    return StoragePlace(
        id = this.id,
        city = this.city,
        address = this.address
    )
}