package com.example.timelineapp.data.network.remote.dto

import com.example.timelineapp.data.database.model.StoragePlace
import com.example.timelineapp.domain.model.Place

data class PlaceDto(
    val placeId: String,
    val city: String,
    val address: String,
    val id: Int
)

fun PlaceDto.convertToPlace(): Place {
    return Place(
        placeId = this.placeId,
        city = this.city,
        address = this.address,
        id = this.id
    )
}

fun PlaceDto.convertToStoragePlace(): StoragePlace {
    return StoragePlace(
        placeId = this.placeId,
        city = this.city,
        address = this.address,
        id = this.id
    )
}