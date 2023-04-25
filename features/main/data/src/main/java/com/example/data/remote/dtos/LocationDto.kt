package com.example.data.remote.dtos

import com.example.data.mapper.DataMapper
import com.example.domain.model.LocationModel

data class LocationDto(
    val name: String,
    val type: String
) : DataMapper<LocationModel> {
    override fun toDomain() = LocationModel(
        name = name,
        type = type
    )
}