package com.example.data.remote.module

import com.example.data.remote.RickAndMortyRepositoryImpl
import com.example.domain.repository.RickAndMortyRepository
import org.koin.dsl.module

val repoModule = module {
    single<RickAndMortyRepository> { RickAndMortyRepositoryImpl(get()) }
}