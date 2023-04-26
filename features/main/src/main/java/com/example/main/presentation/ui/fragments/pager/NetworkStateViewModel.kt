package com.example.main.presentation.ui.fragments.pager

import com.example.core.base.BaseViewModel
import com.example.main.presentation.utils.NetworkUtils
import kotlinx.coroutines.flow.Flow

class NetworkStateViewModel(listenNetwork: NetworkUtils) : BaseViewModel() {

    val isConnected: Flow<Boolean> = listenNetwork.isConnected
}