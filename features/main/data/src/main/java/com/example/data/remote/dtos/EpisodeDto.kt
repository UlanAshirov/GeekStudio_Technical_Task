package com.example.data.remote.dtos

import com.example.data.mapper.DataMapper
import com.example.domain.model.EpisodeModel
import com.google.gson.annotations.SerializedName

data class EpisodeDto(
    val name: String,
    @SerializedName("air_date")
    val airDate: String,
    val episode: String,
    val characters: List<String>,
    val url: String,
    val created: String
) : DataMapper<EpisodeModel> {

    override fun toDomain() = EpisodeModel(
        name = name,
        airDate = airDate,
        episode = episode,
        characters = characters,
        url = url,
        created = created
    )
}