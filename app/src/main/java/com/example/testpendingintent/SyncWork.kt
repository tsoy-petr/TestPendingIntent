package com.example.testpendingintent

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.testpendingintent.models.StateSync
import com.example.testpendingintent.models.Status
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import timber.log.Timber

class SyncWork( context: Context,
               params: WorkerParameters
) : CoroutineWorker(context, params), KoinComponent {

    private val repository: Repository by inject()
    companion object {
        private val _state = MutableStateFlow<StateSync>( StateSync(Status.Initial) )
        val state = _state.asStateFlow()
    }

    override suspend fun doWork(): Result {

        Timber.i(repository.toString())

        _state.value =  StateSync(Status.Start)
        delay(5000)
        _state.value =  StateSync(Status.Process("Загрузка данных"))
        delay(15000)
        _state.value =  StateSync(Status.End)
        return Result.success()

    }
}
