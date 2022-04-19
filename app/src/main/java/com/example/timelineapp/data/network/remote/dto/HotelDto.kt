package com.example.timelineapp.data.network.remote.dto

import com.example.timelineapp.domain.model.Hotel

data class HotelDto(
    val id: Int,
    val title: String,
    val city: String,
    val address: String,
    val image: String,
    val phone: String,
    val rooms: List<String>
)

fun HotelDto.convertToHotel(): Hotel {
    return Hotel(
        id = this.id,
        title = this.title,
        city = this.city,
        address = this.address,
        image = this.image,
        phone = this.phone,
        rooms = this.rooms,
    )
}