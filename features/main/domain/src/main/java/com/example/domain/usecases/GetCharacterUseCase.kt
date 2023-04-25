package com.example.domain.usecase

import com.example.domain.repository.RickAndMortyRepository

class GetCharacterUseCase(private val repository: RickAndMortyRepository) {
    operator fun invoke(name: String?, status: String?, gender: String?, species: String?) =
        repository.getCharacter(name = name, status = status, gender = gender, species = species)
}