package com.example.testpendingintent.ui.main

import androidx.lifecycle.*
import com.example.testpendingintent.SyncWork
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class PageViewModel : ViewModel() {

    private val _index = MutableLiveData<Int>()
    val text: LiveData<String> = Transformations.map(_index) {
        "Hello world from section: $it"
    }

    fun setIndex(index: Int) {
        _index.value = index
    }
}