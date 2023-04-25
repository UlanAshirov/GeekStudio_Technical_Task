package com.example.main.presentation.ui.fragments.pager

import android.content.Context
import com.example.core.base.BaseViewModel
import com.example.main.presentation.utils.NetworkUtils

class NetworkStateViewModel : BaseViewModel() {

    fun networkState(context: Context): Boolean {
        return NetworkUtils.isInternetAvailable(context)
    }
}