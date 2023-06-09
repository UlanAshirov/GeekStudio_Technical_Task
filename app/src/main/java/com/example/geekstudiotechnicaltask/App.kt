package com.example.geekstudiotechnicaltask

import android.app.Application
import com.example.data.remote.module.networkModule
import com.example.data.remote.module.repoModule
import com.example.domain.module.useCaseModule
import com.example.main.presentation.module.networkStateModule
import com.example.main.presentation.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(networkModule, repoModule, useCaseModule, viewModelModule, networkStateModule)
        }
    }
}