package com.example.main.presentation.model

import com.example.domain.model.EpisodeModel

data class EpisodeUI(
    val name: String,
    val airDate: String,
    val episode: String,
    val characters: List<String>,
    val url: String,
    val created: String
)

fun EpisodeModel.toUI() = EpisodeUI(
    name = name,
    airDate = airDate,
    episode = episode,
    characters = characters,
    url = url,
    created = created
)