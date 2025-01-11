package com.kachiro.game_detail

import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.kachiro.game_detail_api.GameDetailMediator
import javax.inject.Inject

class GameDetailMediatorImpl @Inject constructor(
    private val router: Router
) : GameDetailMediator {

    private val detailGame = FragmentScreen{ GameDetailDialog.newInstance() }

    override fun openScreenDetailGame(id: Int) {
        router.navigateTo(detailGame)
    }

}