package com.example.main.presentation.module

import com.example.main.presentation.ui.fragments.character.CharactersViewModel
import com.example.main.presentation.ui.fragments.episode.EpisodeViewModel
import com.example.main.presentation.ui.fragments.location.LocationViewModel
import com.example.main.presentation.ui.fragments.pager.NetworkStateViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { CharactersViewModel(get()) }
    viewModel { EpisodeViewModel(get()) }
    viewModel { LocationViewModel(get()) }
    viewModel { NetworkStateViewModel() }
}