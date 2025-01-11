package com.kachiro.game.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.kachiro.game.adapter.GameCardRecommendItem
import com.kachiro.game.adapter.GroupItem
import com.kachiro.game_api.GameRepository
import com.mikepenz.fastadapter.GenericItem
import com.mikepenz.fastadapter.listeners.ClickEventHook
import kotlinx.coroutines.Dispatchers

class GameViewModel(
    private val gameProvider: GameRepository
): ViewModel() {

    private val listPlatform = listOf("pc", "browser")

    val list = liveData(Dispatchers.IO) {
        try {
            val allGroupItem = gameProvider.getGamesByCategory(listPlatform)
            emit(allGroupItem)
        } catch (e: Exception) {
            emit(listOf())
        }
    }

}