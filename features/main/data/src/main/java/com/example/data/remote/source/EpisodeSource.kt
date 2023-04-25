package com.example.data.remote.source

import com.example.data.base.BasePagingSource
import com.example.data.remote.apiservice.ApiService
import com.example.data.remote.dtos.EpisodeDto
import com.example.domain.model.EpisodeModel

class EpisodeSource(
    private val apiService: ApiService,
    private val name: String?
) : BasePagingSource<EpisodeDto, EpisodeModel>({
    apiService.getEpisodes(name = name, page = it)
})