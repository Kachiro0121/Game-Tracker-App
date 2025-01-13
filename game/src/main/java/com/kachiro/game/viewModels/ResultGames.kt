package com.kachiro.game.viewModels

import androidx.annotation.StringRes

sealed class ResultGames{
    data class Success<T>(val model: T) : ResultGames()
    data class Error(val message: String?) : ResultGames()
    data class ErrorRes(@StringRes val message: Int) : ResultGames()
}
