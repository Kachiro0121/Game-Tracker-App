package com.kachiro.game.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kachiro.game_api.GameRepository
import javax.inject.Inject

class GameViewModelFactory @Inject constructor(
    private val gameProvider: GameRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return GameViewModel(gameProvider) as T
    }
}