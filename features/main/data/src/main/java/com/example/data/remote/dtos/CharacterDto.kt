package com.example.data.remote.dtos

import com.example.data.mapper.DataMapper
import com.example.domain.model.CharacterModel

data class CharacterDto(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val name: String,
    val species: String,
    val status: String,
    val type: String,
    val url: String
) : DataMapper<CharacterModel> {
    override fun toDomain() = CharacterModel(
        created = created,
        episode = episode,
        gender = gender,
        id = id,
        image = image,
        name = name,
        species = species,
        status = status,
        type = type,
        url = url
    )
}