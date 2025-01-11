package com.kachiro.game.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.kachiro.game.repository.GameRepository
import kotlinx.coroutines.Dispatchers

class GameViewModel(
    private val repository: GameRepository
): ViewModel() {

    private val listPlatform = listOf("pc", "browser")

    val list = liveData(Dispatchers.IO) {
        try {
            val allGroupItem = repository.getGamesByCategory(listPlatform)
            emit(allGroupItem)
        } catch (e: Exception) {
            emit(listOf())
        }
    }

}