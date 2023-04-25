package com.example.domain.repository

import androidx.paging.PagingData
import com.example.domain.model.CharacterModel
import com.example.domain.model.EpisodeModel
import com.example.domain.model.LocationModel
import kotlinx.coroutines.flow.Flow

interface RickAndMortyRepository {
    fun getCharacter(
        name: String?,
        status: String?,
        gender: String?,
        species: String?
    ): Flow<PagingData<CharacterModel>>

    fun getLocation(name: String?): Flow<PagingData<LocationModel>>

    fun getEpisode(name: String?): Flow<PagingData<EpisodeModel>>
}