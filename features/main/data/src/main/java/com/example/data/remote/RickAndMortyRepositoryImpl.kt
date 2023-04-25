package com.example.data.remote

import androidx.paging.PagingData
import com.example.data.base.makePagingRequest
import com.example.data.remote.apiservice.ApiService
import com.example.data.remote.source.CharactersSource
import com.example.data.remote.source.EpisodeSource
import com.example.data.remote.source.LocationSource
import com.example.domain.model.CharacterModel
import com.example.domain.model.EpisodeModel
import com.example.domain.model.LocationModel
import com.example.domain.repository.RickAndMortyRepository
import kotlinx.coroutines.flow.Flow

class RickAndMortyRepositoryImpl(
    private val api: ApiService
) : RickAndMortyRepository {

    override fun getCharacter(
        name: String?,
        status: String?,
        gender: String?,
        species: String?
    ): Flow<PagingData<CharacterModel>> = makePagingRequest(
        CharactersSource(
            apiService = api,
            name = name,
            status = status,
            gender = gender,
            species = species
        )
    )

    override fun getLocation(name: String?): Flow<PagingData<LocationModel>> = makePagingRequest(
        LocationSource(
            apiService = api,
            name = name
        )
    )

    override fun getEpisode(name: String?): Flow<PagingData<EpisodeModel>> = makePagingRequest(
        EpisodeSource(
            apiService = api,
            name = name
            )
    )

}