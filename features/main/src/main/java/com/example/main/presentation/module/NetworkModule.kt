package com.example.main.presentation.module

import android.content.Context
import android.net.ConnectivityManager
import com.example.main.presentation.utils.NetworkUtils
import org.koin.dsl.module

val networkStateModule = module {
    factory { NetworkUtils(provideConnectivityManager(get())) }
}

fun provideConnectivityManager(context: Context): ConnectivityManager {
    return context.applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
}