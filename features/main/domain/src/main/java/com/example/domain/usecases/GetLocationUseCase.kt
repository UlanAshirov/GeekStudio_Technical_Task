package com.example.domain.usecase

import com.example.domain.repository.RickAndMortyRepository

class GetLocationUseCase(private val repository: RickAndMortyRepository) {
    operator fun invoke(name: String?) = repository.getLocation(name = name)
}