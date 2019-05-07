package com.hubose.eniroapplication.common

import android.app.Application
import com.hubose.eniroapplication.di.*
import org.koin.android.ext.android.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(viewModels, dataModule, networkModule, useCases, mappers, utils))
    }
}