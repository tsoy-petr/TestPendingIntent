package com.example.testpendingintent.di

import androidx.work.WorkerParameters
import com.example.testpendingintent.SyncWork
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.workmanager.dsl.worker
import org.koin.dsl.module

val workModule = module {
    worker { (workerParams: WorkerParameters) ->
        SyncWork(
            context = androidContext(), params = workerParams
        )
    }
}