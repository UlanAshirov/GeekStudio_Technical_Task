package com.example.main.presentation.ui.fragments.location

import com.example.core.base.BaseViewModel
import com.example.domain.usecase.GetLocationUseCase
import com.example.main.presentation.model.toUI

class LocationViewModel(
    private val getLocationUseCase: GetLocationUseCase
) : BaseViewModel() {

    fun getLocation(name: String? = null) =
        getLocationUseCase(name = name).gatherPagingRequest { it.toUI() }
}