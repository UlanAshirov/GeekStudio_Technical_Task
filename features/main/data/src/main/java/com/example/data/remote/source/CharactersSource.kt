package com.example.data.remote.source

import com.example.data.base.BasePagingSource
import com.example.data.remote.apiservice.ApiService
import com.example.data.remote.dtos.CharacterDto
import com.example.domain.model.CharacterModel

class CharactersSource(
    private val apiService: ApiService,
    private val name: String?,
    private val status: String?,
    private val gender: String?,
    private val species: String?
) : BasePagingSource<CharacterDto, CharacterModel>({
    apiService.getCharacter(
        name = name,
        status = status,
        gender = gender,
        species = species,
        page = it
    )
}) {
}