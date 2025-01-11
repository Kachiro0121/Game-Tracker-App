package com.kachiro.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kachiro.game_api.GameListMediator
import javax.inject.Inject

class HomeViewModelFactory @Inject constructor(
    private val gameListMediator: GameListMediator
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeViewModel(gameListMediator) as T
    }
}