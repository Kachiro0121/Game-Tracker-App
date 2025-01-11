package com.kachiro.game.halper

import com.kachiro.game_detail_api.GameDetailMediator
import javax.inject.Inject

class ActionHandlerImpl @Inject constructor(
    private val gameDetailMediator: GameDetailMediator
): ActionHandler {

    override fun openDetail(id: Int) {
        gameDetailMediator.openScreenDetailGame(id)
    }
}