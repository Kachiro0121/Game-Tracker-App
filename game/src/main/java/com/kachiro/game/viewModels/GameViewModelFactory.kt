package com.kachiro.game.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kachiro.game.repository.GameRepository
import javax.inject.Inject

class GameViewModelFactory @Inject constructor(
    private val repository: GameRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return GameViewModel(repository) as T
    }
}