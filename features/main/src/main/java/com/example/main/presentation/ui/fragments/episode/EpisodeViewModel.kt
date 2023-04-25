package com.example.main.presentation.ui.fragments.episode

import com.example.core.base.BaseViewModel
import com.example.domain.usecase.GetEpisodeUseCase
import com.example.main.presentation.model.toUI

class EpisodeViewModel(
    private val getEpisodeUseCase: GetEpisodeUseCase
) : BaseViewModel() {

    fun getEpisode(name: String? = null) =
        getEpisodeUseCase(name = name).gatherPagingRequest { it.toUI() }
}