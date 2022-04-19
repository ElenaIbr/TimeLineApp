package com.example.timelineapp.data.network.remote.dto

import com.example.timelineapp.domain.model.CarRent

data class CarRentDto(
    val id: Int,
    val title: String,
    val city: String,
    val address: String,
    val image: String,
    val phone: String
)

fun CarRentDto.convertToCarRent(): CarRent {
    return CarRent(
        id = this.id,
        title = this.title,
        city = this.city,
        address = this.address,
        image = this.image,
        phone = this.phone
    )
}