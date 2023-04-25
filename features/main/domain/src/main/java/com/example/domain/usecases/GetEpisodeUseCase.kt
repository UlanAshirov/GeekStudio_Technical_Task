package com.example.domain.usecase

import com.example.domain.repository.RickAndMortyRepository

class GetEpisodeUseCase(private val repository: RickAndMortyRepository) {
    operator fun invoke(name: String?) = repository.getEpisode(name = name)
}