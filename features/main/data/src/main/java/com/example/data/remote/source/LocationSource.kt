package com.example.data.remote.source

import com.example.data.base.BasePagingSource
import com.example.data.remote.apiservice.ApiService
import com.example.data.remote.dtos.LocationDto
import com.example.domain.model.LocationModel

class LocationSource(
    private val apiService: ApiService,
    private val name: String?
) : BasePagingSource<LocationDto, LocationModel>({
    apiService.getLocation(name = name, page = it)
}) {
}