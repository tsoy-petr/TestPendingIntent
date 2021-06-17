package com.example.testpendingintent

import android.app.Application
import com.example.testpendingintent.di.repoModule
import com.example.testpendingintent.di.workModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.workmanager.koin.workManagerFactory
import org.koin.core.KoinExperimentalAPI
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin
import timber.log.Timber

class App: Application(), KoinComponent {

    @KoinExperimentalAPI
    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                repoModule,
                workModule
            )
            workManagerFactory()
        }
    }
}