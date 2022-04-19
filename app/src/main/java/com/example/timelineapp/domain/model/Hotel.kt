package com.example.timelineapp.domain.model

data class Hotel(
    val id: Int,
    val title: String,
    val city: String,
    val address: String,
    val image: String,
    val phone: String,
    val rooms: List<String>
)
