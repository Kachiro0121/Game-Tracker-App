package com.kachiro.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.kachiro.game_api.GameListMediator

class HomeViewModel constructor(
    private val gameListMediator: GameListMediator
) : ViewModel() {

    init {
        gameScreen()
    }

    fun gameScreen() {
        gameListMediator.openScreenGameList()
    }
}