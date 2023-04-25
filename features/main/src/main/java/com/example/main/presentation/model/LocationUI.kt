package com.example.main.presentation.model

import com.example.domain.model.LocationModel

data class LocationUI(
    val name: String,
    val type: String
)
fun LocationModel.toUI() = LocationUI(
    name = name,
    type = type
)