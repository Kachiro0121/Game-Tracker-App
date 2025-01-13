package com.kachiro.game_catalog.viewModels

import androidx.annotation.StringRes

sealed class ResultState{
    data class Success<T>(val model: T) : ResultState()
    data class Error(val message: String?) : ResultState()
    data class ErrorRes(@StringRes val message: Int) : ResultState()
}
