package com.example.testpendingintent.models

class StateSync(
   private val status: Status
) {
    private var hasBeenHandled = false
        private set
    fun updateIfNeed(): Status?{
        return if(hasBeenHandled){
            null
        }else{
            hasBeenHandled = true
            status
        }
    }

}

sealed class Status() {
    object Initial : Status()
    object Start : Status()
    object End : Status()
    data class Error(val message: String) : Status()
    data class Process(val message: String) : Status()
}
